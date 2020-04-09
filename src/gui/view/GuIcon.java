package gui.view;

import javax.swing.*;

public class GuIcon {

    private ImageIcon icon;


    public GuIcon(String path, String extension){
        icon = new ImageIcon(path+extension);
        icon.setDescription(path+extension); //description use to keep the path of the image in memory
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

    /**
     * @return the path if needed of the image of this icon
     */
    public String getPath(){
        return icon.getDescription();
    }
}
