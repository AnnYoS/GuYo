package gui.screen;

import gui.GuYoComponent;
import gui.button.DefaultButton;
import gui.panel.container.MainContainer;
import gui.panel.Panel;
import gui.panel.bar.DefaultTitlebar;
import util.Position2I;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static util.Constant.*;

public abstract class Screen extends JFrame implements GuYoComponent {

    protected Position2I position;
    protected boolean dark;
    protected boolean havetitlebar;
    protected boolean fullscreen;
    protected List<Panel> containers;

    public Screen(int width, int height, boolean dark, boolean withtitlebar){
        super();
        containers = new ArrayList<>();
        position = new Position2I();
        this.dark = dark;
        this.havetitlebar = withtitlebar;
        this.fullscreen = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setting size and position of the screen
        setSize(width, height);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        position.setX((int) ((dimension.getWidth() - this.getWidth()) / 2));
        position.setY((int) ((dimension.getHeight() - this.getHeight()) / 2));
        setLocation(position.getX(), position.getY());
    }

    /**
     * initialize the window
     * @param width of the window
     * @param height of the window
     */
    protected abstract void initWindow(int width, int height);

    /**
     * set the theme in dark
     */
    @Override
    public void setDarkMode() {
        if(!dark) {
            for (Panel p : containers) {
                p.setDarkMode();
            }
            dark = true;
        }
    }

    /**
     * set the theme int light
     */
    @Override
    public void setLightMode() {
        if(dark) {
            for (Panel p : containers) {
                p.setLightMode();
            }
            dark = false;
        }
    }

    /**
     * @return containers on the screen
     */
    public List<Panel> getContainers() {
        return containers;
    }

    /**
     * @return the position of the screen
     */
    public Position2I getPosition() {
        return position;
    }

    public boolean isHavetitlebar() {
        return havetitlebar;
    }

    /**
     * initialize the 3 basicals buttons in the top right corner of the screen
     * @param exit button
     * @param maximize button
     * @param reduce button
     */
    protected void initWindowButton(DefaultButton exit, DefaultButton maximize, DefaultButton reduce, MainContainer main, DefaultTitlebar titlebar){
        exit.addActionListener(e -> System.exit(0));

        maximize.addActionListener(e -> {
            int x = 0, y = 0;
            if (!fullscreen) {
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Rectangle maximumWindowBound = environment.getMaximumWindowBounds();
                x = maximumWindowBound.width;
                y = maximumWindowBound.height;
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                fullscreen = true;
                setLocation(0, 0);

            } else {
                x = DEFAULT_SCREEN_WIDTH;
                y = DEFAULT_SCREEN_HEIGHT;
                setSize(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);
                fullscreen = false;
                setLocation(position.getX(), position.getY());
            }

            main.resizePanel(x, y);
            if (havetitlebar) {
                titlebar.resizeTitlebar(x);
                for (Component c : titlebar.getComponents()) {
                    if (c.equals(exit)) {
                        c.setLocation(x - 45, 0);
                    }
                    if (c.equals(maximize)) {
                        c.setLocation(titlebar.getWidth() - 90, 0);
                    }
                    if (c.equals(reduce)) {
                        c.setLocation(titlebar.getWidth() - 135, 0);
                    }
                }
            } else {
                for (Component c : main.getComponents()) {
                    if (c.equals(exit)) {
                        c.setLocation(x - 45, 0);
                    }
                    if (c.equals(maximize)) {
                        c.setLocation(main.getWidth() - 90, 0);
                    }
                    if (c.equals(reduce)) {
                        c.setLocation(main.getWidth() - 135, 0);
                    }
                }
            }

            revalidate();
            repaint();
        });

        reduce.addActionListener(e -> {
            setExtendedState(JFrame.HIDE_ON_CLOSE);

            if (fullscreen) {
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Rectangle maximumWindowBound = environment.getMaximumWindowBounds();
                int x = maximumWindowBound.width;
                int y = maximumWindowBound.height;
                setSize(new Dimension(x, y));
            }

            revalidate();
            repaint();
        });
    }
}
