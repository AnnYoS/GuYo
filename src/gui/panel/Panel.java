package gui.panel;

import gui.GuYoComponent;
import gui.button.AbstractButton;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Panel extends JPanel implements GuYoComponent {

    protected boolean dark;
    protected List<AbstractButton> buttons;

    public Panel(int width, int height, boolean dark) {
        super();
        this.dark = dark;
        buttons = new ArrayList<>();
        setSize(width, height);
    }

    /**
     * @return the list of buttons in the panel
     */
    public List<AbstractButton> getButtons() {
        return buttons;
    }

    /**
     * add the button to the panel
     * @param b the button to add
     */
    public void addButton(AbstractButton b){
        add(b);
        buttons.add(b);
    }

    /**
     * add multiple buttons to the panel
     * @param buttons to add
     */
    public void addButtons(AbstractButton... buttons){
        for(AbstractButton b : buttons){
            add(b);
            this.buttons.add(b);
        }
    }
}
