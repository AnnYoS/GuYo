package gui.panel;

import gui.GuComponent;
import gui.button.defaultbutton.AbstractDefaultButton;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Panel extends JPanel implements GuComponent {

    protected boolean dark;
    protected boolean perso;
    protected int titlebarposition; //TOP, LEFT, RIGHT, BOTTOM

    protected List<AbstractDefaultButton> buttons;

    public Panel(boolean dark, int titlebarposition) {
        super();
        this.dark = dark;
        this.perso = false;
        this.titlebarposition = titlebarposition;
        buttons = new ArrayList<>();
    }

    /**
     * @return the list of buttons in the panel
     */
    public List<AbstractDefaultButton> getButtons() {
        return buttons;
    }

    /**
     * get the button at index
     * @param index the index of the button
     * @return the button
     */
    public AbstractDefaultButton getButtonAt(int index){
        return buttons.get(index);
    }

    /**
     * add the button to the panel
     * @param b the button to add
     */
    public void addButton(AbstractDefaultButton b){
        add(b);
        buttons.add(b);
    }

    /**
     * add multiple buttons to the panel
     * @param buttons to add
     */
    public void addButtons(AbstractDefaultButton... buttons){
        for(AbstractDefaultButton b : buttons){
            add(b);
            this.buttons.add(b);
        }
    }

    /**
     * resize the panel
     * @param width new width
     * @param height new height
     */
    public abstract void resizePanel(int width, int height);

    /**
     * set a new position for the panel
     * @param x position
     * @param y position
     */
    public abstract void setPosition(int x, int y);

    /**
     * change the theme into personnal
     */
    public abstract void setPersonnalTheme();
}
