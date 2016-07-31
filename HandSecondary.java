package tetrisV8;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.util.Arrays;
import java.lang.Runnable;

class HandSecondary implements Runnable {
    public HandSecondary(Robot r) throws AWTException{
        handRobot = r;
        handRobot.setAutoWaitForIdle(true);
    }
    
    /**Takes in an array of 4 ints: 
    * [held or current, num. Rotations, num. Left, num. Right]
    * and executes appropriate keystrokes*/
    public void run() {
    
        handRobot.delay(40);
        // long p = System.currentTimeMillis();
        if (__moves[0] == 1) {
            handRobot.keyPress(KeyEvent.VK_SHIFT);
            handRobot.delay(75);
            handRobot.keyRelease(KeyEvent.VK_SHIFT);
            handRobot.delay(70);
        }      
        
        //MOVE 1
        //full right/left
        if (__moves[2] == 10 || __moves[2] == 11) {
            handRobot.keyPress(KeyEvent.VK_LEFT);
            handRobot.delay(220);
            handRobot.keyRelease(KeyEvent.VK_LEFT);
        } else if (__moves[2] == 9) {
            handRobot.keyPress(KeyEvent.VK_LEFT);
            handRobot.delay(220);
            handRobot.keyRelease(KeyEvent.VK_LEFT);
        } else if (__moves[3] == 10) {
            handRobot.keyPress(KeyEvent.VK_RIGHT);
            handRobot.delay(220);
            handRobot.keyRelease(KeyEvent.VK_RIGHT); 
        } else if (__moves[3] == 9) {
            handRobot.keyPress(KeyEvent.VK_RIGHT);
            handRobot.delay(220);
            handRobot.keyRelease(KeyEvent.VK_RIGHT);
        //greater than or equal to 2
        } else if (__moves[2] >= 2) {
            for (int left = 0; left < 2; left++) {
                handRobot.keyPress(KeyEvent.VK_LEFT);
                handRobot.delay(60);
                handRobot.keyRelease(KeyEvent.VK_LEFT);
                handRobot.delay(60);
            }
        } else if (__moves[3] >= 2) {
            for (int right = 0; right < 2; right++) {
                handRobot.keyPress(KeyEvent.VK_RIGHT);
                handRobot.delay(60);
                handRobot.keyRelease(KeyEvent.VK_RIGHT);
                handRobot.delay(60);
            }
        //NORMALS
        } else {
            for (int left = 0; left < __moves[2]; left++) {
                handRobot.keyPress(KeyEvent.VK_LEFT);
                handRobot.delay(60);
                handRobot.keyRelease(KeyEvent.VK_LEFT);
                handRobot.delay(60);
            }
            for (int right = 0; right < __moves[3]; right++) {
                handRobot.keyPress(KeyEvent.VK_RIGHT);
                handRobot.delay(60);
                handRobot.keyRelease(KeyEvent.VK_RIGHT);
                handRobot.delay(60);
            }
        }
        handRobot.delay(60);

        
        //ROTATION
        if (__moves[1] < 3) {
            if (__moves[1] == -1) {
                handRobot.delay(60);
                handRobot.keyPress(KeyEvent.VK_UP);
                handRobot.delay(65);
                handRobot.keyRelease(KeyEvent.VK_UP);
                handRobot.delay(60);
            } else {
                for (int rot = 0; rot < __moves[1]; rot++) {
                    handRobot.delay(60);
                    handRobot.keyPress(KeyEvent.VK_UP);
                    handRobot.delay(65);
                    handRobot.keyRelease(KeyEvent.VK_UP);
                    handRobot.delay(58);
                }
            }
        } else {
            handRobot.keyPress(KeyEvent.VK_Z);
            handRobot.delay(60);
            handRobot.keyRelease(KeyEvent.VK_Z);
            handRobot.delay(58);
        }
        
        
        //REMAINDER
        if (__moves[2] == 11) {
            handRobot.keyPress(KeyEvent.VK_LEFT);
            handRobot.delay(170);
            handRobot.keyRelease(KeyEvent.VK_LEFT);
            // handRobot.delay(60);
        } else if (__moves[2] == 10) {
            handRobot.keyPress(KeyEvent.VK_LEFT);
            handRobot.delay(160);
            handRobot.keyRelease(KeyEvent.VK_LEFT);
            // handRobot.delay(60);
        } else if (__moves[2] == 9) {
            handRobot.keyPress(KeyEvent.VK_LEFT);
            handRobot.delay(140);
            handRobot.keyRelease(KeyEvent.VK_LEFT);
            handRobot.delay(60);
            handRobot.keyPress(KeyEvent.VK_RIGHT);
            handRobot.delay(60);
            handRobot.keyRelease(KeyEvent.VK_RIGHT);
        } else if (__moves[3] == 10) {
            handRobot.keyPress(KeyEvent.VK_RIGHT);
            handRobot.delay(140);
            handRobot.keyRelease(KeyEvent.VK_RIGHT); 
            // handRobot.delay(60);
        } else if (__moves[3] == 9) {
            handRobot.keyPress(KeyEvent.VK_RIGHT);
            handRobot.delay(140);
            handRobot.keyRelease(KeyEvent.VK_RIGHT);
            handRobot.delay(60);
            handRobot.keyPress(KeyEvent.VK_LEFT);
            handRobot.delay(60);
            handRobot.keyRelease(KeyEvent.VK_LEFT);
        } else if (__moves[2] >= 2 || __moves[3] >= 2) {
            int movesLeft = (__moves[2] >= 2)?__moves[2]-2:__moves[2];
            for (int left = 0; left < movesLeft; left++) {
                handRobot.keyPress(KeyEvent.VK_LEFT);
                handRobot.delay(60);
                handRobot.keyRelease(KeyEvent.VK_LEFT);
                handRobot.delay(60);
            }
            int movesRight = (__moves[3] >= 2)?__moves[3]-2:__moves[3];
            for (int right = 0; right < movesRight; right++) {
                handRobot.keyPress(KeyEvent.VK_RIGHT);
                handRobot.delay(60);
                handRobot.keyRelease(KeyEvent.VK_RIGHT);
                handRobot.delay(60);
            }
        }
        handRobot.delay(50);
        handRobot.keyPress(KeyEvent.VK_SPACE);
        handRobot.delay(60);
        handRobot.keyRelease(KeyEvent.VK_SPACE);
        handRobot.delay(60);
        // System.out.println(System.currentTimeMillis() - p);
    }
    
    void updateMoves(int[] moves) {
        __moves = moves;
    }

    int[] __moves;
    Robot handRobot;
}