package gui.screen.mouselistener;

import gui.screen.Screen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static util.Constant.*;

public class ScreenDragger implements MouseMotionListener, MouseListener {

    private int oldDragX;
    private int oldDragY;
    private int posClickX;
    private int posClickY;
    private Screen screen;

    public ScreenDragger(Screen s){
        oldDragX = 0;
        oldDragY = 0;
        screen = s;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(screen.isHavetitlebar()) {
            if (oldDragX != 0 && oldDragY != 0) {
                int moveX = oldDragX - e.getXOnScreen();
                int moveY = oldDragY - e.getYOnScreen();

                screen.getPosition().setX(screen.getLocation().x - moveX);
                screen.getPosition().setY(screen.getLocation().y - moveY);

                screen.setLocation(screen.getPosition().getX(), screen.getPosition().getY());
            }

            oldDragX = e.getXOnScreen();
            oldDragY = e.getYOnScreen();
        } else {
            if(posClickX >= screen.getPosition().getX() && posClickY >= screen.getPosition().getY() && posClickX <=
                    screen.getPosition().getX() + screen.getWidth() && posClickY <= screen.getPosition().getY() + DEFAULT_TITLEBAR_HEIGHT){
                if (oldDragX != 0 && oldDragY != 0) {
                    int moveX = oldDragX - e.getXOnScreen();
                    int moveY = oldDragY - e.getYOnScreen();

                    screen.getPosition().setX(screen.getLocation().x - moveX);
                    screen.getPosition().setY(screen.getLocation().y - moveY);

                    screen.setLocation(screen.getPosition().getX(), screen.getPosition().getY());
                }

                oldDragX = e.getXOnScreen();
                oldDragY = e.getYOnScreen();
                posClickX = e.getXOnScreen();
                posClickY = e.getYOnScreen();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        posClickX = e.getXOnScreen();
        posClickY = e.getYOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        oldDragX = 0;
        oldDragY = 0;
        posClickX = -1;
        posClickY = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
