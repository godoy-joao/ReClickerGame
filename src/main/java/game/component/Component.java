/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import main.UtilityTool;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * @author João Guilherme
 */
public abstract class Component extends Rectangle {

    private boolean enabled;
    private boolean visible;
    private BufferedImage sprite;
    private boolean hasChild;
    private HashMap<String, Component> children;
    private int drawLayer;
   public UtilityTool tool = new UtilityTool();

    public Component() {

    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage bi) {
        this.sprite = bi;
    }

    public void addToComponentManager(String name) {
        ComponentManager.gameComponents.put(name, this);
    }

    public boolean hasChild() {
        return hasChild;
    }

    public int getDrawLayer() {
        return drawLayer;
    }

    public void setDrawLayer(int layer){
        drawLayer = layer;
    }

    public Component findChild(String name) {
        return children.get(name);
    }

    public void setVisible(boolean value) {
        visible = value;
    }

    public void toggleVisibility() {
        visible = !visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void addChildren(String name, Component child) {
        children.put(name, child);
    }

    public abstract void onClick();

}
