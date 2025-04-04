/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import controls.Controller;
import entity.Enemy;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import game.component.ComponentManager;
import org.json.simple.JSONObject;

/**
 * @author João Guilherme
 */
public class GameSetup {

    public synchronized static boolean setup() {
    boolean setup = false;
        try {
            System.out.println("Run");
            ComponentManager.addComponents();
            ComponentManager.sort();
            FileManager.initialize();
            GameData.loadData();
            setup = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setup;
    }


    public static void firstSetup() {

        GameData.setLevel(1);
        Enemy.createFile();
        Achievement.createFile();
        Item.createFile();
        Random random = new Random();
        Controller.currentEnemy = new Enemy(Enemy.getEnemyNames().get(random.nextInt(Enemy.getEnemyNames().size())));
        JSONObject gameData = new JSONObject();
        JSONObject json = new JSONObject();
        json.put("level", GameData.getLevel());
        json.put("lastTime", LocalDateTime.now().format(GameData.format));
        json.put("totalGameSeconds", Math.max(GameData.getTotalElapsedSeconds(), 0));
        json.put("currentEnemy", Controller.currentEnemy.getName());
        gameData.put("gameData", json);
        System.out.println(gameData.toJSONString());
        try  {

            FileWriter fileWriter = new FileWriter(FileManager.GAME_DATA_PATH);
            fileWriter.write(gameData.toJSONString());
            fileWriter.flush();
            System.out.println(FileManager.GAME_DATA_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
