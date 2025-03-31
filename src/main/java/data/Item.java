/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.UtilityTool;
import org.json.simple.JSONObject;

/**
 *
 * @author João Guilherme
 */
public class Item {

    private String id;
    private String name;
    private String description;
    private double damagePoints;
    private double damageMultiplier;
    private double price;
    private BufferedImage icon;
    private boolean unlocked;
    private boolean actionable;
    private boolean active;
    private boolean drop;
    private boolean creatable;
    private int level;
    private int maxLevel;

    public Item(String id, String name, String description, double damagePoints, double damageMultiplier, double price, boolean actionable, boolean drop, boolean creatable, int maxLevel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.damagePoints = damagePoints;
        this.damageMultiplier = damageMultiplier;
        this.price = price;
        this.unlocked = false;
        this.actionable = actionable;
        this.active = false;
        this.drop = drop;
        this.creatable = creatable;
        this.level = 1;
        this.maxLevel = maxLevel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String description() {
        return description;
    }

    public void unlock() {
        this.unlocked = true;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(double damagePoints) {
        this.damagePoints = damagePoints;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    public void setIcon(BufferedImage icon) {
        this.icon = icon;
    }

    public boolean isActionable() {
        return actionable;
    }

    public void setActionable(boolean actionable) {
        this.actionable = actionable;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDrop() {
        return drop;
    }

    public void setDrop(boolean drop) {
        this.drop = drop;
    }

    public boolean isCreatable() {
        return creatable;
    }

    public void setCreatable(boolean creatable) {
        this.creatable = creatable;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
    
    public static List<Item> getAllItems() {
        List<Item> items = new ArrayList<Item>();
        
        return items;
    }
    
    public static List<Item> getDrop() {
        List<Item> items = getAllItems();
        List<Item> drops = new ArrayList<Item>();
        return drops;
    }

    @SuppressWarnings({ "unchecked" })
	public static void createFile() {
        JSONObject json = new JSONObject();
        List<Item> items = new ArrayList<Item>();
        Item item = new Item("zombiePiece1", "Carne podre", "Isso fede.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("zombiePiece2", "Olho parasitado", "Achei que fosse a córnea.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("zombiePiece3", "Perna de zumbi", "Como ele perdeu isso?", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("ghostPiece1", "Ovo de fantasma", "???", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("ghostPiece2", "Lençol espectral", "Ele esfria ao invés de esquentar.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("ghostPiece3", "Ectoplasma", "Meus dedos atravessam.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("slimePiece1", "Meleca", "Não sai dos dedos, eca.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("slimePiece2", "Abacaxi melado", "Parece já ter sido comido.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("slimePiece3", "Núcleo melequento", "É duro e gosmento.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("skullPiece1", "Fragmento de osso", "Não dê para os cachorros.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("skullPiece2", "Globo ocular", "Com os olhos saltando para fora.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("skullPiece3", "Dentes", "Cadê a dentadura da vovó?", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("wormPiece1", "Punhado de terra", "Por que eu guardaria isso?", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("wormPiece2", "Ovos de minhoca", "Dá para fazer uma omelete?", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("wormPiece3", "Pele seca", "Crocante.", 10.0, 1.0, 0.0, false, true, false, 1);
        items.add(item);
        item = new Item("allMobSword", "X-tudo", "Eu não vou comer isso!", 0.0, 10.0, 0.0, false, false, true, 25);
        items.add(item);
        item = new Item("zombieWeapon", "Espeto de cérebro", "Bata neles com razão.", 50.0, 3.0, 0.0, false, false, true, 10);
        items.add(item);
        item = new Item("ghostWeapon", "Espectro de uma paixão", "Até que a morte os separe.", 50.0, 3.0, 0.0, false, false, true, 10);
        items.add(item);
        item = new Item("slimeWeapon", "Coroa melada", "O rei da... meleca?", 50.0, 3.0, 0.0, false, false, true, 10);
        items.add(item);
        item = new Item("skullWeapon", "Dentadura", "Tá aqui, vó!", 50.0, 3.0, 0.0, false, false, true, 10);
        items.add(item);
        item = new Item("wormWeapon", "Minhocoçu", "É grande e comprido.", 50.0, 3.0, 0.0, false, false, true, 10);
        items.add(item);
        item = new Item("plasticSword", "Espada de plástico", "Parece que vai quebrar a qualquer momento.", 20.0, 1.0, 100.0, false, false, false, 100);
        items.add(item);
        item = new Item("cactusSword", "Espada de cacto", "Ainda tem água dentro.", 50, 1.0, 350.0, false, false, false, 100);
        items.add(item);
        item = new Item("rustySword", "Espada de metal enferrujada", "Isso aqui mata de tétano!", 0, 2.5, 3500.0, false, false, false, 10);
        items.add(item);
        item = new Item("fleshSword", "Espada de carne", "Como isso pode cortar?", 333, 0, 180000.0, false, false, false, 100);
        items.add(item);
        item = new Item("fleshGun", "Pistola de carne", "Faz barulhos estranhos!", 0, 3.33, 1e6/3, false, false, false, 10);
        items.add(item);
        item = new Item("crystalGun", "Pistola de cristal", "Acho que vai quebrar no primeiro uso!", 0.0, 5.0, 1e6, false, false, false, 10);
        items.add(item);
        item = new Item("strangeSword", "Espada esquisita", "Eu aaacho que é uma espada.", 1000.0, 2.5, 1e7, false, false, false, 10);
        items.add(item);
        item = new Item("spaceGun", "Arma de pulso 9000", "Aqui diz: Não usar em locais fechados.", 10.0, 50.0, 1e9, false, false, false, 1000);
        items.add(item);
        for (Item i : items) {
            JSONObject it = new JSONObject();
            it.put("name", i.getName());
            it.put("description", i.getDescription());
            it.put("damagePoints", i.getDamagePoints());
            it.put("damageMultiplier", i.getDamageMultiplier());
            it.put("price", i.getPrice());
            it.put("activable", i.isActionable());
            it.put("drop", i.isDrop());
            it.put("craftable", i.isCreatable());
            it.put("level", i.getLevel());
            it.put("maxLevel", i.getMaxLevel());
            json.put(i.getId(), it);
        }
        try {
            FileWriter writer = new FileWriter(FileManager.ITEM_DATA_PATH);
            writer.write(json.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void unlockWeapon(String name) {
    JSONObject json = UtilityTool.fileToJson(FileManager.ITEM_DATA_PATH);
    }

}
