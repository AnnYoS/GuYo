package util;

import java.awt.*;

public class Constant {

    public static final int DEFAULT_SCREEN_WIDTH = 640;
    public static final int DEFAULT_SCREEN_HEIGHT = 480;

    public static final int TOP = 5;
    public static final int RIGHT = 6;
    public static final int BOTTOM = 7;
    public static final int LEFT = 8;

    public static int DEFAULT_TITLEBAR_SIZE = 30;
    public static int BORDER = 5;

    public static final Theme DARK_THEME = new Theme(new Color(40, 40, 40), new Color(55, 55, 55), new Color(70, 70, 70));
    public static final Theme WHITE_THEME = new Theme(new Color(230, 230, 230), new Color(210, 210, 210), new Color(190, 190, 190));

    public static Color DEFAULT_RED = new Color(220, 0, 0);

    public static Color PERSO_THEME_MAIN = new Color(0,0,0);
    public static Color PERSO_TITLEBAR_COLOR = new Color(0,0,0);
    public static Color PERSO_COLOR_MOUSE_ON = new Color(0,0,0);

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
     * change the main color of the personnal theme
     * @param c new color
     */
    public static void changePersonnalColorMainTheme(Color c) { PERSO_THEME_MAIN = c; }

    /**
     * change the color of the new titlebar personnal color
     * @param c new color
     */
    public static void changePersonnalTitlebarColor(Color c) { PERSO_TITLEBAR_COLOR = c; }

    /**
     * change the color of the button when the mouse is on
     * @param c new color
     */
    public static void changePersonnalColorMouseOn(Color c) { PERSO_COLOR_MOUSE_ON = c; }
}
