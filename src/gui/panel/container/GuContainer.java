package gui.panel.container;

import gui.button.basicbutton.GuBasicButton;
import gui.panel.GuPanel;

import static util.Constant.*;

public abstract class GuContainer extends GuPanel {

    public GuContainer(int width, int height, boolean dark) {
        super(dark);
        initialize(width, height);
    }

    /**
     * initialize the panel
     * @param width dimension
     * @param height dimension
     */
    @Override
    protected void initialize(int width, int height) {
        setBounds(0, DEFAULT_TITLEBAR_SIZE, width, height - DEFAULT_TITLEBAR_SIZE);

        if(dark){
            setBackground(DARK_THEME.getMainColor());
        } else {
            setBackground(LIGHT_THEME.getMainColor());
        }
    }

    /**
     * set the dark mode
     */
    @Override
    public void setDarkMode() {
        setBackground(DARK_THEME.getMainColor());
        for(GuBasicButton b : defaultbuttons){
            b.setDarkMode();
        }
        perso = false;
        dark = true;
    }

    /**
     * set the light mode
     */
    @Override
    public void setLightMode() {
        setBackground(DARK_THEME.getMainColor());
        for(GuBasicButton b : defaultbuttons){
            b.setLightMode();
        }
        perso = false;
        dark = false;
    }

    /**
     * set the personnal theme to the container
     */
    @Override
    public void setPersonnalTheme() {
        setBackground(PERSO_THEME.getMainColor());
        for (GuBasicButton b : defaultbuttons) {
            b.setPersonnalTheme();
        }
        dark = false;
        perso = true;
    }

    /**
     * resize the main panel
     * @param width dimension
     * @param height dimension
     */
    public void resizePanel(int width, int height) {
        setSize(width, height - DEFAULT_TITLEBAR_SIZE);
    }

    /**
     * set new position of the titlebar
     * @param x position
     * @param y position
     */
    public void setPosition(int x, int y){
        setBounds(x, y, super.getWidth(), super.getHeight());
    }
}
