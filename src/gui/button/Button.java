package gui.button;

import gui.GuYoComponent;

import javax.swing.*;
import java.awt.*;

public abstract class Button extends JButton implements GuYoComponent {

    protected boolean dark;
    protected boolean perso;

    public Button(int width, int height, int x, int y, boolean dark){
        this.dark = dark;
        perso = false;
        setBounds(x, y, width, height);
    }

    /**
     * set a new color of the background of the button
     * @param c the new color of the background
     */
    public void setColor(Color c) {
        setBackground(c);
    }

    public abstract void setDefaultColor();

    public abstract void setColorMouseOn();

    /**
     * set the color change for the button when the mouse is on the button using their onw setDefaultColor()
     */
    public void changeColorWhenMouseOn(){
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setColorMouseOn();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setDefaultColor();
            }
        });
    }

    public abstract void setPersonnalTheme();
}
