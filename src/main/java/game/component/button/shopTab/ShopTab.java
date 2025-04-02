package game.component.button.shopTab;

import game.component.Component;
import main.Display;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ShopTab extends Component {

    private static int status = 0;
    public static final int HERO_SHOP_TAB = 0;
    public static final int ITEM_SHOP_TAB = 1;

    public ShopTab() {
        setRect(Display.WIDTH - 400, 0, 400, Display.HEIGHT);
setSprite(tool.getImage("layout/heroShopOpen.png"));
    }

    public static void switchTab(int tab) {
        status = tab;
    }

    @Override
    public void onClick() {
    }

}
