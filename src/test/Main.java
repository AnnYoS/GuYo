package test;

import gui.screen.GuScreen;

import javax.swing.*;

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
        GuScreen screen = new GuScreen();
        //screen.setTitlebarPosition(LEFT);
        //screen.setDarkMode();
    }
}
