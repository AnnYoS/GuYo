package gui.screen;

import gui.button.DefaultButton;
import gui.panel.*;
import gui.panel.container.FitPanel;
import gui.screen.mouselistener.ScreenDragger;

import javax.swing.*;

import java.awt.*;

import static util.Constant.*;


public class FitScreen extends Screen {

    public FitScreen(int width, int height, boolean dark, boolean withtitlebar) {
        super(width, height, dark, withtitlebar);

        //initialize the window
        initWindow(width, height, dark, withtitlebar);

        setVisible(true);
    }

    public FitScreen(boolean dark, boolean withtitlebar){
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
        FitPanel main = new FitPanel(width, height, dark, withtitlebar);
        main.setLayout(null);
        containers.add(main);

        Titlebar titlebar = null;
        if(withtitlebar) {
            titlebar = new Titlebar(width, dark);
            titlebar.setLayout(null);
            containers.add(titlebar);
        }

        DefaultButton exit, maximize, reduce;
        exit = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - 45, 0, dark, true);
        maximize = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - 90, 0, dark, true);
        reduce = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - 135, 0, dark, true);
        initWindowButton(exit, maximize, reduce, main, titlebar);

        if(dark){
            exit.setImageOnButton(CROSS_WHITE);
            maximize.setImageOnButton(MAXIMIZE_WHITE);
            reduce.setImageOnButton(REDUCE_WHITE);
        } else {
            exit.setImageOnButton(CROSS_BLACK);
            maximize.setImageOnButton(MAXIMIZE_BLACK);
            reduce.setImageOnButton(REDUCE_BLACK);
        }

        exit.changeColorWhenMouseOn(DEFAULT_RED, DEFAULT_RED);
        maximize.changeColorWhenMouseOn(DEFAULT_DARK_GREY, DEFAULT_LIGHT_GREY);
        reduce.changeColorWhenMouseOn(DEFAULT_DARK_GREY, DEFAULT_LIGHT_GREY);

        if(withtitlebar) {

            titlebar.add(exit);
            titlebar.add(maximize);
            titlebar.add(reduce);

            setLayout(new BorderLayout());
            add(titlebar);
        } else {
            main.add(exit);
            main.add(maximize);
            main.add(reduce);
        }
        add(main);

        containers.get(1).addMouseMotionListener(new ScreenDragger(this));

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
