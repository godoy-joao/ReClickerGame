/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Enemy;
import game.Notification;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.UtilityTool;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author João Guilherme
 */
public class Achievement {

    private String id;
    private String name;
    private String description;
    private int reward;
    private boolean unlocked;
    private BufferedImage icon;

    public static List<Achievement> getAchievements() {
        List<Achievement> achievements = new ArrayList();
        Achievement acv = new Achievement("thousandClicks", "Mil Cliques", "Clique 1000 vezes.", 10);
        achievements.add(acv);
        acv = new Achievement("killMonsters1", "Primeiras vítimas", "Mate 10 monstros", 2);
        achievements.add(acv);
        acv = new Achievement("hundredClicks", "Cem Cliques", "Clique 100 vezes.", 5);
        achievements.add(acv);
        acv = new Achievement("killSameMonster1", "Problema pessoal", "Mate 10 vezes o mesmo tipo de monstro.", 3);
        achievements.add(acv);
        acv = new Achievement("killSameMonster2", "Ódio destinado", "Mate 100 vezes o mesmo tipo de monstro.", 10);
        achievements.add(acv);
        acv = new Achievement("killMonsters2", "Expurgo", "Mate 100 monstros.", 5);
        achievements.add(acv);
        acv = new Achievement("killMonsters3", "Massacre", "Mate 1000 monstros.", 10);
        achievements.add(acv);
        acv = new Achievement("killMonsters4", "Genocídio", "Mate 100000 monstros.", 25);
        achievements.add(acv);
        acv = new Achievement("levelUp1", "Treino de força", "Chegue ao nível 10 de jogador.", 5);
        achievements.add(acv);
        acv = new Achievement("levelUp2", "Em busca da evolução", "Chegue ao nível 100 de jogador.", 10);
        achievements.add(acv);
        acv = new Achievement("levelUp3", "Mais poder!", "Chegue ao nível 1000 de jogador.", 15);
        achievements.add(acv);
        acv = new Achievement("reachLevel10", "O começo", "Alcance o nível 10", 5);
        achievements.add(acv);
        acv = new Achievement("reachLevel25", "Os primeiros passos", "Alcance o nível 25", 5);
        achievements.add(acv);
        acv = new Achievement("reachLevel50", "Crescimento", "Alcance o nível 50", 10);
        achievements.add(acv);
        acv = new Achievement("reachLevel75", "Saindo das fraldas", "Alcance o nível 75", 5);
        achievements.add(acv);
        acv = new Achievement("reachLevel100", "Primeiro dia de aula", "Alcance o nível 100", 10);
        achievements.add(acv);
        acv = new Achievement("reachLevel150", "Vivendo e aprendendo", "Alcance o nível 150", 5);
        achievements.add(acv);
        acv = new Achievement("reachLevel200", "Primeiro emprego", "Alcance o nível 200", 10);
        achievements.add(acv);
        acv = new Achievement("reachLevel250", "Dono do próprio nariz", "Alcance o nível 250", 5);
        achievements.add(acv);
        acv = new Achievement("reachLevel300", "Ainda há trabalho a fazer", "Alcance o nível 300", 10);
        achievements.add(acv);
        acv = new Achievement("reachLevel400", "Ambição", "Alcance o nível 400", 10);
        achievements.add(acv);
        acv = new Achievement("reachLevel500", "Busca incansável", "Alcance o nível 500", 15);
        achievements.add(acv);
        acv = new Achievement("reachLevel750", "Determinação inabalável", "Alcance o nível 750", 20);
        achievements.add(acv);
        acv = new Achievement("reachLevel1000", "Sobre-humano", "Alcance o nível 1000", 25);
        achievements.add(acv);
        acv = new Achievement("reachLevel1250", "Semi-divindade", "Alcance o nível 1250", 10);
        achievements.add(acv);
        acv = new Achievement("reachLevel1500", "Há algo além?", "Alcance o nível 1500", 10);
        achievements.add(acv);
        acv = new Achievement("reachLevel2000", "Onipotência", "Alcance o nível 2000", 100);
        achievements.add(acv);
        return achievements;
    }

