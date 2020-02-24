package gui.button;

import gui.GuYoComponent;

import javax.swing.*;

import java.awt.*;

import static util.Constant.*;
import static util.Constant.DEFAULT_WHITE;

public class AbstractButton extends JButton implements GuYoComponent {

    protected boolean dark;
    protected boolean withtitlebar;

    public AbstractButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar){
        super();
        this.dark = dark;
        this.withtitlebar = withtitlebar;
        setBounds(x, y, width, height);
        setDefaultColor();
    }


    @Override
    public void setDarkMode() {

    }

    @Override
    public void setLightMode() {

    }

    /**
     * set the default color of the button
     */
    public void setDefaultColor(){
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
     * set a new color of the background of the button
     * @param c the new color of the background
     */
    public void setColor(Color c) {
        setBackground(c);
    }

    /**
     * set the image on the button
     * @param path of the image
     */
    public void setImageOnButton(String path){
        setIcon(new ImageIcon(path));
    }
}
