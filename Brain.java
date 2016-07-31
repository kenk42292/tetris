package tetrisV8;

import java.util.Arrays;
import java.util.ArrayList;
import static tetrisV8.Block.*;

class Brain {
    
    /**Updates the brain's view of the __current configuration of the game*/
    void update(Piece[] queue, Piece current,
        Piece held, Block[][] rowStack,
            boolean extLeftBlocked, boolean extRightBlocked) {
        __current = current;
        __queue = queue;
        __held = held;
        __rowStack = rowStack;
        __extLeftBlocked = extLeftBlocked;
        __extRightBlocked = extRightBlocked;
        subBrain0 = new SubBrain();
        subBrain1 = new SubBrain();
        subBrain2 = new SubBrain();
        subBrain3 = new SubBrain();
    }

    /**Return array of four ints that represents:
    * [__held/__current, num. rotations, num. left, num. right]
    * according to evalRowStack*/
    int[] generateMoves(int strat, int numMoves) {
        Piece bestPiece = Piece.I0_33;
        int bestContKill = 0;

        int[] bestScores = new int[4];
        Piece[] bestPieces = new Piece[4];
        Block[][][] simRSArray = new Block[4][][];
        
        if (__current.relatedPieces()[strat].length >= __held.relatedPieces()[strat].length) {
            subBrain0.update(bestPieces, bestScores, simRSArray, 0,
                __current.relatedPieces()[strat], __rowStack, __queue, __held, strat, numMoves, dContKill);
            sB0 = new Thread(subBrain0);
            sB0.start();
            
            subBrain1.update(bestPieces, bestScores, simRSArray, 1,
                __current.relatedPieces()[strat], __rowStack, __queue, __held, strat, numMoves, dContKill);
            sB1 = new Thread(subBrain1);
            sB1.start();

        }
        
        subBrain2.update(bestPieces, bestScores, simRSArray, 2,
            __held.relatedPieces()[strat], __rowStack, __queue, __current, strat, numMoves, dContKill);
        sB2 = new Thread(subBrain2);
        sB2.start();
        
        
        subBrain3.update(bestPieces, bestScores, simRSArray, 3,
            __held.relatedPieces()[strat], __rowStack, __queue, __current, strat, numMoves, dContKill);
        sB3 = new Thread(subBrain3);
        sB3.start();

 

        if (__current.relatedPieces()[strat].length < __held.relatedPieces()[strat].length) {
            subBrain0.update(bestPieces, bestScores, simRSArray, 0,
                __current.relatedPieces()[strat], __rowStack, __queue, __held, strat, numMoves, dContKill);
            sB0 = new Thread(subBrain0);
            sB0.start();
            
            subBrain1.update(bestPieces, bestScores, simRSArray, 1,
                __current.relatedPieces()[strat], __rowStack, __queue, __held, strat, numMoves, dContKill);
            sB1 = new Thread(subBrain1);
            sB1.start();

        }
        
        
        
        try {
            sB0.join();
            sB1.join();
            sB2.join();
            sB3.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        //at this point, have int[] of 2 bestScores and int[] of 2 bestPieces
        int bestScore = -100000;
        int bestIndex = 0;
        
        
        for (int i = 0; i < 4; i++) {
            if (bestScores[i] >= bestScore) {
                bestScore = bestScores[i];
                bestIndex = i;
            }
        }
        
        __simRS = simRSArray[bestIndex];
        switch (bestIndex) {
            case 0:
                dContKill = subBrain0.dContKill;
                break;
            case 1:
                dContKill = subBrain1.dContKill;
                break;
            case 2:
                dContKill = subBrain2.dContKill;
                break;
            default:
                dContKill = subBrain3.dContKill;
        }
        
        int[] moveToReturn =  new int[] {((bestIndex < 2) ? 0 : 1),
            bestPieces[bestIndex].getMove()[0],
            bestPieces[bestIndex].getMove()[1],
            bestPieces[bestIndex].getMove()[2]};
        
        if (__extLeftBlocked && moveToReturn[2] == 9) {
            moveToReturn[2] = 10;
        } else if (__extLeftBlocked && moveToReturn[3] == 9) {
            moveToReturn[3] = 10;
        }
        
        return moveToReturn;
    }

    
    Block[][] simRS() {
        return __simRS;
    }
    
    /**Number of steps AI looks into the future in order to derive list of moves*/
    Piece[] __queue = null;
    Piece __current = Piece.NULLPIECE;
    Piece __held = Piece.NULLPIECE;
    Block[][] __rowStack = null;
    int __numMoves;
    SubBrain subBrain0;
    SubBrain subBrain1;
    SubBrain subBrain2;
    SubBrain subBrain3;
    /**Number of kills that happened continuously before*/
    int dContKill = 0;
    Block[][] __simRS = null;
    
    boolean __extLeftBlocked = false;
    boolean __extRightBlocked = false;
    
    Thread sB0 = null;
    Thread sB1 = null;
    Thread sB2 = null;
    Thread sB3 = null;
    
}
    