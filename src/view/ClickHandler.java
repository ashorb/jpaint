package view;

import controller.CreateShape;
import model.Point;
import model.ShapeList;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickHandler extends MouseAdapter {

    PaintCanvas paintCanvas;
    ShapeList shapeList;
//    Graphics2D graphics2D;

    Point startPoint = new Point();
    Point endPoint = new Point();

    public ClickHandler(PaintCanvas paintCanvas, ShapeList shapeList) {
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
//        this.graphics2D = (Graphics2D)paintCanvas.getGraphics();
    }

    @Override
    public void mousePressed(MouseEvent e) { //location when mouse pressed
        startPoint.x = e.getX();
        startPoint.y = e.getY();

        System.out.println("Pressed:  x = " + startPoint.x +  " y = " +  startPoint.y);
    }

    @Override
    public void mouseReleased(MouseEvent e) { //location when mouse released
//        Graphics2D graphics2D = (Graphics2D)paintCanvas.getGraphics();
//        Graphics graphics2D = paintCanvas.getGraphics();

        endPoint.x = e.getX();
        endPoint.y = e.getY();
        int width = 0;
        int height = 0;
        int x = 0;
        int y = 0;

        if (startPoint.x < endPoint.x && startPoint.y < endPoint.y ){
            //top-left to bottom-right
            width = endPoint.x - startPoint.x;
            height = endPoint.y - startPoint.y;
            x = startPoint.x;
            y = startPoint.y;
//            graphics2D.drawRect(startPoint.x , startPoint.y, width, height);
        }
        else if (startPoint.x > endPoint.x && startPoint.y > endPoint.y ){
            //bottom-right to top-left
            width = startPoint.x - endPoint.x;
            height = startPoint.y - endPoint.y;
            x = endPoint.x;
            y = endPoint.y;
//            graphics2D.drawRect(endPoint.x , endPoint.y, width, height);
        }
        else if (startPoint.x > endPoint.x && startPoint.y < endPoint.y ){
            //top-right to bottom-left
            width = startPoint.x - endPoint.x;
            height = endPoint.y - startPoint.y;
            x = endPoint.x;
            y = startPoint.y;
//            graphics2D.drawRect(endPoint.x , startPoint.y, width, height);
        }
        else if (startPoint.x < endPoint.x && startPoint.y > endPoint.y ){
            //bottom-left to top-right
            width = endPoint.x -  startPoint.x;
            height =  startPoint.y - endPoint.y;
            x = startPoint.x;
            y = endPoint.y;
//            graphics2D.drawRect(startPoint.x, endPoint.y, width, height);
        }

        if(width != 0 && height != 0) {
            CreateShape createNew = new CreateShape();

            createNew.createShape(shapeList, x, y, width, height);

//            graphics2D.setColor(Color.GREEN);
//            graphics2D.fillRect(x, y, width, height);

//            graphics2D.setStroke(new BasicStroke(5));
//            graphics2D.setColor(Color.BLUE);
//            graphics2D.drawRect(x, y, width, height);
//
//            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//            graphics2D.setStroke(stroke);
//            graphics2D.setColor(Color.BLACK);
//            graphics2D.drawRect(x - 5, y - 5, width + 10,  height + 10);
        }

        System.out.println("Released: x = " + endPoint.x + " y = " +  endPoint.y);

//        paintCanvas.getGraphics().setColor(Color.GREEN);
//        paintCanvas.getGraphics().fillRect(startPoint.x , startPoint.y, width, height);

//        graphics2D.setColor(Color.GREEN);
//        graphics2D.fillRect(startPoint.x , startPoint.y, width, height);

//        graphics2D.setColor(Color.GREEN);
//        graphics2D.fillRect(startPoint.x , startPoint.y, width, height);
//
//        graphics2D.setStroke(new BasicStroke(10));
//        graphics2D.setColor(Color.BLUE);
//        graphics2D.drawRect(startPoint.x , startPoint.y, width, height);


    }



}
