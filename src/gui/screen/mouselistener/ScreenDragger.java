package gui.screen.mouselistener;

import gui.screen.Screen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ScreenDragger implements MouseMotionListener {

    private int oldDragX;
    private int oldDragY;
    private Screen screen;

    public ScreenDragger(Screen s){
        oldDragX = 0;
        oldDragY = 0;
        screen = s;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (oldDragX != 0 && oldDragY != 0) {
            int moveX = oldDragX - e.getXOnScreen();
            int moveY = oldDragY - e.getYOnScreen();

            screen.getPosition().setX(screen.getLocation().x - moveX);
            screen.getPosition().setY(screen.getLocation().y - moveY);

            screen.setLocation(screen.getPosition().getX(), screen.getPosition().getY());
        }

        oldDragX = e.getXOnScreen();
        oldDragY = e.getYOnScreen();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
