# jpaint
 final project for SE450

### **GitHub link:** https://github.com/ashorb/jpaint

### **Check-in 2:**
-Required features working. Can draw rectangle, ellipses, and triangles of all three shading types.
 Can select and move single/multiple shapes and can undo/redo move.

### **Check-in 1:**
-Required features working. Can draw rectangles from all directions and can undo/redo.

### **Design patterns used:**

**Command pattern used for Draw/Select/Move shapes, Copy/Paste/Delete shapes, and Undo/Redo features:** 
ICommand, CreateShape, SelectShape, MoveShape, CopyCommand, PasteCommand, DeleteCommand,
UndoCommand, RedoCommand, JPaintController, CommandHistory, IUndoable

**Static Factory pattern used for creating shapes:**
CreateShape, ShapeFactory, IShape, Shape, Rectangle, Ellipse, Triangle, Point

**Strategy pattern used for painting shapes to canvas:**
PaintCanvas, IPaintStrategy, ShapePainter, PaintRectangle, PaintEllipse, PaintTriangle

**Observer pattern used for decoupling PaintCanvas and repaint() from ShapeList, SelectShape, and MoveShape:**
PaintCanvas, ShapeList, SelectShape, MoveShape, Main, ObserverSubject, IShapeListObserver, IShapeListSubject
