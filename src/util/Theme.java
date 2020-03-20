package util;

import java.awt.*;

public class Theme {

    private Color maincolor;
    private Color secondarycolor;
    private Color interactcolor;

    /**
     * default theme
     */
    public Theme(){
        maincolor = new Color(230,230,230);
        secondarycolor = new Color(210,210,210);
        interactcolor = new Color(190, 190, 190);
    }

    /**
     * custom theme
     * @param main color
     * @param secondary color
     * @param interact color
     */
    public Theme(Color main, Color secondary, Color interact){
        maincolor = main;
        secondarycolor = secondary;
        interactcolor = interact;
    }

    /**
     * @return the main color of the theme
     */
    public Color getMainColor() {
        return maincolor;
    }

    /**
     * @return the secondary color of the theme
     */
    public Color getSecondaryColor() {
        return secondarycolor;
    }

    /**
     * @return the interaction color of the theme
     */
    public Color getInteractColor() {
        return interactcolor;
    }

    /**
     * set new color for the main color of theme
     * @param main color
     */
    public void setMaincolor(Color main) { maincolor = main; }

    /**
     * set new color for the secondary  of theme
     * @param secondary color
     */
    public void setSecondarycolor(Color secondary) { secondarycolor = secondary; }

    /**
     * set new interaction color of the theme
     * @param interaction color
     */
    public void setInteractcolor(Color interaction) { interactcolor = interaction; }
}
