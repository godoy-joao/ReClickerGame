/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author João Guilherme
 */
public class Player {
    
    private static int id;
    private static String name;
    private static long gold;
    private static long diamonds;
    private static long baseDamageBeforeBuffs;
    private static long baseDamage;
    private static long level;
    private static long clickCount;
    
    public static void savePlayerData() {
        
    }
    
    public static void getPlayerData() {
        
    }
    
    public static long getClickCount() {
        return clickCount;
    }
    
    public static void updateClicks() {
        clickCount++;
    }
    
    public static void updateClicks(int quantity) {
        clickCount+=quantity;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Player.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static long getGold() {
        return gold;
    }

    public static void setGold(long gold) {
        Player.gold = gold;
    }

    public static long getDiamonds() {
        return diamonds;
    }

    public static void setDiamonds(long diamonds) {
        Player.diamonds = diamonds;
    }

    public static long getBaseDamageBeforeBuffs() {
        return baseDamageBeforeBuffs;
    }

    public static void setBaseDamageBeforeBuffs(long baseDamageBeforeBuffs) {
        Player.baseDamageBeforeBuffs = baseDamageBeforeBuffs;
    }

    public static long getBaseDamage() {
        return baseDamage;
    }

    public static void setBaseDamage(long baseDamage) {
        Player.baseDamage = baseDamage;
    }

    public static long getLevel() {
        return level;
    }

    public static void setLevel(long level) {
        Player.level = level;
    }
     
}
