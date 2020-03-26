package gui.button.defaultbutton;

import gui.button.Button;
import gui.view.Images;

import javax.swing.*;

import static util.Constant.*;

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
            setBackground(DARK_THEME.getSecondaryColor());
        } else {
            setBackground(DARK_THEME.getMainColor());
        }
        setImageOnButton(images.getLightimage());
        perso = false;
        dark = true;
    }

    /**
     * set the light mode
     */
    @Override
    public void setLightMode() {
        if(withtitlebar) {
            setBackground(LIGHT_THEME.getSecondaryColor());
        } else {
            setBackground(LIGHT_THEME.getMainColor());
        }
        setImageOnButton(images.getDarkimage());
        perso = false;
        dark = false;
    }

    /**
     * set the personnal theme
     */
    @Override
    public void setPersonnalTheme() {
        if(withtitlebar) {
            setBackground(PERSO_THEME.getSecondaryColor());
        } else {
            setBackground(PERSO_THEME.getMainColor());
        }
        setImageOnButton(images.getDarkimage());
        dark = false;
        perso = true;
    }

    /**
     * set the default color of the button
     */
    @Override
    public void setDefaultColor(){
        if(dark){
            if(withtitlebar) {
                setBackground(DARK_THEME.getSecondaryColor());
            } else {
                setBackground(DARK_THEME.getMainColor());
            }
            setImageOnButton(images.getLightimage());
        } else {
            if(withtitlebar) {
                setBackground(LIGHT_THEME.getSecondaryColor());
            } else {
                setBackground(LIGHT_THEME.getMainColor());
            }
            setImageOnButton(images.getDarkimage());
        }
        if(perso){
            if(withtitlebar) {
                setBackground(PERSO_THEME.getSecondaryColor());
            } else {
                setBackground(PERSO_THEME.getMainColor());
            }
            setImageOnButton(images.getDarkimage());
        }
    }

    /**
     * change the color when the mouse is on
     */
    @Override
    public void setColorMouseOn() {
        if(dark){
            setBackground(DARK_THEME.getInteractColor());
        } else {
            setBackground(LIGHT_THEME.getInteractColor());
        }
        if(perso){
            setBackground(PERSO_THEME.getInteractColor());
        }
    }

    /**
     * set the image on the button
     * @param path of the image
     */
    public void setImageOnButton(String path){
        setIcon(new ImageIcon(path));
    }

    /**
     * set new position for the button
     * @param x position
     * @param y position
     */
    public void setPosition(int x, int y){
        setBounds(x, y, super.getWidth(), super.getHeight());
    }

    /**
     * set new dimension for the button
     * @param width dimension
     * @param height dimension
     */
    public void resizeButton(int width, int height){
        setSize(width, height);
    }
}
