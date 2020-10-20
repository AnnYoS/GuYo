package gui.panel.bar;

import gui.button.basicbutton.GuBasicButton;
import gui.panel.GuPanel;
import gui.view.icon.GuIcon;

import javax.swing.*;

import static util.Constant.*;

public abstract class GuTitlebar extends GuPanel {

    private boolean isShow;

    private JLabel logo;

    public GuTitlebar(int width, int height, boolean dark, boolean show) {
        super(dark);
        logo = new JLabel();
        isShow = show;
        initialize(width, height);
    }

    /**
     * intialize the titlebar
     * @param width dimension
     * @param height dimension
     */
    @Override
    protected void initialize(int width, int height) {
        setBounds(0,0, width, DEFAULT_TITLEBAR_SIZE);

        if(dark){
            if(isShow){
                setBackground(DARK_THEME.getSecondaryColor());
            } else {
                setBackground(DARK_THEME.getMainColor());
            }
        } else {
            if(isShow){
                setBackground(LIGHT_THEME.getSecondaryColor());
            } else {
                setBackground(LIGHT_THEME.getMainColor());
            }
        }
    }

    /**
     * set the dark mode
     */
    @Override
    public void setDarkMode() {
        setBackground(DARK_THEME.getSecondaryColor());
        for (GuBasicButton b : defaultbuttons) {
            b.setDarkMode();
        }
        dark = true;
        perso = false;
    }

    /**
     * set the dark mode
     */
    @Override
    public void setLightMode() {
        setBackground(DARK_THEME.getSecondaryColor());
        for(GuBasicButton b : defaultbuttons){
            b.setLightMode();
        }
        dark = true;
        perso = false;
    }

    /**
     * set the personnal theme
     */
    @Override
    public void setPersonnalTheme() {
        setBackground(PERSO_THEME.getSecondaryColor());
        for(GuBasicButton b : defaultbuttons){
            b.setPersonnalTheme();
        }
        dark = false;
        perso = true;
    }

    /**
     * set the logo to the titlebar
     * @param logo of the application
     */
    public void setLogo(GuIcon logo, int x, int y){
        this.logo.setIcon(logo.getIcon());
        this.logo.setBounds(x, y, logo.getIcon().getIconWidth(), logo.getIcon().getIconHeight());
        add(this.logo);
    }

    public void setLogoLocation(int x, int y){
        logo.setLocation(x, y);
    }

    /**
     * resize the titlebar
     * @param width dimension
     * @param height dimension
     */
    public void resizePanel(int width, int height){
        setSize(width, DEFAULT_TITLEBAR_SIZE);
    }

    /**
     * set new position of the titlebar
     * @param x position
     * @param y position
     */
    public void setPosition(int x, int y){
        setBounds(x, y, super.getWidth(), super.getHeight());
    }

    /**
     * @return is the titlebar is visible
     */
    public boolean isShow(){
        return isShow;
    }
}
