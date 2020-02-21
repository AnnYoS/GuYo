package gui;

import javax.swing.*;

import java.io.File;

import static util.Constant.*;

public class DefaultButton extends JButton {

    private boolean dark;
    private boolean withtitlebar;

    public DefaultButton(int width, int height, int x, int y, boolean dark, boolean withtitlebar){
        super();
        this.dark = dark;
        this.withtitlebar = withtitlebar;
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

    public void setGrey() {
        if(dark){
            setBackground(DEFAULT_DARK_GREY);
        } else {
            setBackground(DEFAULT_LIGHT_GREY);
        }
    }

    public void restoreColor() {
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
    }

    public void setImageOnButton(String path){
        setIcon(new ImageIcon(path));
    }
}
