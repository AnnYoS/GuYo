package test;

import gui.screen.Screen;

import javax.swing.*;

import static util.Constant.*;

public class Main {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                display();
            }
        });
    }

    public static void display(){
        Screen screen = new Screen();
        //screen.setTitlebarPosition(LEFT);
        //screen.setDarkMode();
    }
}
