package tetrisV8;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.util.Arrays;
import java.lang.Runnable;

class HandPrimary implements Runnable {
    public HandPrimary(Robot r) throws AWTException{
        handRobot = r;
        handRobot.setAutoWaitForIdle(true);
    }
    
    /**Takes in an array of 4 ints: 
    * [held or current, num. Rotations, num. Left, num. Right]
    * and executes appropriate keystrokes*/
    public void run() {
        int topRowSlowDown = (__topRow < 8)?20:12;
        // long p = System.currentTimeMillis();
        handRobot.delay(10);
        if (__moves[0] == 1) {
            handRobot.keyPress(KeyEvent.VK_SHIFT);
            handRobot.delay(70);
            handRobot.keyRelease(KeyEvent.VK_SHIFT);
        }
        handRobot.delay(60);
        if (__moves[1] < 3) {
            if (__moves[1] == -1) {
                handRobot.keyPress(KeyEvent.VK_UP);
                handRobot.delay(60);
                handRobot.keyRelease(KeyEvent.VK_UP);
                handRobot.delay(62);
            } else {
                for (int rot = 0; rot < __moves[1]; rot++) {
                    handRobot.keyPress(KeyEvent.VK_UP);
                    handRobot.delay(60);
                    handRobot.keyRelease(KeyEvent.VK_UP);
                    handRobot.delay(60);
                }
            }
        } else {
            handRobot.keyPress(KeyEvent.VK_Z);
            handRobot.delay(60);
            handRobot.keyRelease(KeyEvent.VK_Z);
            handRobot.delay(60);
        }
        
        if (__moves[2] == 10 || __moves[2] == 11) {
            int eoff = (__moves[2] == 11) ? 10 : 0;
            handRobot.keyPress(KeyEvent.VK_LEFT);
            handRobot.delay(242+topRowSlowDown+eoff);
            handRobot.keyRelease(KeyEvent.VK_LEFT);
        } else if (__moves[2] == 9) {
            handRobot.keyPress(KeyEvent.VK_LEFT);
            handRobot.delay(242+topRowSlowDown);
            handRobot.keyRelease(KeyEvent.VK_LEFT);
            handRobot.delay(62);
            handRobot.keyPress(KeyEvent.VK_RIGHT);
            handRobot.delay(62);
            handRobot.keyRelease(KeyEvent.VK_RIGHT);
        } else {
            for (int left = 0; left < __moves[2]; left++) {
                handRobot.keyPress(KeyEvent.VK_LEFT);
                handRobot.delay(62);
                handRobot.keyRelease(KeyEvent.VK_LEFT);
                handRobot.delay(62);
            }
        }
        
        if (__moves[3] == 10) {
            handRobot.keyPress(KeyEvent.VK_RIGHT);
            handRobot.delay(242+topRowSlowDown);
            handRobot.keyRelease(KeyEvent.VK_RIGHT); 
            handRobot.delay(62);
        } else if (__moves[3] == 9) {
            handRobot.keyPress(KeyEvent.VK_RIGHT);
            handRobot.delay(242+topRowSlowDown);
            handRobot.keyRelease(KeyEvent.VK_RIGHT);
            handRobot.delay(62);
            handRobot.keyPress(KeyEvent.VK_LEFT);
            handRobot.delay(62);
            handRobot.keyRelease(KeyEvent.VK_LEFT);
            handRobot.delay(62);
        } else {
            for (int right = 0; right < __moves[3]; right++) {
                handRobot.keyPress(KeyEvent.VK_RIGHT);
                handRobot.delay(62);
                handRobot.keyRelease(KeyEvent.VK_RIGHT);
                handRobot.delay(62);
            }
        }
        handRobot.keyPress(KeyEvent.VK_SPACE);
        handRobot.delay(60);
        handRobot.keyRelease(KeyEvent.VK_SPACE);
        handRobot.delay(60);
        // System.out.println(System.currentTimeMillis() - p);
    }
    
    void updateMoves(int[] moves) {
        __moves = moves;
    }
    
    void updateTopRow(int topRow) {
        __topRow = topRow;
    }
    
    int[] __moves;
    Robot handRobot;
    int __topRow;
}