/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controls.Controller;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author João Guilherme
 */
public class Game {

    public Controller controls;

    public Game() {
        controls = new Controller();

    }

    public void tick(boolean[] key, boolean[] mouse) {

        boolean f = key[KeyEvent.VK_F];
        boolean g = key[KeyEvent.VK_G];
        boolean h = key[KeyEvent.VK_H];
        controls.tick(f, g, h);
    }
}
