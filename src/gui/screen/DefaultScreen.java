package gui.screen;

import gui.button.defaultbutton.DefaultButton;
import gui.panel.bar.DefaultTitlebar;
import gui.panel.container.DefaultPanel;
import gui.screen.mouselistener.ScreenDragger;

import javax.swing.*;

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
        DefaultPanel main = new DefaultPanel(width, height, this.dark, havetitlebar);
        main.setLayout(null);
        containers.add(main);

        DefaultTitlebar titlebar = null;
        if(havetitlebar) {
            titlebar = new DefaultTitlebar(width, dark);
            titlebar.setLayout(null);
            containers.add(titlebar);
        }

        DefaultButton exit, maximize, reduce;
        exit = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - 45, 0, this.dark, havetitlebar, "assets/crossblack.png", "assets/crosswhite.png");
        maximize = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - 90, 0, this.dark, havetitlebar, "assets/maximazeblack.png", "assets/maximazewhite.png");
        reduce = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - 135, 0, this.dark, havetitlebar, "assets/reduceblack.png", "assets/reducewhite.png");
        initWindowButton(exit, maximize, reduce, main, titlebar);


        exit.changeColorWhenMouseOn(DEFAULT_RED, DEFAULT_RED);
        maximize.changeColorWhenMouseOn(DEFAULT_COLOR_DARK_MOUSE_ON, DEFAULT_COLOR_WHITE_MOUSE_ON);
        reduce.changeColorWhenMouseOn(DEFAULT_COLOR_DARK_MOUSE_ON, DEFAULT_COLOR_WHITE_MOUSE_ON);

        ScreenDragger drag = new ScreenDragger(this);
        if(havetitlebar) {
            assert titlebar != null;
            titlebar.addButtons(exit, maximize, reduce);
            titlebar.addMouseMotionListener(drag);
            titlebar.addMouseListener(drag);
            setLayout(new BorderLayout());
            add(titlebar);
        } else {
            main.addButtons(exit, maximize, reduce);
            main.addMouseMotionListener(drag);
            main.addMouseListener(drag);
        }
        add(main);
    }

    /**
     * set the name of the application
     * @param name the new name
     */
    public void setAppName(String name){
        JLabel apptitle = new JLabel(name);
        if(dark){ apptitle.setForeground(DEFAULT_WHITE);}
        if(havetitlebar){
            containers.get(1).add(apptitle);
        } else {
            containers.get(0).add(apptitle);
        }
    }
}
