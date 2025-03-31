/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import data.Player;
import game.component.ComponentManager;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author João Guilherme
 */
public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, FocusListener {

    public static Point mousePosition;
    
    public static boolean[] key = new boolean[68836];
    public static boolean[] mouse = new boolean[MouseInfo.getNumberOfButtons() + 1];
    public static boolean mouseLeft;
    public static boolean gameFocused;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        if (keyPressed > 0 && keyPressed < key.length) {
            key[keyPressed] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        if (keyPressed > 0 && keyPressed < key.length) {
            key[keyPressed] = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Player.updateClicks();
        ComponentManager.checkIfComponentWasClicked(mousePosition);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouse[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouse[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition = e.getPoint();
    }

    @Override
    public void focusGained(FocusEvent e) {
        gameFocused = true;
    }

    @Override
    public void focusLost(FocusEvent e) {
        gameFocused = false;
    }

}
