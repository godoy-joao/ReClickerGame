/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import controls.InputHandler;
import game.component.button.DefaultMinimizer;
import main.UtilityTool;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author João Guilherme
 */
public abstract class Component extends Rectangle {

    private boolean enabled = true;
    private boolean visible = true;
    private BufferedImage sprite = null;
    private boolean hasChild;
    private HashMap<String, Component> children = new HashMap<>();
    private Component parent;
    private int drawLayer = 0;
   public UtilityTool tool = new UtilityTool();
   private DefaultMinimizer minimizer;

    public Component() {

    }

    public DefaultMinimizer getMinimizer() {
        return minimizer;
    }

    public void setMinimizer(DefaultMinimizer defaultMinimizer) {
        this.minimizer = defaultMinimizer;
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

    public void setParent(Component c) {
        this.parent = c;
    }

    public Component getParent() {
        return this.parent;
    }

    public boolean hasChild() {
        hasChild = !children.isEmpty();
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

    public HashMap<String, Component> getChildren() {
        return children;
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

    public void childClicked() {
        int highestLayer = 0;
        for (Component c : children.values()) {
            if (c.getDrawLayer() > highestLayer && c.contains(InputHandler.mousePosition))
                highestLayer = c.getDrawLayer();
        }

        for (Component c : children.values()) {
            if (c.getDrawLayer() == highestLayer && c.contains(InputHandler.mousePosition)) {
                c.onClick();
            }
        }
    }
}
