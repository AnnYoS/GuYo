package test;

import gui.screen.DefaultScreen;
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
        Screen screen = new DefaultScreen(600, 400,false, false);
    }
}
