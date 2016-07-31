package tetrisV8;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import static tetrisV8.Block.*;
import static tetrisV8.Piece.*;

// import java.util.Date;

class Tetrabot {

    public static void main(String[] args) {
        try {
            Robot rEye = new Robot();
            Robot rHand = new Robot();
            Eye eye = new Eye(rEye, args);
            Brain brain = new Brain();
            HandPrimary handP = new HandPrimary(rHand);
            HandSecondary handS = new HandSecondary(rHand);
            
            eye.calibrate();
            
            eye.update();
            Piece[] queue = eye.readQueue();
            Piece current = queue[0];
            Piece held = eye.readHeld();
            Block[][] rowStack = eye.readRowStack();
            int topRow = eye.topRow();
            boolean extLeftBlocked = false;
            boolean extRightBlocked = false;
            
            int strat = 1;
            
            brain.update(queue, current, held, rowStack, extLeftBlocked, extRightBlocked);
            int[] moves = brain.generateMoves(strat, 1);
            
            Piece currentSim;// = queue[0];
            Piece[] queueSim;// = {queue[1], queue[2], queue[3], queue[4]};
            Piece heldSim;// = (moves[0] == 0)?held:current;
            Block[][] rowStackSim;// = brain.simRS();
            boolean extLeftBlockedSim = false;
            boolean extRightBlockedSim = false;
            
            long t = System.currentTimeMillis();
            Thread hS = null;
            Thread hP = null;

            long a, o;
            //int stratCount = 0;
            boolean initialRush = true;
            
            while (true) {
                a = (System.currentTimeMillis()-t);
                
                if (topRow < 4) {
                    handS.updateMoves(moves);
                    hS = new Thread(handS);
                    hS.start();
                } else {
                    handP.updateTopRow(topRow);
                    handP.updateMoves(moves);
                    hP = new Thread(handP);
                    hP.start();
                }
                currentSim = queue[0];
                queueSim = new Piece[] {queue[1], queue[2], queue[3], queue[4]};
                heldSim = (moves[0] == 0)?held:current;
                rowStackSim = brain.simRS();
                extLeftBlockedSim = extLeftBlocked(rowStackSim);
                extRightBlockedSim = extRightBlocked(rowStackSim);
                brain.update(queueSim, currentSim, heldSim, rowStackSim, extLeftBlockedSim, extRightBlockedSim);
                int prevDContKill = brain.dContKill;
                if (topRow < 2) {
                    moves = brain.generateMoves(strat, 1);
                } else {
                    moves = brain.generateMoves(strat, 2);
                }
                try {
                    if (hS != null) {
                        hS.join();
                    }
                    if (hP != null) {
                        hP.join();
                    }
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                
                
                eye.update();
                current = queue[0];
                held = eye.readHeld();
                rowStack = eye.readRowStack();
                topRow = eye.topRow();
                queue = eye.readQueue();

                int LRDif = topRight2(rowStack) - topLeft7(rowStack);
                if (topRow >= 17 && brain.dContKill < 3) {
                    strat = 1;      //consider only left 7 pieces // 1
                } else if (LRDif > 13
                    || (LRDif > 6 && !initialRush)
                        || (topSolid(rowStack) < 18 && LRDif > 3)
                            || (eye.warning() && LRDif > 3)) {
                    initialRush = false;
                    strat = 0;      //consider only right 3 pieces // 2
                } else if ((topSolid(rowStack) - topRow < 5) && (topSolid(rowStack) != 20)
                            || eye.warning()
                                || LRDif < 4
                                    || (System.currentTimeMillis() - t > 110000)) {
                    initialRush = false;
                    strat = 0;      //consider all pieces
                }
                    
                if (queue[0] != queueSim[0]
                        || queue[1] != queueSim[1]
                            || current != currentSim
                                || held != heldSim
                                    || !congrRS(rowStack, rowStackSim)
                                        || extLeftBlocked != extLeftBlockedSim
                                            || extRightBlocked != extRightBlockedSim) {
                    System.out.println("FAILURE");
                    brain.dContKill = prevDContKill; //usually when board isn't expected board,
                                                    //it's due to sent lines
                    extLeftBlocked = extLeftBlocked(rowStack);
                    extRightBlocked = extRightBlocked(rowStack);
                    brain.update(queue, current, held, rowStack, extLeftBlocked,
                        extRightBlocked);
                    moves = brain.generateMoves(strat, 1);
                    
                }
                if ((topSolid(rowStack) - topSolid(rowStackSim)) > 5) {
                    rHand.delay(160);
                }
                o = (System.currentTimeMillis()-t);

            }
        } catch(AWTException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
    
    
    static boolean congrRS(Block[][] rs1, Block[][] rs2) {
        int rs1Top = 0;
        int rs2Top = 0;
        for (int row = 0; row < 20 && (rs1Top == 0 || rs2Top == 0); row++) {
            for (int col = 0; col < 10; col++) {
                if (rs1Top == 0 && rs1[row][col] != EMPTY) {
                    rs1Top = row;
                }
                if (rs2Top == 0 && rs2[row][col] != EMPTY) {
                    rs2Top = row;
                }
            }
        }
        int rowDif = rs2Top - rs1Top;
        for (int row = Math.max(rs1Top, rs2Top); (row+rowDif) < 20; row++) {
            for (int col = 0; col < 10; col++) {
                if (rs1[row][col] != rs2[row+rowDif][col]) {
                    return false;
                }
            }
            if (rs1[row][0] == SOLID || rs1[row][0] == BOMB
                || rs2[row][0] == SOLID || rs2[row][0] == BOMB) {
                break;
            }
        }
        if ((rs1[17][0] == SOLID || rs1[17][0] == BOMB)
                && (rs2[17][0] == SOLID || rs2[17][0] == BOMB)) {
            return true;
        } else if (Math.abs(rowDif) < 4) {
            return true;
        } else {
            return false;
        }
    }
    
    static boolean extLeftBlocked(Block[][] rowStack) {
        return (rowStack[0][0] == COLORED) 
            || (rowStack[1][0] == COLORED);
    }
    
    static boolean extRightBlocked(Block[][] rowStack) {
        return (rowStack[0][9] == COLORED) 
            || (rowStack[1][9] == COLORED);
    }
    
    static int topSolid(Block[][] rs) {
        for (int row = 0; row < 20; row++) {
            if (rs[row][0] == SOLID || rs[row][0] == BOMB) {
                return row;
            }
        }
        return 20;
    }
    
    static int topLeft7(Block[][] rs) {
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 7; col++) {
                if (rs[row][col] != EMPTY) {
                    return row;
                }
            }
        }
        return 20;
    }
    
    static int topRight2(Block[][] rs) {
        for (int row = 0; row < 20; row++) {
            for (int col = 8; col < 10; col++) {
                if (rs[row][col] != EMPTY) {
                    return row;
                }
            }
        }
        return 20;
    }
}


