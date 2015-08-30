package com.kinglydesign;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kody on 8/30/2015.
 */
public class Game extends Canvas implements Runnable {

    public static int width = 1920;
    public static int height = 1080;
    public static int scale = 3;

    public Thread thread;
    private JFrame frame;
    public boolean running = false;

    public Game(){

        Dimension size = new Dimension(width*scale, height*scale);
        setPreferredSize(size);
        frame = new JFrame();
    }

    public synchronized void start(){
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (running){
            System.out.println("Game window is running");

        }
    }
    public static void main(String[] args){
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setTitle("Dungeon Master");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();

    }
}
