/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import data.Achievement;
import entity.Enemy;

import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author João Guilherme
 */
public class Controller {

    public static Enemy currentEnemy;
    private Random random = new Random();
    private long lastClickTime = System.nanoTime();
    private boolean isPressed;

    public void tick(boolean fPressed, boolean gPressed, boolean hPressed) {

        if (fPressed) {

        }
        if (gPressed) {

        }
        if (hPressed) {

        }

        try {
            if (InputHandler.gameFocused) {
                if (InputHandler.mouse[MouseEvent.BUTTON1] && currentEnemy.contains(InputHandler.mousePosition) && !isPressed) {
                    currentEnemy.takeDamage();
                    isPressed = true;
                    Achievement.tickAchievement();
                }
                if (!InputHandler.mouse[MouseEvent.BUTTON1] && currentEnemy.contains(InputHandler.mousePosition)) {
                    isPressed = false;
                }
            }
        } catch (Exception e) {
        }

    }
}
