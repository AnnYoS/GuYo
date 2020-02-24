package gui.panel;

import static util.Constant.*;

public class Titlebar extends Panel {

    public Titlebar(int width, boolean dark){
        super(width, DEFAULT_TITLEBAR_HEIGHT, dark);

        if(dark){
            setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
        } else {
            setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
        }
    }

    /**
     * resize the titlebar
     * @param width the new width of the titlebar
     */
    public void resizeTitlebar(int width){
        setSize(width, DEFAULT_TITLEBAR_HEIGHT);
    }
}
