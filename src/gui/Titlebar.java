package gui;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static util.Constant.*;

public class Titlebar extends JPanel {

    public Titlebar(int width, boolean dark){
        super();
        if(dark){
            setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
        } else {
            setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
        }
        setSize(width, DEFAULT_TITLEBAR_HEIGHT);
    }

    /**
     * set the theme in dark mode
     */
    public void setDarkMode(){
        setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
    }

    /**
     * set the theme in light mode
     */
    public void setLightmode(){
        setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
    }

    public void resizeTitlebar(int width){
        setSize(width, DEFAULT_TITLEBAR_HEIGHT);
    }
}
