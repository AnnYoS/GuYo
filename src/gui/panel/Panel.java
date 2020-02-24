package gui.panel;

import gui.GuYoComponent;

import javax.swing.*;

public abstract class Panel extends JPanel implements GuYoComponent {

    protected boolean dark;

    public Panel(int width, int height, boolean dark) {
        super();
        this.dark = dark;
        setSize(width, height);
    }

    /**
     * set the dark mode
     */
    @Override
    public void setDarkMode() {

    }

    /**
     * set the light mode
     */
    @Override
    public void setLightMode() {

    }
}
