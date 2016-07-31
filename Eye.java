package tetrisV8;

import java.util.Arrays;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.event.InputEvent;
import static tetrisV8.Block.*;
import static tetrisV8.Piece.*;


class Eye {
    public Eye(Robot r, String[] args) throws AWTException {
        __args = args;
        eyeRobot = r;
        eyeRobot.setAutoWaitForIdle(true);
        screenRect = new Rectangle(1366, 768);
        screenImage = eyeRobot.createScreenCapture(screenRect);

    }
    
    void calibrate() {
        eyeRobot.mouseMove(467, 380);
        eyeRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        eyeRobot.delay(50);
        eyeRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
     
        eyeRobot.mouseWheel(-20);
        eyeRobot.delay(120);
        eyeRobot.mouseWheel(3);
        
        eyeRobot.delay(30);
        
        /**Allow user to specify upper-left corner of tetris game board*/
        /*JFrame frame = new JFrame();
        frame.setBounds(screenRect); 
        frame.setVisible(true);
        MouseCalibrator calibrator = new MouseCalibrator();
        frame.addMouseListener(calibrator);
        ImageIcon screenIcon = new ImageIcon(screenImage);
        JLabel screenLabel = new JLabel(screenIcon);
        frame.add(screenLabel);
        while (baseY == -1) {
            baseX = calibrator.baseCalX;
            baseY = calibrator.baseCalY;
        }
        // baseY -= 11; //take into account JFrame image and actual screenImage
        frame.dispose();*/
        // baseY = 328; // just for Tetris friends... the above somehow died for baseY
        
        baseX = 190;//260;//260;
        baseY = 222;//276;//272;//baseY = 268;, suddenly changed...
        
        if (__args.length > 0) {
            baseX = Integer.parseInt(__args[0]);
            baseY = Integer.parseInt(__args[1]);
        }
        
        if (__args.length > 0 && __args[0].equals("-adX")) {
            baseX += 80;
        }
        if (__args.length > 0 && __args[0].equals("-adY")) {
            baseY += 50;
        }
        if (__args.length > 0 && __args[0].equals("-smallY")) {
            baseY -= 24;
        }
        
        if (__args.length > 0 && __args[0].equals("-ad")) {
            eyeRobot.mouseWheel(1);
            baseX += 80;
            baseY += 4;
        }
        
        eyeRobot.mouseMove(baseX + 207, baseY + 112);
        eyeRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        eyeRobot.delay(50);
        eyeRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        
        eyeRobot.keyPress(KeyEvent.VK_SHIFT);
        eyeRobot.delay(50);
        eyeRobot.keyRelease(KeyEvent.VK_SHIFT);
        
        eyeRobot.delay(100);
    }
    
    /**Update the image of the screen that the EYE works with*/
    void update() {
        eyeRobot.delay(220);
        screenImage = eyeRobot.createScreenCapture(screenRect);
        eyeRobot.delay(50);
    }

    /**Return an arraylist of pieces stored in current queue*/
    Piece[] readQueue() {
        return new Piece[] {idPiece0(), idPiece1(), idPiece2(), idPiece3(), 
        idPiece4()};
        
    }
    
    /**Return  piece that is being held*/
    Piece readHeld() {
        int color = screenImage.getRGB(baseX - 42, baseY + 51);
        switch (color) {
            case 0xFFFFD93B:
                return SQ_44;
            case 0xFF447CFF:
                return RL0_34;
            case 0xFFE84CC9:
                return T0_34;
            case 0xFF86EA33:
                return S0_34;
            case 0xFFFF435C:
                return Z0_34;
            case 0xFFFF9C23:
                return L0_34;
            case 0xFF2CD1FF:
                return I0_33;
            default:
                System.out.printf("nuoooo: held!! : %h\n", color);
                update();
                return readHeld();
        }
    }
    
