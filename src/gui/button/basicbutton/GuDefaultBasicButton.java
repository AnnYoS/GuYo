package gui.button.basicbutton;

import gui.view.icon.GuIconPair;

public class GuDefaultBasicButton extends GuBasicButton {

    public GuDefaultBasicButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar, GuIconPair icons){
        super(width, height, x, y, dark, withtitlebar,icons);
        setBorderPainted(false);
    }
}
