package gui.panel;

import gui.GuComponent;
import gui.button.defaultbutton.GuBasicButton;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GuPanel extends JPanel implements GuComponent {

    protected boolean dark;
    protected boolean perso;
    protected int titlebarposition; //TOP, LEFT, RIGHT, BOTTOM

    protected List<GuBasicButton> defaultbuttons;

    public GuPanel(boolean dark, int titlebarposition) {
        super();
        this.dark = dark;
        this.titlebarposition = titlebarposition;
        perso = false;
        defaultbuttons = new ArrayList<>();
    }

    /**
     * initalize the panel
     * @param width dimension
     * @param height dimension
     */
    protected abstract void initialize(int width, int height);

    /**
     * @return the list of buttons in the panel
     */
    public List<GuBasicButton> getDefaultButtons() {
        return defaultbuttons;
    }

    /**
     * get the button at index
     * @param index the index of the button
     * @return the button
     */
    public GuBasicButton getDefaultButtonAt(int index){
        return defaultbuttons.get(index);
    }

    /**
     * add the button to the panel
     * @param b the button to add
     */
    public void addButton(GuBasicButton b){
        add(b);
        defaultbuttons.add(b);
    }

    /**
     * add multiple buttons to the panel
     * @param buttons to add
     */
    public void addButtons(GuBasicButton... buttons){
        for(GuBasicButton b : buttons){
            add(b);
            this.defaultbuttons.add(b);
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
