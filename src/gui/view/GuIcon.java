package gui.view;

import javax.swing.*;

public class GuIcon {

    private ImageIcon icon;

    /**
     * create new Icon who don't need to change color
     * @param path path of image
     * @param extension image extension (ex: .png)
     */
    public GuIcon(String path, String extension){
        icon = new ImageIcon(path+extension);
        icon.setDescription(path+extension);
    }

    public GuIcon(String path){
        icon = new ImageIcon(path);
        icon.setDescription(path);
    }

    /**
     * @return path of icon
     */
    public ImageIcon getIcon(){
        return icon;
    }

    /**
     * set image to the icon
     * @param path of icon
     */
    public void setIcon(String path) {
        icon = new ImageIcon(path);
        icon.setDescription(path);
    }
}
