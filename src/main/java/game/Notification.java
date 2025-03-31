/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import main.Display;
import main.UtilityTool;

/**
 *
 * @author João Guilherme
 */
public class Notification {

    private String title;
    private String body;
    private static BufferedImage layout;
    public static List<Notification> notifications;
    public static long lastTime = System.nanoTime();
    public static int ticksLeft = 0;
    UtilityTool uTool = new UtilityTool();

    public static void showNext(Graphics2D g) {
        if (notifications == null || notifications.size() <= 0 || notifications.isEmpty()) {
            return;
        }
        if (ticksLeft == 0 && !notifications.isEmpty()) {
            ticksLeft = 5;
        }
        if (System.nanoTime() - lastTime >= 1e9) {
            ticksLeft--;
            lastTime = System.nanoTime();
        }
        Notification n = notifications.get(0);
        Font font = new Font("Arial", Font.PLAIN, 30);

        int imageX = 0;
        int imageY = Display.HEIGHT - 200;
        g.drawImage(layout, imageX, imageY, layout.getWidth(), layout.getHeight(), null);
        g.setColor(Color.white);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        g.drawString(n.getBody(), (layout.getWidth() - fm.stringWidth(n.getBody())) / 2, imageY + (layout.getHeight() + fm.getHeight()) / 2);
        g.setColor(Color.black);
        font.deriveFont(20f);
        g.setFont(font);
        g.drawString(n.getTitle(), 10, imageY + 35);
        if (ticksLeft == 0) {
            notifications.remove(0);
        }
    }

    public static void addNotification(String title, String body) {
        if (notifications == null) {
            notifications = new ArrayList();
        }
        notifications.add(new Notification(title, body));
    }

    public Notification(String title, String body) {
        this.title = title;
        this.body = body;
        layout = uTool.getImage("/layout/notification.png");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
