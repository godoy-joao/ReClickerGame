package game.component.button.shopTab;

import entity.BuyableEntity;
import game.component.Component;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BuyTab extends Component {

    private BufferedImage sprite;
    private String Title;
    private String description;
    private Rectangle buyButtonArea;

    public BuyTab(BuyableEntity entity) {
        setRect(null);
    }

    @Override
    public void onClick() {

    }

}
