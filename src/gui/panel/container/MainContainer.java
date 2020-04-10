package gui.panel.container;

import gui.button.defaultbutton.AbstractDefaultButton;
import gui.panel.Panel;

import static util.Constant.*;

public abstract class MainContainer extends Panel {

    public MainContainer(int width, int height, boolean dark, int titlebarposition) {
        super(dark, titlebarposition);
        if(dark){
            setBackground(DARK_THEME.getMainColor());
        } else {
            setBackground(LIGHT_THEME.getMainColor());
        }
        if(this.titlebarposition == TOP){
            setBounds(0, DEFAULT_TITLEBAR_SIZE, width, height - DEFAULT_TITLEBAR_SIZE);
        } else if (this.titlebarposition == LEFT){
            setBounds(DEFAULT_TITLEBAR_SIZE, 0, width - DEFAULT_TITLEBAR_SIZE, height);
        } else if (this.titlebarposition == RIGHT){
            setBounds(0, 0, width - DEFAULT_TITLEBAR_SIZE, height);
        } else {
            setBounds(0,0, width, height - DEFAULT_TITLEBAR_SIZE);
        }
    }

    /**
     * set the dark mode
     */
    @Override
    public void setDarkMode() {
        setBackground(DARK_THEME.getMainColor());
        for(AbstractDefaultButton b : buttons){
            b.setDarkMode();
        }
        perso = false;
        dark = true;
    }

    /**
     * set the light mode
     */
    @Override
    public void setLightMode() {
        setBackground(DARK_THEME.getMainColor());
        for(AbstractDefaultButton b : buttons){
            b.setLightMode();
        }
        perso = false;
        dark = false;
    }

    /**
     * set the personnal theme to the container
     */
    @Override
    public void setPersonnalTheme() {
        setBackground(PERSO_THEME.getMainColor());
        for (AbstractDefaultButton b : buttons) {
            b.setPersonnalTheme();
        }
        dark = false;
        perso = true;
    }

    /**
     * resize the main panel
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
}
