package gui.panel.bar;

import gui.button.AbstractButton;
import gui.panel.Panel;

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
        for(AbstractButton b : buttons){
            b.setDarkMode();
        }
        setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
    }

    /**
     * set the dark mode
     */
    @Override
    public void setLightMode() {
        for(AbstractButton b : buttons){
            b.setLightMode();
        }
        setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
    }

    /**
     * resize the titlebar
     * @param width the new width of the titlebar
     */
    public void resizeTitlebar(int width){
        setSize(width, DEFAULT_TITLEBAR_HEIGHT);
    }
}
