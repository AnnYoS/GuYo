package gui.panel.bar;

import gui.button.defaultbutton.AbstractDefaultButton;
import gui.panel.Panel;

import static util.Constant.*;

public abstract class Titlebar extends Panel {

    protected int position;

    public Titlebar(int width, int height, boolean dark, int barposition) {
        super(width, height, dark);
        position = barposition;
        if(barposition == TOP){
            setBounds(0,0, width, DEFAULT_TITLEBAR_SIZE);
        } else if (barposition == LEFT){
            setBounds(0,0, DEFAULT_TITLEBAR_SIZE, height);
        } else if (barposition == RIGHT){
            setBounds(width - DEFAULT_TITLEBAR_SIZE, 0, DEFAULT_TITLEBAR_SIZE, height);
        } else if (barposition == BOTTOM){
            setBounds(0, height - DEFAULT_TITLEBAR_SIZE, width, DEFAULT_TITLEBAR_SIZE);
        }
        if(dark){
            setBackground(DARK_THEME.getSecondaryColor());
        } else {
            setBackground(WHITE_THEME.getSecondaryColor());
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
}
