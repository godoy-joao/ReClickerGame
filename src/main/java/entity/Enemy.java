/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import controls.Controller;
import data.FileManager;
import data.GameData;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author João Guilherme
 */
public class Enemy extends Rectangle {

    private double maxHp;
    private double hp;
    private String name;
    private int killCount = 0;
    private Random random = new Random();
    private BufferedImage sprite;
    private boolean boss;

    public Enemy(String name) {
        this.maxHp = 10 + 5 * random.nextInt(GameData.getLevel()) + random.nextInt(GameData.getLevel() + 1);
        this.hp = this.maxHp;
        this.name = name;
        this.width = 450;
        this.height = 450;
        this.killCount = 0;
        this.boss = false;
        getEnemySprite(this.name);
        setLocation((Display.WIDTH / 2) - this.width / 2, (Display.HEIGHT / 2) - this.height / 2);
    }

    public Enemy(String name, boolean boss) {
        this.maxHp = 10 + 20 * random.nextInt(GameData.getLevel()) + random.nextInt(GameData.getLevel() + 5);
    }

    public void takeDamage() {
        hp--;
        if (hp <= 0) {
            computeKill(Controller.currentEnemy.getName());
            Controller.currentEnemy = new Enemy(getEnemyNames().get(random.nextInt(getEnemyNames().size())));
            GameData.nextLevel();
        }
    }

    public int getKillCount() {
        return this.killCount;
    }

    public BufferedImage getSprite() {
        return this.sprite;
    }

    private void getEnemySprite(String name) {
        try {
            this.sprite = ImageIO.read(getClass().getResourceAsStream("/data/enemy/images/" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void createFile() {
        JSONObject enemies = new JSONObject();
        for (String str : getEnemyNames()) {
            JSONObject enemy = new JSONObject();
            enemy.put("name", str);
            enemy.put("killCount", 0);
            enemies.put(str, enemy);
        }
        try {
            FileWriter file = new FileWriter(FileManager.ENEMY_DATA_PATH);
            file.write(enemies.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getEnemyNames() {
        List<String> names = new ArrayList();
        names.add("fantasma");
        names.add("morto-vivo");
        names.add("geléia");
        names.add("cranio");
        names.add("minhoca");
        return names;
    }

    public static long getTotalKills() {
        long kills = 0;
        JSONParser parser = new JSONParser();
        try {
            FileReader read = new FileReader(FileManager.ENEMY_DATA_PATH);
            JSONObject json = (JSONObject) parser.parse(read);
            for (String name : getEnemyNames()) {
                JSONObject enemy = (JSONObject) json.get(name);
                kills += (long) enemy.get("killCount");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return kills;
    }

    public static long getKills(String name) {
        long kills = 0;
        try {
            FileReader read = new FileReader(FileManager.ENEMY_DATA_PATH);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(read);
            kills = (long) ((JSONObject) json.get(name)).get("killCount");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return kills;
    }

    public static void computeKill(String enemyName) {

        JSONParser jParser = new JSONParser();
        try {
            FileReader read = new FileReader(FileManager.ENEMY_DATA_PATH);
            JSONObject json = (JSONObject) jParser.parse(read);
            JSONObject enemy = (JSONObject) json.get(enemyName);
            long killCount = ((long) enemy.get("killCount")) + 1;
            enemy.replace("killCount", killCount);
            json.replace(enemyName, enemy);
            FileWriter writer = new FileWriter(FileManager.ENEMY_DATA_PATH);
            writer.write(json.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
