package gui.panel.bar;

import gui.button.defaultbutton.AbstractDefaultButton;
import gui.panel.Panel;

import java.awt.*;

import static util.Constant.*;

public abstract class Titlebar extends Panel {

    public Titlebar(int width, int height, boolean dark) {
        super(width, height, dark);
        if(dark){
            setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
        } else {
            setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
        }
    }

    /**
     * set the dark mode
     */
    @Override
    public void setDarkMode() {
        setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
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
        setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
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
        setBackground(PERSO_TITLEBAR_COLOR);
        for(AbstractDefaultButton b : buttons){
            b.setPersonnalTheme();
        }
        dark = false;
        perso = true;
    }

    /**
     * resize the titlebar
     * @param width the new width of the titlebar
     */
    public void resizePanel(int width, int height){
        setSize(width, DEFAULT_TITLEBAR_HEIGHT);
    }
}
