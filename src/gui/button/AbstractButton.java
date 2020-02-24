package gui.button;

import gui.GuYoComponent;
import gui.view.Images;

import javax.swing.*;

import java.awt.*;

import static util.Constant.*;
import static util.Constant.DEFAULT_WHITE;

public abstract class AbstractButton extends JButton implements GuYoComponent {

    protected boolean dark;
    protected boolean withtitlebar;
    protected Images images;

    public AbstractButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar, String darkimage, String lightimage){
        super();
        this.dark = dark;
        this.withtitlebar = withtitlebar;
        setBounds(x, y, width, height);
        images = new Images(darkimage, lightimage);
        setDefaultColor();
    }

    /**
     * set the dark mode
     */
    @Override
    public void setDarkMode() {
        if(withtitlebar) {
            setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
        } else {
            setBackground(DEFAULT_BLACK);
        }
        setImageOnButton(images.getLightimage());
    }

    /**
     * set the light mode
     */
    @Override
    public void setLightMode() {
        if(withtitlebar) {
            setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
        } else {
            setBackground(DEFAULT_WHITE);
        }
        setImageOnButton(images.getDarkimage());
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
            setImageOnButton(images.getLightimage());
        } else {
            if(withtitlebar) {
                setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
            } else {
                setBackground(DEFAULT_WHITE);
            }
            setImageOnButton(images.getDarkimage());
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
