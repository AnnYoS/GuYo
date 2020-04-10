package test;

import gui.screen.GuScreen;

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
        GuScreen screen = new GuScreen(TOP);
        screen.setDarkMode();
    }
}
