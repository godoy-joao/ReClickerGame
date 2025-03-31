/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import game.component.button.shopTab.ShopTab;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * @author João Guilherme
 */
public class ComponentManager {

    public static HashMap<String, Component> gameComponents = new HashMap<>();

    public static void checkIfComponentWasClicked(Point mousePos) {
        for (Component c : gameComponents.values()) {
            if (c.contains(mousePos)) c.onClick();
        }
    }

    public static void addComponents() {
        UtilityTool uTool = new UtilityTool();
        BufferedImage bi = uTool.getImage("/layout/heroShopOpen.png");
        ShopTab st = new ShopTab(new ShopTab().getRectangle(), bi);
        st.addToComponentManager("ShopTab");
        System.out.println(st.getBounds());
    }

    public static void drawComponents(Graphics2D g) {
        for (Component c : gameComponents.values()) {
            if (c.getSprite() != null) {
                g.drawImage(c.getSprite(), c.x, c.y, c.width, c.height, null);
            } else {
                g.draw(c.getRectangle());
            }
        }
    }
}