    public static void createFile() {
        JSONObject json = new JSONObject();
        List<Achievement> achievements = getAchievements();
        for (Achievement achiv : achievements) {
            JSONObject achievement = new JSONObject();
            achievement.put("id", achiv.getId());
            achievement.put("name", achiv.getName());
            achievement.put("description", achiv.getDescription());
            achievement.put("reward", Integer.toString(achiv.getReward()));
            achievement.put("unlocked", false);
            json.put(achiv.getId(), achievement);
        }
        try {
            FileWriter writer = new FileWriter(FileManager.ACHIEVEMENT_DATA_PATH);
            JSONObject achievementFile = new JSONObject();
            achievementFile.put("achievements", json);
            writer.write(achievementFile.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tickAchievement() {
        try {
            FileReader read = new FileReader(FileManager.ACHIEVEMENT_DATA_PATH);
            JSONParser parser = new JSONParser();
            JSONObject achievements = (JSONObject) ((JSONObject) parser.parse(read)).get("achievements");
            for (Achievement acv : getAchievements()) {
                if (!(boolean) ((JSONObject) achievements.get(acv.getId())).get("unlocked")) {
                    switch (acv.getId()) {
                        case "levelUp1":
                            if (Player.getLevel() >= 10) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "levelUp2":
                            if (Player.getLevel() >= 100) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "levelUp3":
                            if (Player.getLevel() >= 1000) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "killMonsters1":
                            if (Enemy.getTotalKills() >= 10) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "killMonsters2":
                            if (Enemy.getTotalKills() >= 100) {
                                System.out.println("10kills " + achievements.toJSONString());
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "killMonsters3":
                            if (Enemy.getTotalKills() >= 1000) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "killMonsters4":
                            if (Enemy.getTotalKills() >= 100000) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "killSameMonster1":
                            boolean isTrue = false;
                            for (String str : Enemy.getEnemyNames()) {
                                if (Enemy.getKills(str) >= 10) {
                                    isTrue = true;
                                }
                            }
                            if (isTrue) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "killSameMonster2":
                            isTrue = false;
                            for (String str : Enemy.getEnemyNames()) {
                                if (Enemy.getKills(str) >= 100) {
                                    isTrue = true;
                                }
                            }
                            if (isTrue) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel10":
                            if (GameData.getLevel() >= 10) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel25":
                            if (GameData.getLevel() >= 25) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel50":
                            if (GameData.getLevel() >= 50) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel75":
                            if (GameData.getLevel() >= 75) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel100":
                            if (GameData.getLevel() >= 100) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel150":
                            if (GameData.getLevel() >= 150) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel200":
                            if (GameData.getLevel() >= 200) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel250":
                            if (GameData.getLevel() >= 250) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel300":
                            if (GameData.getLevel() >= 300) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel400":
                            if (GameData.getLevel() >= 400) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel500":
                            if (GameData.getLevel() >= 500) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel750":
                            if (GameData.getLevel() >= 750) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel1000":
                            if (GameData.getLevel() >= 1000) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel1250":
                            if (GameData.getLevel() >= 1250) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel1500":
                            if (GameData.getLevel() >= 1500) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "reachLevel2000":
                            if (GameData.getLevel() >= 2000) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "hundredClicks":
                            if (Player.getClickCount() >= 100) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                        case "thousandClicks":
                            if (Player.getClickCount() >= 1000) {
                                Notification.addNotification("Conquista desbloqueada!", ((JSONObject) achievements.get(acv.getId())).get("name").toString());
                                unlockAchievement(acv.getId());
                            }

                            break;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    public void setIcon(BufferedImage icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public Achievement(String id, String name, String description, int reward, boolean unlocked) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.reward = reward;
        this.unlocked = unlocked;
        UtilityTool uTool = new UtilityTool();
        //this.icon = uTool.getImage("icon/achievements/" + this.name + ".png");
    }

    public static List<Achievement> getAllAchievements() {
        List<Achievement> achievements = new ArrayList();

        JSONObject json = UtilityTool.fileToJson(FileManager.ACHIEVEMENT_DATA_PATH);
        JSONObject allAchievementsJson = (JSONObject) json.get("achievements");
        for (Achievement achievement : getAchievements()) {
            JSONObject achievementsJson = (JSONObject) allAchievementsJson.get(achievement.getId());
            Achievement acv = new Achievement(achievementsJson.get("id").toString(), achievementsJson.get("name").toString(),
                    achievementsJson.get("description").toString(), Integer.parseInt(achievementsJson.get("reward").toString()), (boolean) achievementsJson.get("unlocked"));
            achievements.add(acv);
        }
        return achievements;
    }

    public static List<Achievement> getUnlockedAchievements() {
        List<Achievement> achievements = new ArrayList();

        JSONObject json = UtilityTool.fileToJson(FileManager.ACHIEVEMENT_DATA_PATH);

        return achievements;
    }

    public static void unlockAchievement(String id) {

        JSONObject json = UtilityTool.fileToJson(FileManager.ACHIEVEMENT_DATA_PATH);
        JSONObject achievement = (JSONObject) json.get("achievements");
        JSONObject unlockKey = (JSONObject) achievement.get(id);
        unlockKey.replace("unlocked", true);
        achievement.replace(id, unlockKey);
        json.replace("achievements", achievement);

        try {
            FileWriter writer = new FileWriter(FileManager.ACHIEVEMENT_DATA_PATH);
            writer.write(json.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Achievement(String id, String name, String description, int reward) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.reward = reward;
        this.unlocked = false;
    }

}
