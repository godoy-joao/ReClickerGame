/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author João Guilherme
 */
public class GameState {

    public static boolean pause = false;
    public static boolean onShop = false;
    public static int shopId = 0;

    public static void pauseGame() {
        pause = true;
        openMenu();
        
    }

    public static void openMenu() {
        
    }

    public static void unpauseGame() {
        pause = false;
    }

    public static void openShop() {
        onShop = true;
        shopId = 1;
    }

    public static void goToItemShop() {
        shopId = 2;
    }

    public static void goToHeroShop() {
        shopId = 3;
    }

    public static void goToPlayerShop() {
        shopId = 1;
    }

    public static void exitShop() {
        shopId = 0;
        onShop = false;
    }

    public static void exit() {
        System.out.println("Exit");
        System.exit(0);
    }
}
