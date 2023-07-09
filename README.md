# jpaint
 final project for SE450

### **GitHub link:** https://github.com/ashorb/jpaint

### **Check-in 1:**

-Required features working. Can draw rectangles from all directions and can undo/redo.


### **Design patterns used:**

**Command pattern used for undo/redo features:** 
ICommand, UndoCommand, RedoCommand, JPaintController, CommandHistory, IUndoable

**Static Factory pattern used for creating shapes:**
CreateShape, ShapeFactory, IShape, Shape, Rectangle, Ellipse, Triangle, Point

**Strategy pattern used for painting shapes to canvas:**
PaintCanvas, IPaintStrategy, PaintRectangle, PaintEllipse, PaintTriangle
