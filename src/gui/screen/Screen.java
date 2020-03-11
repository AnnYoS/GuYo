package gui.screen;

import gui.GuYoComponent;
import gui.button.defaultbutton.DefaultButton;
import gui.panel.Panel;
import gui.panel.bar.DefaultTitlebar;
import gui.panel.container.DefaultPanel;
import gui.screen.mouselistener.ScreenDragger;
import util.Position2I;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static util.Constant.*;

public abstract class Screen extends JFrame implements GuYoComponent {

    protected Position2I position;
    protected boolean dark;
    protected boolean havetitlebar;
    protected boolean fullscreen;
    protected ArrayList<Panel> containers;

    public Screen(int width, int height, boolean dark, boolean withtitlebar){
        super();

        //initialize variables
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

        /*important to create our own titlebar and border*/
        setUndecorated(true);
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
     * set the theme in light
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
     * @return the main panel on the current screen
     */
    public Panel getMainpanel(){
       return containers.get(0);
    }

    /**
     * @return the titlebar if exist one, else null
     */
    public Panel getTitlebar(){
        if(havetitlebar){
            return containers.get(1);
        }
        return null;
    }

    /**
     * @return the position of the screen
     */
    public Position2I getPosition(){
        return position;
    }

    /**
     * @return if the screen have titlebar
     */
    public boolean isHavetitlebar() {
        return havetitlebar;
    }

    /**
     * initialize the containers on the screen
     * @param width dimension
     * @param height dimension
     */
    protected void initContainers(int width, int height){
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
    }

    /**
     * initialize exit button at top right corner if we want it
     * @param width the width of the screen to know the position in the top right corner
     */
    protected void initExitButton(int width){
        DefaultButton exit;
        int nbbuttons = 0;
        if(havetitlebar){
            nbbuttons = getTitlebar().getButtons().size();
        } else {
            nbbuttons = getMainpanel().getButtons().size();
        }
        exit = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - (nbbuttons + 1)*45, 0, this.dark, havetitlebar,"assets/crossblack.png", "assets/crosswhite.png");
        exit.changeColorWhenMouseOn(DEFAULT_RED, DEFAULT_RED);
        exit.addActionListener(e -> System.exit(0));
        if(havetitlebar){
            getTitlebar().addButton(exit);
        } else {
            getMainpanel().addButton(exit);
        }
    }

    /**
     * initialize reduce button at top right corner if we want it
     * @param width the width of the screen to know the position in the top right corner
     */
    protected void initReduceButton(int width){
        DefaultButton reduce;
        int nbbuttons = 0;
        if(havetitlebar){
            nbbuttons = getTitlebar().getButtons().size();
        } else {
            nbbuttons = getMainpanel().getButtons().size();
        }
        reduce = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - (nbbuttons + 1)*45, 0, this.dark, havetitlebar,"assets/reduceblack.png", "assets/reducewhite.png");
        reduce.changeColorWhenMouseOn(DEFAULT_COLOR_DARK_MOUSE_ON, DEFAULT_COLOR_WHITE_MOUSE_ON);

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

        if(havetitlebar){
            getTitlebar().addButton(reduce);
        } else {
            getMainpanel().addButton(reduce);
        }
    }

    /**
     * initialize maximize button at top right corner if we want it
     * @param width the width of the screen to know the position in the top right corner
     */
    protected void initMaximizeButton(int width){
        DefaultButton maximize;
        int nbbuttons = 0;
        if(havetitlebar){
            nbbuttons = getTitlebar().getButtons().size();
        } else {
            nbbuttons = getMainpanel().getButtons().size();
        }
        maximize = new DefaultButton(45, DEFAULT_TITLEBAR_HEIGHT, width - (nbbuttons + 1)*45, 0, this.dark, havetitlebar,"assets/maximazeblack.png", "assets/maximazewhite.png");
        maximize.changeColorWhenMouseOn(DEFAULT_COLOR_DARK_MOUSE_ON, DEFAULT_COLOR_WHITE_MOUSE_ON);

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

            getMainpanel().resizePanel(x, y);
            if (havetitlebar) {
                getTitlebar().resizePanel(x, y);
                for(int i = 0; i < getTitlebar().getButtons().size(); i++){
                    getTitlebar().getButtonAt(i).setLocation(x - (i + 1)*(int)getTitlebar().getButtonAt(i).getSize().getWidth(), 0);
                }
            } else {
                for(int i = 0; i < getMainpanel().getButtons().size(); i++){
                    getMainpanel().getButtonAt(i).setLocation(x - (i + 1)*(int)getMainpanel().getButtonAt(i).getSize().getWidth(), 0);
                }
            }

            revalidate();
            repaint();
        });

        if(havetitlebar){
            getTitlebar().addButton(maximize);
        } else {
            getMainpanel().addButton(maximize);
        }
    }

    /**
     * set the name of the application
     * @param name the new name
     */
    public void setAppName(String name, Position2I pos, int width){
        JLabel apptitle = new JLabel(name);
        apptitle.setBounds(pos.getX(), pos.getY(), width, DEFAULT_TITLEBAR_HEIGHT);
        if(dark){ apptitle.setForeground(DEFAULT_WHITE);}
        if(havetitlebar){
            getTitlebar().add(apptitle);
        } else {
            getMainpanel().add(apptitle);
        }
    }

    /**
     * set the dragger for the screen to move it on window
     */
    protected void setScreenDragger(){
        ScreenDragger drag = new ScreenDragger(this);
        if(havetitlebar) {
            assert getTitlebar() != null : "Titlebar null";
            getTitlebar().addMouseMotionListener(drag);
            getTitlebar().addMouseListener(drag);
        } else {
            getMainpanel().addMouseMotionListener(drag);
            getMainpanel().addMouseListener(drag);
        }
    }
}
