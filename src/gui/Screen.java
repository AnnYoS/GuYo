package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static util.Constant.*;


public class Screen extends JFrame {

    private Panel main;
    private Titlebar titlebar;
    private boolean dark;
    private boolean havetitlebar;
    private boolean fullscreen;

    public Screen(int width, int height, boolean dark, boolean withtitlebar) {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, width, height);

        //initialize the window
        initWindow(width, height, dark, withtitlebar);

        setVisible(true);
    }

    public Screen(boolean dark, boolean withtitlebar){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);

        //initialize the window
        initWindow(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, dark, withtitlebar);

        setVisible(true);
    }



    /**
     * set the theme in dark mode
     */
    public void setDarkMode(){
        main.setDarkMode();
        if(havetitlebar){
            titlebar.setDarkMode();
        }
        dark = true;
    }

    /**
     * set the the in light mode
     */
    public void setLightMode(){
        main.setLightMode();
        if(havetitlebar){
            titlebar.setLightmode();
        }
        dark = false;
    }

    /**
     * create a new window without basic swing title bar
     * @param width of the window
     * @param height of the window
     * @param dark if the window is in dark mode
     * @param withtitlebar if the window have a titlebar
     */
    private void initWindow(int width, int height, boolean dark, boolean withtitlebar){
        main = new Panel(width, height, dark, withtitlebar);
        main.setLayout(null);

        this.dark = dark;
        this.havetitlebar = withtitlebar;
        this.fullscreen = false;

        DefaultButton exit, maximize, reduce;

        if(withtitlebar) {
            titlebar = new Titlebar(width, dark);
            titlebar.setLayout(null);

            exit = new DefaultButton(45, 30, titlebar.getWidth() - 45, 0, dark, true);
            maximize = new DefaultButton(45, 30, titlebar.getWidth() - 90, 0, dark, true);
            reduce = new DefaultButton(45, 30, titlebar.getWidth() - 135, 0, dark, true);

        } else {
            exit = new DefaultButton(45, 30, main.getWidth() - 45, 0, dark, false);
            maximize = new DefaultButton(45, 30, main.getWidth() - 90, 0, dark, false);
            reduce = new DefaultButton(45, 30, main.getWidth() - 135, 0, dark, true);
        }

        exit.addActionListener(e -> System.exit(0));
        maximize.addActionListener(e -> {
            if (!fullscreen) {
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Rectangle maximumWindowBound = environment.getMaximumWindowBounds();

                setExtendedState(JFrame.MAXIMIZED_BOTH);
                main.resizePanel(maximumWindowBound.width, maximumWindowBound.height);
                if (withtitlebar) {
                    titlebar.resizeTitlebar(maximumWindowBound.width);
                    for (Component c : titlebar.getComponents()) {
                        if (c.equals(exit)) {
                            c.setLocation(titlebar.getWidth() - 45, 0);
                        }
                        if (c.equals(maximize)) {
                            c.setLocation(titlebar.getWidth() - 90, 0);
                        }
                    }

                } else {
                    for (Component c : main.getComponents()) {
                        if (c.equals(exit)) {
                            c.setLocation(main.getWidth() - 45, 0);
                        }
                        if (c.equals(maximize)) {
                            c.setLocation(main.getWidth() - 90, 0);
                        }
                    }
                }
                fullscreen = true;
            } else {
                setSize(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);
                main.resizePanel(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);
                if (withtitlebar) {
                    titlebar.resizeTitlebar(DEFAULT_SCREEN_WIDTH);
                    for (Component c : titlebar.getComponents()) {
                        if (c.equals(exit)) {
                            c.setLocation(titlebar.getWidth() - 45, 0);
                        }
                        if (c.equals(maximize)) {
                            c.setLocation(titlebar.getWidth() - 90, 0);
                        }
                    }

                } else {
                    for (Component c : main.getComponents()) {
                        if (c.equals(exit)) {
                            c.setLocation(main.getWidth() - 45, 0);
                        }
                        if (c.equals(maximize)) {
                            c.setLocation(main.getWidth() - 90, 0);
                        }
                    }
                }
                fullscreen = false;
            }
        });
        reduce.addActionListener(e -> setExtendedState(JFrame.HIDE_ON_CLOSE));

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
            titlebar.add(apptitle);
        } else {
            main.add(apptitle);
        }
    }
}
