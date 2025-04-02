package game.component.button;

import game.component.Component;

import java.awt.*;

public class DefaultMinimizer extends Component {

    private final Component component;
    private boolean minimized;

    public DefaultMinimizer(Component component) {
    this.component = component;
    this.minimized = false;
    setRect(component.getX() + 5, component.getY() + 5, 30, 30);
    }

    @Override
    public void onClick() {
        component.disable();
        component.setVisible(false);
    }

}
