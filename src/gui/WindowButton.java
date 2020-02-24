package gui;

import gui.screen.Screen;

import javax.swing.*;

import java.awt.*;

import static util.Constant.*;

public class WindowButton extends JButton {

    private boolean dark;
    private boolean withtitlebar;

    public WindowButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar){
        super();
        this.dark = dark;
        this.withtitlebar = withtitlebar;
        setDefaultColor();
        setBorderPainted(false);
        setBounds(x, y, width, height);
    }

    /**
     * set a new color of the background of the button
     * @param c the new color of the background
     */
    public void setColor(Color c) {
        setBackground(c);
    }

    /**
     * restore the default color of the button
     */
    public void restoreDefaultColor() {
        setDefaultColor();
    }

    /**
     * set the image on the button
     * @param path of the image
     */
    public void setImageOnButton(String path){
        setIcon(new ImageIcon(path));
    }

    /**
     * set the theme into the dark mode
     */
    public void setDarkMode(){
        if(withtitlebar) {
            setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
        } else {
            setBackground(DEFAULT_BLACK);
        }
        dark = true;
    }

    /**
     * set the theme into light mode
     */
    public void setLightMode(){
        if(withtitlebar) {
            setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
        } else {
            setBackground(DEFAULT_WHITE);
        }
        dark = false;
    }

    /**
     * set the default color of the button
     */
    private void setDefaultColor(){
        if(dark){
            if(withtitlebar) {
                setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
            } else {
                setBackground(DEFAULT_BLACK);
            }
        } else {
            if(withtitlebar) {
                setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
            } else {
                setBackground(DEFAULT_WHITE);
            }
        }
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
                restoreDefaultColor();
            }
        });
    }
}
