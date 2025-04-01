package game.component.button.shopTab;

import game.component.Component;

import java.awt.*;

public class ToItemTab extends Component {
    @Override
    public void onClick() {
        ShopTab.switchToItemTab();
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(Display.WIDTH - 300, 0, 100, 200);
    }
}
