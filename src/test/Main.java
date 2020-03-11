package test;

import gui.screen.DefaultScreen;
import gui.screen.Screen;

import javax.swing.*;
import java.awt.*;

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
        Screen screen = new DefaultScreen(false, true);
        screen.setPersonnalTheme(Color.cyan, Color.magenta, Color.yellow);
    }
}
