package gui.screen;

import gui.GuComponent;
import gui.button.defaultbutton.DefaultButton;
import gui.panel.Panel;
import gui.panel.bar.DefaultTitlebar;
import gui.panel.container.DefaultPanel;
import gui.screen.mouselistener.ScreenDragger;
import gui.view.GuIconPair;
import util.Position2I;

import javax.swing.*;
import java.awt.*;

import static util.Constant.*;

public class GuScreen extends JFrame implements GuComponent {

    private Position2I position;

    private boolean dark;
    private boolean perso;
    private boolean showtitlebar;
    private boolean fullscreen;
    private int titlebarposition; //TOP, RIGHT, BOTTOM, LEFT

    private Panel[] containers;

    public GuScreen(int width, int height, boolean isDark, boolean isShowTitlebar){
        super();
        initVariables(width, height, isDark, isShowTitlebar, TOP);
        initialize();
    }

    public GuScreen(boolean isDark, boolean isShowTitlebar){
        super();
        initVariables(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, isDark, isShowTitlebar, TOP);
        initialize();

    }

    public GuScreen(){
        super();
        initVariables(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, false, true, TOP);
        initialize();
    }

    public GuScreen(int titlebarposition){
        super();
        initVariables(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, false, true, titlebarposition);
        initialize();
    }

    /**
     * initialize the window
     */
    private void initialize(){
        initContainers();
        initBasicalButtons();

        setUndecorated(true);
        setVisible(true);
    }

    /**
     * initialize screen's variables
     * @param width of screen
     * @param height of screen
     * @param isDark or not
     * @param isShowTitlebar or not
     * @param tbposition the position of the titlebar
     */
    private void initVariables(int width, int height, boolean isDark, boolean isShowTitlebar, int tbposition){
        containers = new Panel[2];

        setSize(width, height);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        position = new Position2I((int)((dimension.getWidth() - this.getWidth()) / 2), (int)((dimension.getHeight() - this.getHeight()) / 2));

        dark = isDark;
        perso = false;
        showtitlebar = isShowTitlebar;
        fullscreen = false;
        titlebarposition = tbposition;

        //setting size and position of the screen
        setLocation(position.getX(), position.getY());
    }

    /**
     * initialize the containers on the screen
     */
    private void initContainers(){
        setLayout(new BorderLayout());
        DefaultPanel main = new DefaultPanel(super.getWidth(), super.getHeight(), dark, titlebarposition);
        main.setLayout(null);
        containers[0] = main;
        add(getMainPanel());

        DefaultTitlebar titlebar = new DefaultTitlebar(super.getWidth(), super.getHeight(), dark, showtitlebar, titlebarposition);
        titlebar.setLayout(null);
        containers[1] = titlebar;
        add(getTitlebar());
        setScreenDragger();
    }

    /**
     * initialize basical buttons on screen
     */
    private void initBasicalButtons(){
        initExitButton();
        initMaximizeButton();
        initReduceButton();
    }

