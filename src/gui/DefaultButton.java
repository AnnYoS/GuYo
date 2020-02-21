package gui;

import javax.swing.*;

import static util.Constant.*;

public class DefaultButton extends JButton {

    public DefaultButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar){
        super();
        if(dark){
            if(withtitlebar) {
                setBackground(DEFAULT_TITLEBAR_BLACK_COLOR);
            } else {
                setBackground(DEFAULT_BLACK);
            }
        } else {
            if(withtitlebar) {
                setBackground(DEFAULT_TITLEBAR_WHITE_COLOR);
            } else {
                setBackground(DEFAULT_WHITE);
            }
        }
        setBorderPainted(false);
        setBounds(x, y, width, height);
    }

    public void moveButtonTo(int x, int y){
        setLocation(x, y);
    }
}
