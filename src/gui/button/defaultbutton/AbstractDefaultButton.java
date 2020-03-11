package gui.button.defaultbutton;

import gui.button.Button;
import gui.view.Images;

import javax.swing.*;

import java.awt.*;

import static util.Constant.*;
import static util.Constant.DEFAULT_WHITE;

public abstract class AbstractDefaultButton extends Button {

    protected boolean withtitlebar;
    protected Images images;

    public AbstractDefaultButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar, String darkimage, String lightimage){
        super(width, height, x, y, dark);
        this.withtitlebar = withtitlebar;
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
        perso = false;
        dark = true;

        revalidate();
        repaint();
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
        perso = false;
        dark = false;

        revalidate();
        repaint();
    }

    /**
     * set the personnal theme
     */
    @Override
    public void setPersonnalTheme() {
        if(withtitlebar) {
            setBackground(PERSO_TITLEBAR_COLOR);
        } else {
            setBackground(PERSO_THEME_MAIN);
        }
        setImageOnButton(images.getLightimage());
        dark = false;
        perso = true;

        revalidate();
        repaint();
    }

    /**
     * set the default color of the button
     */
    @Override
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
        if(perso){
            if(withtitlebar) {
                setBackground(PERSO_TITLEBAR_COLOR);
            } else {
                setBackground(PERSO_THEME_MAIN);
            }
        }
    }

    /**
     * set the image on the button
     * @param path of the image
     */
    public void setImageOnButton(String path){
        setIcon(new ImageIcon(path));
    }
}
