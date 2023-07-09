package model.drawing;

import model.ShapeShadingType;
import model.interfaces.IPaintStrategy;
import model.interfaces.IShape;
import java.awt.*;

public class PaintEllipse implements IPaintStrategy {

    @Override
    public void paintShape(IShape shape, Graphics2D graphics2d){
        if(shape.getShapeShadingType().equals(ShapeShadingType.FILLED_IN)){
            graphics2d.setColor(shape.getPrimaryColor().getColor());
            graphics2d.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        }
        else if(shape.getShapeShadingType().equals(ShapeShadingType.OUTLINE)){
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.getSecondaryColor().getColor());
            graphics2d.drawOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        }
        else if(shape.getShapeShadingType().equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
            graphics2d.setColor(shape.getPrimaryColor().getColor());
            graphics2d.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.getSecondaryColor().getColor());
            graphics2d.drawOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        }

    }

//    @Override
//    public void drawFilledIn(IShape shape, Graphics2D graphics2d) {
//        graphics2d.setColor(Color.BLACK);
//    }
//
//    @Override
//    public void drawOutline(IShape shape, Graphics2D graphics2d) {
//
//    }
//
//    @Override
//    public void drawFilledInOutline(IShape shape, Graphics2D graphics2d) {
//
//    }
}
