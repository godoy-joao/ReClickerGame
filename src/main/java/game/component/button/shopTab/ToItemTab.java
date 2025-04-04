package game.component.button.shopTab;

import game.component.Component;
import main.Display;

import java.awt.*;

public class ToItemTab extends Component {

    public ToItemTab() {
        setRect(Display.WIDTH - 300, 0, 100, 200);
    }

    @Override
    public void onClick() {
        ShopTab.switchTo(ShopTab.ITEM_SHOP_TAB);
    }

}