    /**Return current configuration of blocks on rowStack without inclusion
    *of current piece*/
    Block[][] readRowStack() {
        Block[][] rowStack = new Block[20][10];
        boolean topSet = false;
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 10; col++) {
                if ((row == 0) && (col >= 3) && (col < 7)) {
                    rowStack[row][col] = EMPTY;
                } else {
                    rowStack[row][col] = idBlock(baseX+12+18*col, baseY+13+18*row);
                }
                if (!topSet && (rowStack[row][col] == COLORED)) {
                    __topRow = row;
                    topSet = true;
                }
            } 
        }
        return rowStack;
    }

    
    
    boolean warning() {
        for (int i = 0; i < 10; i++) {
            if (idBlock(baseX+392+18*i, baseY+96) != EMPTY
                && idBlock(baseX+392+18*i, baseY+114) != EMPTY
                    && idBlock(baseX+392+18*i, baseY+132) != EMPTY) {
                return true;
            }
        }
        /*int color = screenImage.getRGB(baseX + 190, baseY + 240);
        if ((color != 0xff2f2f2f) && (color != 0xff222222)) {
            return true;
        }*/
        return false;
    }
    
    boolean koWin() {
        boolean ownKO = screenImage.getRGB(baseX-25, baseY+132) == 0xffff0000;
        boolean oppKO = screenImage.getRGB(baseX+357, baseY+132) == 0xffff0000;
        if (ownKO && !oppKO) {
            return true;
        }
        return false;
    }
    
    Piece idPiece0() {
        int color = screenImage.getRGB(baseX + 228, baseY + 53);
        switch (color) {
            case 0xFFFFC225:
                return SQ_44;
            case 0xFF447CFF:
                return RL0_34;
            case 0xFFE84CC9:
                return T0_34;
            case 0xFF86EA33:
                return S0_34;
            case 0xFFFF435C:
                return Z0_34;
            case 0xFFFF9C23:
                return L0_34;
            case 0xFF2CD1FF:
                return I0_33;
            default:
                System.out.println("nuoooo: 0!!");
                return I0_33;
        }
    }
            
            
            
    
    
    Piece idPiece1() {
        int color = screenImage.getRGB(baseX + 230, baseY + 118);
        switch (color) {
            case 0xFFFFD93B:
                return SQ_44;
            case 0xFF549AFF:
                return RL0_34;
            case 0xFFF65DDC:
                return T0_34;
            case 0xFFA7FA3B:
                return S0_34;
            case 0xFFFF7194:
                return Z0_34;
            case 0xFFFFB751:
                return L0_34;
            case 0xFF2CD1FF:
                return I0_33;
            default:
                System.out.println("nuoooo: 1!!");
                return I0_33;
        }
    }
    
    
    
    
    Piece idPiece2() {
        int color = screenImage.getRGB(baseX + 230, baseY + 173);
        switch (color) {
            case 0xFFFFD93B:
                return SQ_44;
            case 0xFF549AFF:
                return RL0_34;
            case 0xFFF65DDC:
                return T0_34;
            case 0xFFA7FA3B:
                return S0_34;
            case 0xFFFF7194:
                return Z0_34;
            case 0xFFFFB751:
                return L0_34;
            case 0xFF2CD1FF:
                return I0_33;
            default:
                System.out.println("nuoooo: 1!!");
                return I0_33;
        }
    }
    
    Piece idPiece3() {
        int color = screenImage.getRGB(baseX + 230, baseY + 225);
        switch (color) {
            case 0xFFFFD93B:
                return SQ_44;
            case 0xFF549AFF:
                return RL0_34;
            case 0xFFF65DDC:
                return T0_34;
            case 0xFFA7FA3B:
                return S0_34;
            case 0xFFFF7194:
                return Z0_34;
            case 0xFFFFB751:
                return L0_34;
            case 0xFF2CD1FF:
                return I0_33;
            default:
                System.out.println("nuoooo: 1!!");
                return I0_33;
        }
    }
    
    Piece idPiece4() {
        int color = screenImage.getRGB(baseX + 230, baseY + 277);
        switch (color) {
            case 0xFFFFD93B:
                return SQ_44;
            case 0xFF549AFF:
                return RL0_34;
            case 0xFFF65DDC:
                return T0_34;
            case 0xFFA7FA3B:
                return S0_34;
            case 0xFFFF7194:
                return Z0_34;
            case 0xFFFFB751:
                return L0_34;
            case 0xFF2CD1FF:
                return I0_33;
            default:
                System.out.println("nuoooo: 1!!");
                return I0_33;
        }
    }

    
    /**Returns piece that is present at pixel specified at x, y*/
    Piece idPiece(int x, int y) {
        int color = screenImage.getRGB(x, y);
        switch (color) {
            case 0xFF4464E9:
                ////System.out.println("RL");
                return RL0_34;
            case 0xFF549AFF: //TENTATIE
                ////System.out.println("RL");
                return RL0_34;
            case 0xFF447CFF: //TENTATIE
                ////System.out.println("RL");
                return RL0_34;
            case 0xFFFA325A:
                ////System.out.println("A");
                return Z0_34;
            case 0xFFEA3156:
            ////System.out.println("B");
                return Z0_34;
            case 0xFFB22340:
            ////System.out.println("C");
                return Z0_34;             
            case 0xFFFF7194:    //tentative 
                ////System.out.println("D");
                return Z0_34;       
            case 0xFFFF435C:    //tentative
                ////System.out.println("E");
                return Z0_34;
            case 0xFF7CD424:
                ////System.out.println("S0, 111");
                return S0_34;
            case 0xFF78C030:
                ////System.out.println("S0, 222");
                return S0_34;
            case 0xFF86EA33:
                ////System.out.println("S0, 333");
                return S0_34;
            case 0xFF558922:
                ////System.out.println("S0, 444");
                return S0_34;
            case 0xFFD24CAD:
                ////System.out.println("T0, 111");
                return T0_34;
            case 0xFFBD44AC:
                ////System.out.println("T0, 222");
                return T0_34;
            case 0xFFE84CC9:
                ////System.out.println("T0, 333");
                return T0_34;
            case 0xFFF65DDC:
                ////System.out.println("T0, 444");
                return T0_34;
            case 0xFFFF7E25:
                ////System.out.println("P");
                return L0_34;
            case 0xFFFF9900:
                ////System.out.println("Q");
                return L0_34;
            case 0xFFFFB751:    //tentative
                ////System.out.println("R");
                return L0_34;
            case 0xFFFF9C23:
                ////System.out.println("S");
                return L0_34;   //tentative
            case 0xFFFFC225:
                ////System.out.println("SQ11");
                return SQ_44;
            case 0xFFFFB125:
                ////System.out.println("SQ22");
                return SQ_44;

            case 0xFFFFD93B:
                ////System.out.println("SQ44");
                return SQ_44;   //tentative

            // case 0xFFBC8923:
                // return SQ_44;   //Tentative
            case 0xFFFFEA4C:
                return SQ_44;   //tentative
            default:
                // //System.out.printf("AT DEFAULT: %h\n", color);
                return I0_33;
        }
    }
    
    /**Returns the type of block that is at pixel <x, y>*/
    Block idBlock(int x, int y) {
        int color = screenImage.getRGB(x, y);
        switch(color) {
            case 0xFF2B2B2B:
                return EMPTY;
            case 0xFF2F2F2F:
                return EMPTY;
            case 0xFF9A9A9A:
                return SOLID;
            case 0xFFBCBCBC:
                return SOLID;
            case 0xFF797979:
                return SOLID;
            case 0xFF5E5E5E:
                return SOLID;
            case 0xFF4B4B4B:
                return SOLID;
            case 0xFF000000:
                return BOMB;
            case 0xFF222222:
                return BOMB;
            case 0xFF0B0B0B:
                return BOMB;
            case 0xFF0A0A0A:
                return BOMB;
            case 0xFFFFFF00:
                return BOMB;
            case 0xFFFF9900:
                return BOMB;
            case 0xFFFF3300:
                return BOMB;
            default:
                return COLORED;
        }
    }


    
    int topRow() {
        return __topRow;
    }
    
    public String toString() {
        return "baseX: " + baseX + ",\tbaseY: " + baseY;
    }

    String[] __args;
    Robot eyeRobot;
    Rectangle screenRect;
    BufferedImage screenImage;
    int baseX = -1;
    int baseY = -1;
    int __topRow = 19;
}
    
    
    
    
    
    
    
    