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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author João Guilherme
 */
public class ComponentManager {

    public static HashMap<String, Component> gameComponents = new HashMap<>();
    private static List<Component> sortedComponents;

    public static void checkIfComponentWasClicked(Point mousePos) {
        for (Component c : gameComponents.values()) {
            if (c.hasChild()) {
                c.childClicked();
            } else if (c.contains(mousePos)) c.onClick();
        }
    }

    /*public static List<Component> getComponentByDrawOrder() {
        return sortedComponents.reversed();
    }
    */


    public static void addComponent(Component component, String name) {
        component.addToComponentManager(name);
    }

    public static void drawComponents(Graphics2D g) {
        for (Component c : sortedComponents) {
            if (c.getSprite() != null) {
                g.drawImage(c.getSprite(), (int) c.getX(), (int) c.getY(), (int) c.getWidth(), (int) c.getHeight(), null);
            } else {
                g.draw(c);
            }
           if (c.hasChild()) {
               for ( Component child : c.getChildren().values()) {
                   if (child.getSprite() != null) {
                       g.drawImage(child.getSprite(), (int) child.getX(), (int) child.getY(), (int) child.getWidth(), (int) child.getHeight(), null);
                   } else {
                      // g.draw(child);
                   }
               }
           }
        }
    }

    public static void addComponents() {
        addComponent(new ShopTab(), "shop_tab");

    }

    public static void sort() {
        sortedComponents = new ArrayList<>();
        gameComponents.forEach((s, component) -> {
            sortedComponents.add(component);
        });
        sortedComponents.sort(Comparator.comparingInt(Component::getDrawLayer));
    }


}
