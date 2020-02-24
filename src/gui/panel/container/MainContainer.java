package gui.panel.container;

import gui.panel.Panel;

import static util.Constant.*;

public abstract class MainContainer extends Panel {

    protected boolean havetitlebar;

    public MainContainer(int width, int height, boolean dark, boolean withtitlebar) {
        super(width, height, dark);
        this.havetitlebar = withtitlebar;

        if(withtitlebar) {
            setSize(width, height - DEFAULT_TITLEBAR_HEIGHT);
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
