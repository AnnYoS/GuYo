package gui.button.defaultbutton;

public class DefaultButton extends AbstractDefaultButton {

    public DefaultButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar, String darkimage, String lightimage){
        super(width, height, x, y, dark, withtitlebar,darkimage, lightimage);
        setBorderPainted(false);
    }
}
