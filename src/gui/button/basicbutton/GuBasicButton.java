package gui.button.basicbutton;

import gui.button.GuButton;
import gui.view.icon.GuIconPair;

import javax.swing.*;

import static util.Constant.*;

public abstract class GuBasicButton extends GuButton {

    protected boolean withtitlebar;
    protected GuIconPair icons;

    public GuBasicButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar, GuIconPair icons){
        super(width, height, x, y, dark);
        this.withtitlebar = withtitlebar;
        this.icons = new GuIconPair(icons.getDarkIcon(), icons.getLightIcon());
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
        setImageOnButton(icons.getLightIcon().getIcon());
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
        setImageOnButton(icons.getDarkIcon().getIcon());
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
        setImageOnButton(icons.getDarkIcon().getIcon());
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
            setImageOnButton(icons.getLightIcon().getIcon());
        } else {
            if(withtitlebar) {
                setBackground(LIGHT_THEME.getSecondaryColor());
            } else {
                setBackground(LIGHT_THEME.getMainColor());
            }
            setImageOnButton(icons.getDarkIcon().getIcon());
        }
        if(perso){
            if(withtitlebar) {
                setBackground(PERSO_THEME.getSecondaryColor());
            } else {
                setBackground(PERSO_THEME.getMainColor());
            }
            setImageOnButton(icons.getDarkIcon().getIcon());
        }
    }

    public void changeIcons(GuIconPair pair){
        this.icons = new GuIconPair(pair.getDarkIcon(), pair.getLightIcon());
        setDefaultColor();
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
     * @param img image
     */
    public void setImageOnButton(ImageIcon img){
        setIcon(img);
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
