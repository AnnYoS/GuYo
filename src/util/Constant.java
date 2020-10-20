package util;

import gui.view.icon.GuIconPair;

import java.awt.*;

public class Constant {

    public static final int DEFAULT_SCREEN_WIDTH = 640;
    public static final int DEFAULT_SCREEN_HEIGHT = 480;

    public static final int TOP = 5;
    public static final int RIGHT = 6;
    public static final int BOTTOM = 7;
    public static final int LEFT = 8;

    public static int DEFAULT_TITLEBAR_SIZE = 30;
    public static int DEFAULT_BUTTON_HEIGHT = 30;
    public static int DEFAULT_BUTTON_WIDTH = 45;
    public static int BORDER = 5;

    public static Theme DARK_THEME = new Theme(new Color(40, 40, 40), new Color(55, 55, 55), new Color(70, 70, 70));
    public static Theme LIGHT_THEME = new Theme(new Color(230, 230, 230), new Color(210, 210, 210), new Color(190, 190, 190));
    public static Theme PERSO_THEME = new Theme(new Color(0,0,0), new Color(0,0,0), new Color(0,0,0));

    public static Color DEFAULT_RED = new Color(220, 0, 0);

    public static GuIconPair EXIT_ICON = new GuIconPair("assets/cross", ".png");
    public static GuIconPair REDUCE_ICON = new GuIconPair("assets/reduce", ".png");
    public static GuIconPair MAXIMIZE_ICON = new GuIconPair("assets/maximize", ".png");
    public static GuIconPair MAXIMIZE_FS_ICON = new GuIconPair("assets/maximize_fs", ".png");

    /**
     * change the titlebar height of all windows
     * @param newheight the new height
     */
    public static void changeTitlebarSize(int newheight){
        DEFAULT_TITLEBAR_SIZE = newheight;
    }

    /**
     * change the default red color (for close button)
     * @param c new color
     */
    public static void changeDefaultRedColor(Color c){
        DEFAULT_RED = c;
    }

    /**
     * set a new dark theme
     * @param main color
     * @param secondary color
     * @param interaction color
     */
    public static void changeDarkTheme(Color main, Color secondary, Color interaction){
        DARK_THEME.setMaincolor(main);
        DARK_THEME.setSecondarycolor(secondary);
        DARK_THEME.setInteractcolor(interaction);
    }

    /**
     * set a new light theme
     * @param main color
     * @param secondary color
     * @param interaction color
     */
    public static void changeLightTheme(Color main, Color secondary, Color interaction){
        LIGHT_THEME.setMaincolor(main);
        LIGHT_THEME.setSecondarycolor(secondary);
        LIGHT_THEME.setInteractcolor(interaction);
    }

    /**
     * set a new perso theme
     * @param main color
     * @param secondary color
     * @param interaction color
     */
    public static void changePersoTheme(Color main, Color secondary, Color interaction){
        PERSO_THEME.setMaincolor(main);
        PERSO_THEME.setSecondarycolor(secondary);
        PERSO_THEME.setInteractcolor(interaction);
    }
}
