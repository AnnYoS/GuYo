package gui.button;

import java.awt.*;

public class DefaultButton extends AbstractButton {

    public DefaultButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar){
        super(width, height, x, y, dark, withtitlebar);
        setBorderPainted(false);
    }

    /**
     * set the color change for the button when the mouse is on the button
     * @param colordark color to set
     * @param colorlight color to set
     */
    public void changeColorWhenMouseOn(Color colordark, Color colorlight){
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(dark){
                    setColor(colordark);
                } else {
                    setColor(colorlight);
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setDefaultColor();
            }
        });
    }
}
