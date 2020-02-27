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
            setBackground(DEFAULT_BLACK);
        } else {
            setBackground(DEFAULT_WHITE);
        }
        if(withtitlebar) {
            setSize(width, height - DEFAULT_TITLEBAR_HEIGHT);
        }
    }

    /**
     * set the dark mode
     */
    @Override
    public void setDarkMode() {
        setBackground(DEFAULT_BLACK);
        for(AbstractDefaultButton b : buttons){
            b.setDarkMode();
        }
    }

    /**
     * set the light mode
     */
    @Override
    public void setLightMode() {
        setBackground(DEFAULT_WHITE);
        for(AbstractDefaultButton b : buttons){
            b.setLightMode();
        }
    }

    /**
     * resize the main panel
     * @param width dimension
     * @param height dimension
     */
    public void resizePanel(int width, int height){
        if(havetitlebar){
            setSize(width, height - DEFAULT_TITLEBAR_HEIGHT);
        } else {
            setSize(width, height);
        }
    }
}
