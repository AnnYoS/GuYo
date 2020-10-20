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
        GuScreen screen = new GuScreen(900, 600, false);
        screen.setDarkMode();
        screen.setLogo("assets/logo.png", 10, 5);
        screen.setLogoLocation(7, 5);

    }
}
