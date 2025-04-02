package entity;

import game.component.Component;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    private double maxHp;
    private double actualHp;
    private String name;
    private BufferedImage sprite;


    public void takeDamage(long damage) {
        this.actualHp -= damage;
    }

    public abstract void onDeath();

    public abstract void onClick();

}
