package gui.panel.bar;

import gui.button.defaultbutton.AbstractDefaultButton;
import gui.panel.Panel;

import static util.Constant.*;

public abstract class Titlebar extends Panel {

    private boolean isShow;

    public Titlebar(int width, int height, boolean dark, boolean show) {
        super(width, height, dark);

        setBounds(0,0, width, DEFAULT_TITLEBAR_SIZE);
        isShow = show;

        if(dark){
            if(isShow){
                setBackground(DARK_THEME.getSecondaryColor());
            } else {
                setBackground(DARK_THEME.getMainColor());
            }
        } else {
            if(isShow){
                setBackground(WHITE_THEME.getSecondaryColor());
            } else {
                setBackground(WHITE_THEME.getMainColor());
            }
        }
    }

    /**
     * set the dark mode
     */
    @Override
    public void setDarkMode() {
        setBackground(DARK_THEME.getSecondaryColor());
        for (AbstractDefaultButton b : buttons) {
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
        for(AbstractDefaultButton b : buttons){
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
        setBackground(PERSO_TITLEBAR_COLOR);
        for(AbstractDefaultButton b : buttons){
            b.setPersonnalTheme();
        }
        dark = false;
        perso = true;
    }

    /**
     * resize the titlebar
     * @param width the new width of the titlebar
     */
    public void resizePanel(int width, int height){
        setSize(width, DEFAULT_TITLEBAR_SIZE);
    }

    /**
     * @return is the titlebar is visible
     */
    public boolean isShow(){
        return isShow;
    }
}
