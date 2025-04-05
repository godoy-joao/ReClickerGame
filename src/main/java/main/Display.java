/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controls.Controller;
import data.GameData;
import controls.InputHandler;
import data.Achievement;
import data.GameSetup;
import game.GameState;
import game.Notification;
import game.component.ComponentManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author João Guilherme
 */
public class Display extends JPanel implements Runnable {

    public static int WIDTH = 1366;
    public static int HEIGHT = 768;
    public static int fps;
    public static int notificationTick;

    public static Font varelaRound;
    private boolean running = false;
    private Thread thread;
    private final InputHandler inputHandler;
    private final Game game;

    public Display() {
        try {
            varelaRound = Font.createFont(Font.TRUETYPE_FONT, new File("/font/Varela_Round/VarelaRound-Regular.ttf"));
        } catch (Exception e) {

        }
        inputHandler = new InputHandler();
        game = new Game();
        setSize(WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDoubleBuffered(true);
        setBackground(Color.black);
        addMouseListener(inputHandler);
        addKeyListener(inputHandler);
        addMouseMotionListener(inputHandler);
        addFocusListener(inputHandler);
        setFocusable(true);
    }

    public void start() {
        running = true;
        GameSetup.setup();
        thread = new Thread(this);
        thread.start();
    }

    public void update() {
        game.tick(InputHandler.key, InputHandler.mouse);
    }

    @Override
    public void run() {

        long pastUpdateTime = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long pastTime = System.nanoTime();
        int frames = 0;
        int remainingSeconds = 60;
        do {
            long curTime = System.nanoTime();
            if (curTime - pastUpdateTime >= 1e8 / 6) {
                update();
                pastUpdateTime = System.nanoTime();

            }
            if (curTime - pastTime >= 1e8 / 12) {
                repaint();
                frames++;
                pastTime = System.nanoTime();
            }
            if (System.nanoTime() - lastUpdate >= 1e9) {
                lastUpdate = System.nanoTime();
                fps = frames;
                frames = 0;

                remainingSeconds--;
                GameData.tickSeconds();
                notificationTick--;
            }
            if (remainingSeconds <= 0) {
                remainingSeconds = 60;
                Achievement.tickAchievement();
                GameData.saveData();
            }
        } while (running);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        g2.drawImage(new UtilityTool().getImage("/layout/background.png"), 0 ,0, WIDTH, HEIGHT, null);
        g2.setColor(Color.red);
        try {
            ComponentManager.drawComponents(g2);
            g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 5));
            g2.drawString(Integer.toString(fps), 30, 50);
            g2.setFont(new Font("Winky Sans", Font.BOLD, 30));
            g2.drawString(Controller.currentEnemy.getName(), (int) Controller.currentEnemy.getX() + 10, (int) Controller.currentEnemy.getY() - 30);
            g2.drawString(Integer.toString(GameData.getLevel()), (int) Controller.currentEnemy.getX() - 20, (int) Controller.currentEnemy.getY() - 30);
            g2.drawString(Double.toString(Controller.currentEnemy.getHp()), (int) Controller.currentEnemy.getX() + 10, (int) Controller.currentEnemy.getY() - 50);
            g2.drawImage(Controller.currentEnemy.getSprite(), Controller.currentEnemy.x, Controller.currentEnemy.y, Controller.currentEnemy.width, Controller.currentEnemy.height, null);
        } catch (Exception e) {

        }
        Notification.showNext(g2);
    }

}
