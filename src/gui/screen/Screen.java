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

import static util.Constant.*;

public class Screen extends JFrame implements GuYoComponent {

    private Position2I position;
    private boolean dark;
    private boolean perso;
    private boolean showtitlebar;
    private boolean fullscreen;
    private Panel[] containers;

    public Screen(int width, int height, boolean dark, boolean showtitlebar){
        super();

        //initialize variables
        containers = new Panel[2];
        position = new Position2I();
        this.dark = dark;
        this.perso = false;
        this.showtitlebar = showtitlebar;
        this.fullscreen = false;

        //setting size and position of the screen
        setSize(width, height);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        position.setX((int) ((dimension.getWidth() - this.getWidth()) / 2));
        position.setY((int) ((dimension.getHeight() - this.getHeight()) / 2));
        setLocation(position.getX(), position.getY());

        initContainers(width, height);

        /*important to create our own titlebar and border*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        initWindow(width);
        setVisible(true);
    }

    /**
     * initialize the window
     * @param width of the window
     */
    protected void initWindow(int width){
        initExitButton(width);
        initMaximizeButton(width);
        initReduceButton(width);

        setScreenDragger();

        setLayout(new BorderLayout());
        add(getTitlebar());
        add(getMainpanel());
    }

    /**
     * initialize the containers on the screen
     * @param width dimension
     * @param height dimension
     */
    protected void initContainers(int width, int height){
        DefaultPanel main = new DefaultPanel(width, height, dark, showtitlebar);
        main.setLayout(null);
        containers[0] = main;

        DefaultTitlebar titlebar = new DefaultTitlebar(width, height, dark, showtitlebar);
        titlebar.setLayout(null);
        containers[1] = titlebar;
    }

    /**
     * initialize exit button at top right corner if we want it
     * @param width the width of the screen to know the position in the top right corner
     */
    protected void initExitButton(int width){
        DefaultButton exit;
        int nbbuttons = getTitlebar().getButtons().size();

        exit = new DefaultButton(45, DEFAULT_TITLEBAR_SIZE, width - (nbbuttons + 1)*45, 0, this.dark, showtitlebar,"assets/crossblack.png", "assets/crosswhite.png");
        exit.changeColorWhenMouseOn(true);
        exit.addActionListener(e -> System.exit(0));
        getTitlebar().addButton(exit);
    }

    /**
     * initialize reduce button at top right corner if we want it
     * @param width the width of the screen to know the position in the top right corner
     */
    protected void initReduceButton(int width){
        DefaultButton reduce;
        int nbbuttons = getTitlebar().getButtons().size();

        reduce = new DefaultButton(45, DEFAULT_TITLEBAR_SIZE, width - (nbbuttons + 1)*45, 0, this.dark, showtitlebar,"assets/reduceblack.png", "assets/reducewhite.png");
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
     * @param width the width of the screen to know the position in the top right corner
     */
    protected void initMaximizeButton(int width){
        DefaultButton maximize;
        int nbbuttons = getTitlebar().getButtons().size();

        maximize = new DefaultButton(45, DEFAULT_TITLEBAR_SIZE, width - (nbbuttons + 1)*45, 0, this.dark, showtitlebar,"assets/maximazeblack.png", "assets/maximazewhite.png");
        maximize.changeColorWhenMouseOn(false);

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
            getTitlebar().resizePanel(x, y);
            for(int i = 0; i < getTitlebar().getButtons().size(); i++){
                getTitlebar().getButtonAt(i).setLocation(x - (i + 1)*(int)getTitlebar().getButtonAt(i).getSize().getWidth(), 0);

            }

            revalidate();
            repaint();
        });
        getTitlebar().addButton(maximize);
    }

    /**
     * set the dragger for the screen to move it on window
     */
    protected void setScreenDragger(){
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
    public Panel getMainpanel(){
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
