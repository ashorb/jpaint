package model.interfaces;

import java.awt.*;

public interface IPaintStrategy {
//    void paintShape(IShape shape, Graphics2D graphics2d);

    void drawFilledIn(IShape shape, Graphics2D graphics2d);
    void drawOutline(IShape shape, Graphics2D graphics2d);
    void drawFilledInOutline(IShape shape, Graphics2D graphics2d);
//    void moveShape();
//    void pasteShape();
//    void deleteShape();

}
