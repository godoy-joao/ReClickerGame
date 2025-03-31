/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import controls.Controller;
import entity.Enemy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.UtilityTool;
import org.json.simple.JSONObject;

/**
 * @author João Guilherme
 */
public class GameData {

    private static int level;
    private static LocalDateTime gameTime;
    private static long totalGameSeconds = 0;
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static int getLevel() {
        return level;
    }

    public static void nextLevel() {
        level++;
        saveData();
    }

    public static void setLevel(int newLevel) {
        level = newLevel;
    }

    public static List<Item> getItems() {
        List<Item> playerItems = new ArrayList();
        
        return playerItems;
    }

    public static long getTotalElapsedSeconds() {
        return totalGameSeconds;
    }

    public static LocalDateTime getLastTime() {
        return gameTime;
    }

    public static LocalDateTime updateGameTime() {
        gameTime = LocalDateTime.now();
        return gameTime;
    }

    public static void tickSeconds() {
        totalGameSeconds++;
    }

    public static JSONObject checkSave() {
        return UtilityTool.fileToJson(FileManager.GAME_DATA_PATH);
    }

    public static void loadData() {
        JSONObject json = (JSONObject) UtilityTool.fileToJson(FileManager.GAME_DATA_PATH).get("gameData");
        level = Integer.parseInt(json.get("level").toString());
        try {
            gameTime = (LocalDateTime) LocalDateTime.parse((String) json.get("lastTime"), format);
        } catch (Exception e) {
            gameTime = LocalDateTime.now();
        }
        try {
            totalGameSeconds = (long) json.get("totalGameSeconds");
        } catch (Exception e) {
            totalGameSeconds = 0;
        }
        Controller.currentEnemy = new Enemy(Enemy.getEnemyNames().get(new Random().nextInt(Enemy.getEnemyNames().size())));
    }

    public static void saveData() {
        JSONObject json = UtilityTool.fileToJson(FileManager.GAME_DATA_PATH);
        JSONObject gameData = (JSONObject) json.get("gameData");
        gameData.replace("level", getLevel());
        gameData.replace("lastTime", updateGameTime().format(format));
        gameData.replace("currentEnemy", Controller.currentEnemy.getName());
        gameData.replace("totalGameSeconds", getTotalElapsedSeconds());
        JSONObject saveFile = new JSONObject();
        saveFile.put("gameData", gameData);
        UtilityTool.createFile(FileManager.GAME_DATA_PATH, saveFile.toJSONString());
    }

}
