package gui.panel.container;

import gui.button.defaultbutton.AbstractDefaultButton;
import gui.panel.Panel;

import static util.Constant.*;

public abstract class MainContainer extends Panel {

    protected boolean havetitlebar;

    public MainContainer(int width, int height, boolean dark, boolean withtitlebar) {
        super(width, height, dark);
        this.havetitlebar = withtitlebar;
        if(dark){
            setBackground(DARK_THEME.getMainColor());
        } else {
            setBackground(LIGHT_THEME.getMainColor());
        }
        if(withtitlebar) {
            setBounds(0, DEFAULT_TITLEBAR_SIZE, width, height - DEFAULT_TITLEBAR_SIZE);
        } else {
            setSize(width, height);
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
        setBackground(PERSO_THEME_MAIN);
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
        if(havetitlebar){
            setSize(width, height - DEFAULT_TITLEBAR_SIZE);
        } else {
            setSize(width, height);
        }
    }
}
