package tetrisV8;

import java.awt.event.*;
import java.awt.*;

class MouseCalibrator implements MouseListener {

    public void mouseClicked(MouseEvent e) {
        try {
            baseCalX = (int) MouseInfo.getPointerInfo().getLocation().getX();
            baseCalY = (int) MouseInfo.getPointerInfo().getLocation().getY();
            System.out.printf("(%d, %d)\n", baseCalX, baseCalY);
        } catch (HeadlessException err) {
            System.err.println(err.getMessage());
            System.exit(1);
        }
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    
    int baseCalX = -1;
    int baseCalY = -1;
}
