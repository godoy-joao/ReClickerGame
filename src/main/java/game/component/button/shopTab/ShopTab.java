package game.component.button.shopTab;

import game.component.Component;
import main.Display;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ShopTab extends Component {

    private static int status = 0;
    private static final int HERO_SHOP_TAB = 0;
    private static final int ITEM_SHOP_TAB = 1;


    public ShopTab(Rectangle rectangle, BufferedImage img) {
        super(rectangle, img);
        ToHeroTab heroTab = new ToHeroTab();
    }

    public ShopTab() {

    }

    public static void switchToHeroTab() {
        status = HERO_SHOP_TAB;

    }

    public static void switchToItemTab() {
        status = ITEM_SHOP_TAB;
    }


    @Override
    public void onClick() {
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(Display.WIDTH - 400, 0, 400, Display.HEIGHT);
    }
}
