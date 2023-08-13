package model.drawing;

import model.ShapeShadingType;
import model.interfaces.IPaintStrategy;
import model.interfaces.IShape;
import java.awt.*;

public class ShapePainter {

    private final IPaintStrategy paintStrategy;
    public ShapePainter (IPaintStrategy paintStrategy) {
        this.paintStrategy = paintStrategy;
    }
    public void paintShape(IShape shape, Graphics2D graphics2d) {
        if(shape.getShapeShadingType().equals(ShapeShadingType.FILLED_IN)){
            paintStrategy.drawFilledIn(shape, graphics2d);
        }
        else if(shape.getShapeShadingType().equals(ShapeShadingType.OUTLINE)){
            paintStrategy.drawOutline(shape, graphics2d);
        }
        else if(shape.getShapeShadingType().equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
            paintStrategy.drawFilledInOutline(shape, graphics2d);
        }
    }
}
