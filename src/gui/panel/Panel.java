package gui.panel;

import gui.GuYoComponent;
import gui.button.defaultbutton.AbstractDefaultButton;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Panel extends JPanel implements GuYoComponent {

    protected boolean dark;
    protected List<AbstractDefaultButton> buttons;

    public Panel(int width, int height, boolean dark) {
        super();
        this.dark = dark;
        buttons = new ArrayList<>();
        setSize(width, height);
    }

    /**
     * @return the list of buttons in the panel
     */
    public List<AbstractDefaultButton> getButtons() {
        return buttons;
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
}
