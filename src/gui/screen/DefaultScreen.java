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
        //create concrete panel without layout
        DefaultPanel main = new DefaultPanel(width, height, dark, havetitlebar);
        main.setLayout(null);
        containers.add(main);

        //create titlebar if we have one
        DefaultTitlebar titlebar = null;
        if(havetitlebar) {
            titlebar = new DefaultTitlebar(width, dark);
            titlebar.setLayout(null);
            containers.add(titlebar);
        }

        initExitButton(width);
        initMaximizeButton(width);
        initReduceButton(width);

        //create drag to move the window
        ScreenDragger drag = new ScreenDragger(this);
        if(havetitlebar) {
            assert titlebar != null;
            titlebar.addMouseMotionListener(drag);
            titlebar.addMouseListener(drag);
            setLayout(new BorderLayout());
            add(titlebar);
        } else {
            main.addMouseMotionListener(drag);
            main.addMouseListener(drag);
        }
        add(main);
    }
}
