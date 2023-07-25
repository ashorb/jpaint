package model.interfaces;

import java.awt.*;

public interface IPaintStrategy {
    void drawFilledIn(IShape shape, Graphics2D graphics2d);
    void drawOutline(IShape shape, Graphics2D graphics2d);
    void drawFilledInOutline(IShape shape, Graphics2D graphics2d);
    void drawSelectionOutline(IShape shape, Graphics2D grapihics2d);
}
