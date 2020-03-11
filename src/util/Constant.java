package util;

import java.awt.*;

public class Constant {

    public static final int DEFAULT_SCREEN_WIDTH = 640;
    public static final int DEFAULT_SCREEN_HEIGHT = 480;

    public static final int TOP_RIGHT_CORNER = 1;
    public static final int BOTTOM_RIGHT_CORNER = 2;
    public static final int BOTTOM_LEFT_CORNER = 3;
    public static final int TOP_LEFT_CORNER = 4;

    public static int DEFAULT_TITLEBAR_HEIGHT = 30;
    public static int BORDER = 5;

    public static Color DEFAULT_BLACK = new Color(40, 40, 40);
    public static Color DEFAULT_TITLEBAR_BLACK_COLOR = new Color(55, 55, 55);

    public static Color DEFAULT_WHITE = new Color(230, 230, 230);
    public static Color DEFAULT_TITLEBAR_WHITE_COLOR = new Color(210, 210, 210);

    public static Color DEFAULT_RED = new Color(220, 0, 0);
    public static Color DEFAULT_COLOR_WHITE_MOUSE_ON = new Color(190, 190, 190);
    public static Color DEFAULT_COLOR_DARK_MOUSE_ON = new Color(70, 70, 70);

    /**
     * change the titlebar height of all windows
     * @param newheight the new height
     */
    public static void changeTitlebarHeight(int newheight){
        DEFAULT_TITLEBAR_HEIGHT = newheight;
    }

    /**
     * change the default dark color
     * @param c the new color
     */
    public static void changeDefaultBlack(Color c){
        DEFAULT_BLACK = c;
    }

    /**
     * change the dafault light color
     * @param c the new color
     */
    public static void changeDefaultWhite(Color c){
        DEFAULT_WHITE = c;
    }

    /**
     * change the default titlebar dark color
     * @param c the new color
     */
    public static void changeDefaultTitlebarBlack(Color c){
        DEFAULT_TITLEBAR_BLACK_COLOR = c;
    }

    /**
     * change the default titlebar light color
     * @param c the new color
     */
    public static void changeDefaultTitlebarWhite(Color c){
        DEFAULT_TITLEBAR_WHITE_COLOR = c;
    }

    /**
     * change the default red color (for close button)
     * @param c the new color
     */
    public static void changeDefaultRedColor(Color c){
        DEFAULT_RED = c;
    }

    /**
     * change the default color for button when the mouse is on the button in light theme
     * @param c the new color
     */
    public static void changeDefaultColorWhiteWhenMouseIsOnButton(Color c){
        DEFAULT_COLOR_WHITE_MOUSE_ON = c;
    }

    /**
     * change the default color for button when the mouse is on the button in dark theme
     * @param c the new color
     */
    public static void changeDefaultColorDarkWhenMouseIsOnButton(Color c){
        DEFAULT_COLOR_DARK_MOUSE_ON = c;
    }
}
