package gui.screen;

import gui.GuComponent;
import gui.button.basicbutton.GuDefaultBasicButton;
import gui.panel.GuPanel;
import gui.panel.bar.GuDefaultTitlebar;
import gui.panel.bar.GuTitlebar;
import gui.panel.container.GuDefaultContainer;
import gui.screen.mouselistener.ScreenDragger;
import gui.view.icon.GuIcon;
import util.Position2I;

import javax.swing.*;
import java.awt.*;

import static util.Constant.*;

public class GuScreen extends JFrame implements GuComponent {

    private Position2I position;
    private Dimension dscreen;

    private boolean dark;
    private boolean perso;
    private boolean showtitlebar;
    private boolean fullscreen;

    private GuPanel[] containers;

    public GuScreen(int width, int height, boolean isDark, boolean isShowTitlebar){
        super();
        initVariables(width, height, isDark, isShowTitlebar);
        initialize();
    }

    public GuScreen(int width, int height, boolean isDark){
        super();
        initVariables(width, height, isDark, true);
        initialize();
    }

    public GuScreen(boolean isDark, boolean isShowTitlebar){
        super();
        initVariables(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, isDark, isShowTitlebar);
        initialize();

    }

    public GuScreen(){
        super();
        initVariables(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT, false, true);
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
     */
    private void initVariables(int width, int height, boolean isDark, boolean isShowTitlebar){
        containers = new GuPanel[2];

        setSize(width, height);
        dscreen = new Dimension(width, height);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        position = new Position2I((int)((dimension.getWidth() - this.getWidth()) / 2), (int)((dimension.getHeight() - this.getHeight()) / 2));

        dark = isDark;
        perso = false;
        showtitlebar = isShowTitlebar;
        fullscreen = false;

        //setting size and position of the screen
        setLocation(position.getX(), position.getY());
    }

    /**
     * initialize the containers on the screen
     */
    private void initContainers(){
        setLayout(new BorderLayout());
        GuDefaultContainer main = new GuDefaultContainer(super.getWidth(), super.getHeight(), dark);
        main.setLayout(null);
        containers[0] = main;
        add(getMainPanel());

        GuDefaultTitlebar titlebar = new GuDefaultTitlebar(super.getWidth(), super.getHeight(), dark, showtitlebar);
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
        GuDefaultBasicButton exit;
        int nbbuttons = getTitlebar().getDefaultButtons().size();

        exit = new GuDefaultBasicButton(DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT, super.getWidth() - (nbbuttons + 1) * DEFAULT_BUTTON_WIDTH, 0, dark, showtitlebar, EXIT_ICON);

        exit.changeColorWhenMouseOn(true);
        exit.addActionListener(e -> System.exit(0));
        getTitlebar().addButton(exit);
    }

    /**
     * initialize reduce button at top right corner if we want it
     */
    private void initReduceButton(){
        GuDefaultBasicButton reduce;
        int nbbuttons = getTitlebar().getDefaultButtons().size();

        reduce = new GuDefaultBasicButton(DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT, super.getWidth() - (nbbuttons + 1) * DEFAULT_BUTTON_WIDTH, 0, dark, showtitlebar, REDUCE_ICON);
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
        GuDefaultBasicButton maximize;
        int nbbuttons = getTitlebar().getDefaultButtons().size();

        maximize = new GuDefaultBasicButton(DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT, super.getWidth() - (nbbuttons + 1) * DEFAULT_BUTTON_WIDTH, 0, dark, showtitlebar, MAXIMIZE_ICON);
        maximize.changeColorWhenMouseOn(false);
        maximize.addActionListener(e -> {
            int x = 0, y = 0;
            if (!fullscreen) {
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Rectangle maximumWindowBound = environment.getMaximumWindowBounds();
                x = maximumWindowBound.width;
                y = maximumWindowBound.height;
                fullscreen = true;
                maximize.changeIcons(MAXIMIZE_FS_ICON);
                setLocation(0, 0);

            } else {
                x = dscreen.width;
                y = dscreen.height;
                fullscreen = false;
                maximize.changeIcons(MAXIMIZE_ICON);
                setLocation(position.getX(), position.getY());
            }

            setSize(x, y);
            getMainPanel().resizePanel(x, y);
            getTitlebar().resizePanel(x, y);
            for(int i = 0; i < getTitlebar().getDefaultButtons().size(); i++){
                getTitlebar().getDefaultButtonAt(i).setLocation(x - (i + 1) * DEFAULT_BUTTON_WIDTH, 0);
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
     * set the logo of the application desktop
     * @param logopath path of the logo
     * @param x position in x
     * @param y position in y
     */
    public void setLogo(String logopath, int x, int y){
        GuIcon logo = new GuIcon(logopath);
        getTitlebar().setLogo(logo,x , y);
    }

    /**
     * set a new location for the logo
     * @param x location
     * @param y location
     */
    public void setLogoLocation(int x, int y){
        getTitlebar().setLogoLocation(x, y);
    }

    /**
     * set the theme in dark
     */
    @Override
    public void setDarkMode() {
        for (GuPanel p : containers) {
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
        for (GuPanel p : containers) {
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
        for (GuPanel p : containers) {
            p.setPersonnalTheme();
        }
        dark = false;
        perso = true;
    }

    /**
     * @return the main panel on the current screen
     */
    public GuPanel getMainPanel(){
        return containers[0];
    }

    /**
     * @return the titlebar of the screen
     */
    public GuTitlebar getTitlebar(){
        return (GuTitlebar) containers[1];
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

    /**
     * @return dimension of the screen
     */
    public Dimension getScreenDimensions() {
        return dscreen;
    }
}
