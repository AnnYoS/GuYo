package gui.screen;

import gui.button.defaultbutton.DefaultButton;
import gui.panel.bar.DefaultTitlebar;
import gui.panel.container.DefaultPanel;
import gui.screen.mouselistener.ScreenDragger;

import java.awt.*;

import static util.Constant.*;


public class DefaultScreen extends Screen {

    public DefaultScreen(int width, int height, boolean dark, boolean withtitlebar) {
        super(width, height, dark, withtitlebar);

        //initialize the window
        initWindow(width, height);

        setVisible(true);
    }

    public DefaultScreen(boolean dark, boolean withtitlebar){
        super(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, dark, withtitlebar);

        //initialize the window
        initWindow(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);

        setVisible(true);
    }

    /**
     * create a new window without basic swing title bar
     * @param width of the window
     * @param height of the window
     */
    public void initWindow(int width, int height){
        initContainers(width, height);

        initExitButton(width);
        initMaximizeButton(width);
        initReduceButton(width);

        setScreenDragger();

        if(havetitlebar) {
            assert getTitlebar() != null;
            setLayout(new BorderLayout());
            add(getTitlebar());
        }
        add(getMainpanel());
    }
}
