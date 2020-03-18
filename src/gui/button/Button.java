package gui.button;

import gui.GuYoComponent;
import static util.Constant.*;

import javax.swing.*;

public abstract class Button extends JButton implements GuYoComponent {

    protected boolean dark;
    protected boolean perso;

    public Button(int width, int height, int x, int y, boolean dark) {
        this.dark = dark;
        perso = false;
        setBounds(x, y, width, height);
    }

    public abstract void setDefaultColor();

    public abstract void setColorMouseOn();

    public abstract void setPersonnalTheme();

    /**
     * set the color change for the button when the mouse is on the button using their onw setDefaultColor()
     */
    public void changeColorWhenMouseOn(boolean exit){
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(exit){
                    setBackground(DEFAULT_RED);
                } else {
                    setColorMouseOn();
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setDefaultColor();
            }
        });
    }
}