    /**
     * initialize exit button at top right corner if we want it
     */
    private void initExitButton(){
        DefaultButton exit;
        int nbbuttons = getTitlebar().getButtons().size();

        GuIconPair icons = new GuIconPair("assets/cross", ".png");
        if(titlebarposition == TOP) {
            exit = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, super.getWidth() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, 0, dark, showtitlebar, icons);
        } else if(titlebarposition == BOTTOM){
            exit = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, super.getWidth() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, super.getHeight() - DEFAULT_BUTTON_SIZE, dark, showtitlebar, icons);
        } else if(titlebarposition == LEFT){
            exit = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, 0, super.getHeight() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, dark, showtitlebar, icons);
        } else {
            exit = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, super.getWidth() - DEFAULT_BUTTON_SIZE, super.getHeight() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, dark, showtitlebar, icons);
        }
        exit.changeColorWhenMouseOn(true);
        exit.addActionListener(e -> System.exit(0));
        getTitlebar().addButton(exit);
    }

    /**
     * initialize reduce button at top right corner if we want it
     */
    private void initReduceButton(){
        DefaultButton reduce;
        int nbbuttons = getTitlebar().getButtons().size();

        GuIconPair icons = new GuIconPair("assets/reduce", ".png");
        if(titlebarposition == TOP) {
            reduce = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, super.getWidth() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, 0, dark, showtitlebar, icons);
        } else if(titlebarposition == BOTTOM){
            reduce = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, super.getWidth() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, super.getHeight() - DEFAULT_BUTTON_SIZE, dark, showtitlebar, icons);
        } else if(titlebarposition == LEFT){
            reduce = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, 0, super.getHeight() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, dark, showtitlebar, icons);
        } else {
            reduce = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, super.getWidth() - DEFAULT_BUTTON_SIZE, super.getHeight() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, dark, showtitlebar, icons);
        }
        reduce.changeColorWhenMouseOn(false);

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
        getTitlebar().addButton(reduce);
    }

    /**
     * initialize maximize button at top right corner if we want it
     */
    private void initMaximizeButton(){
        DefaultButton maximize;
        int nbbuttons = getTitlebar().getButtons().size();

        GuIconPair icons = new GuIconPair("assets/maximize", ".png");
        if(titlebarposition == TOP) {
            maximize = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, super.getWidth() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, 0, dark, showtitlebar, icons);
        } else if(titlebarposition == BOTTOM){
            maximize = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, super.getWidth() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, super.getHeight() - DEFAULT_BUTTON_SIZE, dark, showtitlebar, icons);
        } else if(titlebarposition == LEFT){
            maximize = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, 0, super.getHeight() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, dark, showtitlebar, icons);
        } else {
            maximize = new DefaultButton(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, super.getWidth() - DEFAULT_BUTTON_SIZE, super.getHeight() - (nbbuttons + 1) * DEFAULT_BUTTON_SIZE, dark, showtitlebar, icons);
        }
        maximize.changeColorWhenMouseOn(false);

        maximize.addActionListener(e -> {
            int x = 0, y = 0;
            if (!fullscreen) {
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Rectangle maximumWindowBound = environment.getMaximumWindowBounds();
                x = maximumWindowBound.width;
                y = maximumWindowBound.height;
                fullscreen = true;
                setLocation(0, 0);

            } else {
                x = DEFAULT_SCREEN_WIDTH;
                y = DEFAULT_SCREEN_HEIGHT;
                fullscreen = false;
                setLocation(position.getX(), position.getY());
            }

            setSize(x, y);
            getMainPanel().resizePanel(x, y);
            getTitlebar().resizePanel(x, y);
            for(int i = 0; i < getTitlebar().getButtons().size(); i++){
                if(titlebarposition == TOP){
                    getTitlebar().getButtonAt(i).setLocation(x - (i + 1) * DEFAULT_BUTTON_SIZE, 0);
                } else if (titlebarposition == BOTTOM){
                    getTitlebar().getButtonAt(i).setLocation(x - (i + 1) * DEFAULT_BUTTON_SIZE, super.getHeight() - DEFAULT_BUTTON_SIZE);
                } else if (titlebarposition == LEFT){
                    getTitlebar().getButtonAt(i).setLocation(0, y - (i + 1) * DEFAULT_BUTTON_SIZE);
                } else {
                    getTitlebar().getButtonAt(i).setLocation(super.getHeight() - DEFAULT_BUTTON_SIZE, y - (i + 1) * DEFAULT_BUTTON_SIZE);
                }
            }

            revalidate();
            repaint();
        });
        getTitlebar().addButton(maximize);
    }

    /**
     * set the dragger for the screen to move it on window
     */
    private void setScreenDragger(){
        ScreenDragger drag = new ScreenDragger(this);
        getTitlebar().addMouseMotionListener(drag);
        getTitlebar().addMouseListener(drag);
    }

    /**
     * set the name of the application
     * @param name the new name
     */
    public void setAppName(String name, Position2I pos, int width){
        JLabel apptitle = new JLabel(name);
        apptitle.setBounds(pos.getX(), pos.getY(), width, DEFAULT_TITLEBAR_SIZE);
        if(dark){ apptitle.setForeground(LIGHT_THEME.getMainColor());}
        getTitlebar().add(apptitle);

    }

    /**
     * set position of titlebar (top, left, right, bottom)
     * @param position of titlebar
     */
    public void setTitlebarPosition(int position){
        if(titlebarposition != position){
            if (position == TOP){
                getTitlebar().resizePanel(super.getWidth(), DEFAULT_TITLEBAR_SIZE);
                getTitlebar().setPosition(0,0);

                getMainPanel().resizePanel(super.getWidth(), super.getHeight() - DEFAULT_TITLEBAR_SIZE);
                getMainPanel().setPosition(0, DEFAULT_TITLEBAR_SIZE);

                for(int i = 0; i < getTitlebar().getButtons().size(); i++){
                    getTitlebar().getButtonAt(i).setPosition(super.getWidth() - (i + 1) * 45, 0);
                }

            } else if (position == BOTTOM){
                getTitlebar().resizePanel(super.getWidth(), DEFAULT_TITLEBAR_SIZE);
                getTitlebar().setPosition(0,super.getHeight() - DEFAULT_TITLEBAR_SIZE);

                getMainPanel().resizePanel(super.getWidth(), super.getHeight() - DEFAULT_TITLEBAR_SIZE);
                getMainPanel().setPosition(0, 0);

                for(int i = 0; i < getTitlebar().getButtons().size(); i++){
                    getTitlebar().getButtonAt(i).setPosition(super.getWidth() - (i + 1) * 45, super.getHeight() - DEFAULT_TITLEBAR_SIZE);
                }

            } else if (position == LEFT){
                getTitlebar().resizePanel(DEFAULT_TITLEBAR_SIZE, super.getHeight());
                getTitlebar().setPosition(0,0);

                getMainPanel().resizePanel(super.getWidth() - DEFAULT_TITLEBAR_SIZE, super.getHeight());
                getMainPanel().setPosition(DEFAULT_TITLEBAR_SIZE, 0);

                for(int i = 0; i < getTitlebar().getButtons().size(); i++){
                    getTitlebar().getButtonAt(i).resizeButton(45, 30);
                    getTitlebar().getButtonAt(i).setPosition(0, super.getHeight() - (i + 1) * 30);
                }

            } else if (position == RIGHT) {
                getTitlebar().resizePanel(DEFAULT_TITLEBAR_SIZE, super.getHeight());
                getTitlebar().setPosition(super.getWidth() - DEFAULT_TITLEBAR_SIZE,0);

                getMainPanel().resizePanel(super.getWidth() - DEFAULT_TITLEBAR_SIZE, super.getHeight());
                getMainPanel().setPosition(0, 0);
            }
            titlebarposition = position;
        }
    }

    /**
     * set the theme in dark
     */
    @Override
    public void setDarkMode() {
        for (Panel p : containers) {
            p.setDarkMode();
        }
        perso = false;
        dark = true;

    }

    /**
     * set the theme in light
     */
    @Override
    public void setLightMode() {
        for (Panel p : containers) {
            p.setLightMode();
        }
        perso = false;
        dark = false;
    }

    /**
     * set a personnal theme to the screen
     * @param main color
     * @param secondary color
     * @param interaction color
     */
    public void setPersonnalTheme(Color main, Color secondary, Color interaction) {
        changePersoTheme(main, secondary, interaction);
        for (Panel p : containers) {
            p.setPersonnalTheme();
        }
        dark = false;
        perso = true;
    }

    /**
     * @return the main panel on the current screen
     */
    public Panel getMainPanel(){
        return containers[0];
    }

    /**
     * @return the titlebar of the screen
     */
    public Panel getTitlebar(){
        return containers[1];
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
    public boolean isShowTitlebar() {
        return showtitlebar;
    }
}
