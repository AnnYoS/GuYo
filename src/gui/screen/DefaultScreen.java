package gui.screen;

import gui.button.defaultbutton.DefaultButton;

import java.awt.*;

import static util.Constant.*;


public class DefaultScreen extends Screen {

    public DefaultScreen(int width, int height, boolean dark, boolean withtitlebar) {
        super(width, height, dark, withtitlebar, TOP);

        initWindow(width, height);

        setVisible(true);
    }

    public DefaultScreen(boolean dark, boolean withtitlebar){
        super(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, dark, withtitlebar, TOP);

        initWindow(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);

        setVisible(true);
    }

    public DefaultScreen(boolean dark, int titlebarposition){
        super(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, dark, true, titlebarposition);

        initWindow(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);

        setVisible(true);
    }

    public DefaultScreen(int width, int height, boolean dark, int titlebarposition){
        super(width, height, dark, true,titlebarposition);
    }

    /**
     * create a new window without basic swing title bar
     * @param width of the window
     * @param height of the window
     */
    public void initWindow(int width, int height){

        initExitButton(width, height);
        initMaximizeButton(width, height);
        initReduceButton(width, height);

        setScreenDragger();

        setLayout(new BorderLayout());
        add(getTitlebar());
        add(getMainpanel());
    }
}
