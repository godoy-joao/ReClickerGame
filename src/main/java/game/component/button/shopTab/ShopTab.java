package game.component.button.shopTab;

import game.component.Component;
import game.component.ComponentManager;
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
        setSprite(tool.getImage("/layout/heroShopOpen.png"));
        setDrawLayer(4);
        addChildren("to_hero_tab", new ToHeroTab());
        addChildren("to_item_tab", new ToItemTab());
        hasChild();
    }

    public static void switchTo(int tab) {
        status = tab;
        switchSprite(status);
    }

    private static void switchSprite(int value) {
        if (value == HERO_SHOP_TAB) {
            ComponentManager.gameComponents.get("shop_tab").setSprite(new UtilityTool().getImage("/layout/heroShopOpen.png"));
        }
        if (value == ITEM_SHOP_TAB) {
            ComponentManager.gameComponents.get("shop_tab").setSprite(new UtilityTool().getImage("/layout/itemShopOpen.png"));
        }
    }

    @Override
    public void onClick() {
    }

    public static int getStatus() {
        return status;
    }
}
