package test;

import gui.screen.FitScreen;
import gui.screen.Screen;

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
        Screen screen = new FitScreen(false, true);
    }
}
