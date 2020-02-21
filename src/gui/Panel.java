package gui;

import javax.swing.*;

import static util.Constant.*;

public class Panel extends JPanel {

    public Panel(int width, int height, boolean dark, boolean withtitlebar){
        super();
        if(dark){
            setBackground(DEFAULT_BLACK);
        } else {
            setBackground(DEFAULT_WHITE);
        }

        if(withtitlebar){
            setSize(width,height - 30);
        } else {
            setSize(width, height);
        }
    }

    /**
     * set the theme in dark mode
     */
    public void setDarkMode(){
        setBackground(DEFAULT_BLACK);
    }

    /**
     * set the theme in light mode
     */
    public void setLightMode(){
        setBackground(DEFAULT_WHITE);
    }

    public void resizePanel(int width, int height){
        setSize(width, height);
    }
}
