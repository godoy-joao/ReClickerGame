package game.component.button.shopTab;

import game.component.Component;
import main.Display;

import java.awt.*;

public class ToHeroTab extends Component {

    public ToHeroTab() {
        setRect(Display.WIDTH - 400, 0, 100, 200);
    }

    @Override
    public void onClick() {
        ShopTab.switchTo(ShopTab.HERO_SHOP_TAB);
        System.out.println(ShopTab.getStatus());
    }

}
