package gui.screen;

import gui.button.DefaultButton;
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
        initWindow(width, height, dark, withtitlebar);

        setVisible(true);
    }

    public DefaultScreen(boolean dark, boolean withtitlebar){
        super(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, dark, withtitlebar);

        //initialize the window
        initWindow(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, dark, withtitlebar);

        setVisible(true);
    }

    /**
     * create a new window without basic swing title bar
     * @param width of the window
     * @param height of the window
     * @param dark if the window is in dark mode
     * @param withtitlebar if the window have a titlebar
     */
    public void initWindow(int width, int height, boolean dark, boolean withtitlebar){
        DefaultPanel main = new DefaultPanel(width, height, dark, withtitlebar);
        main.setLayout(null);
        containers.add(main);

        DefaultTitlebar titlebar = null;
        if(withtitlebar) {
            titlebar = new DefaultTitlebar(width, dark);
            titlebar.setLayout(null);
            containers.add(titlebar);
        }

        DefaultButton exit, maximize, reduce;
        exit = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - 45, 0, dark, havetitlebar, "assets/crossblack.png", "assets/crosswhite.png");
        maximize = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - 90, 0, dark, havetitlebar, "assets/maximazeblack.png", "assets/maximazewhite.png");
        reduce = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - 135, 0, dark, havetitlebar, "assets/reduceblack.png", "assets/reducewhite.png");
        initWindowButton(exit, maximize, reduce, main, titlebar);


        exit.changeColorWhenMouseOn(DEFAULT_RED, DEFAULT_RED);
        maximize.changeColorWhenMouseOn(DEFAULT_DARK_GREY, DEFAULT_LIGHT_GREY);
        reduce.changeColorWhenMouseOn(DEFAULT_DARK_GREY, DEFAULT_LIGHT_GREY);

        ScreenDragger drag = new ScreenDragger(this);
        if(withtitlebar) {
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

        /*important*/
        setUndecorated(true);

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
