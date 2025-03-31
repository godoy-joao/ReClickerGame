package game.component.button.shopTab;

import game.component.Component;
import main.Display;

import java.awt.*;

public class ToHeroTab extends Component {


    @Override
    public void onClick() {
        ShopTab.switchToHeroTab();
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(Display.WIDTH - 400, 0, 100, 200);
    }
}
