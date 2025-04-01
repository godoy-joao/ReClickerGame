/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author João Guilherme
 */
public class UtilityTool {

    public BufferedImage getImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public BufferedImage scaleImage(BufferedImage original, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();

        return scaledImage;
    }

    public static JSONObject fileToJson(String path) {
        JSONObject json = new JSONObject();
        try {
            FileReader reader = new FileReader(path);
            JSONParser parser = new JSONParser();
            json = (JSONObject) parser.parse(reader);
        } catch (IOException e) {
            System.out.println("File not found! --- Class UtilityTool - Line 51");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static void createFile(String name, String data) {
        try {
            FileWriter file = new FileWriter(name);
            file.write(data);
            file.flush();
        } catch (IOException e) {
            System.out.println("Utility Tool : createFile() error");
            e.printStackTrace();
        }
    }
}
