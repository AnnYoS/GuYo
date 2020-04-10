package gui.panel.bar;

import gui.button.defaultbutton.AbstractDefaultButton;
import gui.panel.Panel;

import static util.Constant.*;

public abstract class Titlebar extends Panel {

    private boolean isShow;

    public Titlebar(int width, int height, boolean dark, boolean show, int titlebarposition) {
        super(dark, titlebarposition);

        if(this.titlebarposition == TOP){
            setBounds(0,0, super.getWidth(), DEFAULT_TITLEBAR_SIZE);
        } else if (this.titlebarposition == LEFT){
            setBounds(0,0, DEFAULT_TITLEBAR_SIZE, super.getHeight());
        } else if (this.titlebarposition == RIGHT){
            setBounds(super.getWidth() - DEFAULT_TITLEBAR_SIZE,0, DEFAULT_TITLEBAR_SIZE, super.getHeight());
        } else {
            setBounds(0,super.getHeight() - DEFAULT_TITLEBAR_SIZE, super.getWidth(), DEFAULT_TITLEBAR_SIZE);
        }

        isShow = show;

        if(dark){
            if(isShow){
                setBackground(DARK_THEME.getSecondaryColor());
            } else {
                setBackground(DARK_THEME.getMainColor());
            }
        } else {
            if(isShow){
                setBackground(LIGHT_THEME.getSecondaryColor());
            } else {
                setBackground(LIGHT_THEME.getMainColor());
            }
        }
    }

    /**
     * set the dark mode
     */
    @Override
    public void setDarkMode() {
        setBackground(DARK_THEME.getSecondaryColor());
        for (AbstractDefaultButton b : buttons) {
            b.setDarkMode();
        }
        dark = true;
        perso = false;
    }

    /**
     * set the dark mode
     */
    @Override
    public void setLightMode() {
        setBackground(DARK_THEME.getSecondaryColor());
        for(AbstractDefaultButton b : buttons){
            b.setLightMode();
        }
        dark = true;
        perso = false;
    }

    /**
     * set the personnal theme
     */
    @Override
    public void setPersonnalTheme() {
        setBackground(PERSO_THEME.getSecondaryColor());
        for(AbstractDefaultButton b : buttons){
            b.setPersonnalTheme();
        }
        dark = false;
        perso = true;
    }

    /**
     * resize the titlebar
     * @param width dimension
     * @param height dimension
     */
    public void resizePanel(int width, int height){
        setSize(width, height);
    }

    /**
     * set new position of the titlebar
     * @param x position
     * @param y position
     */
    public void setPosition(int x, int y){
        setBounds(x, y, super.getWidth(), super.getHeight());
    }

    /**
     * @return is the titlebar is visible
     */
    public boolean isShow(){
        return isShow;
    }
}
