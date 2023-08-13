# jpaint
 final project for SE450

### **GitHub link:** https://github.com/ashorb/jpaint

### **Check-in 4:**
-Required features working.
<br/>-Can group/ungroup shapes. Grouped shapes can be selected, moved, copied, pasted, and deleted.
<br/>-Can undo/redo grouping and ungrouping, paste, move, and delete with groups.

### **Check-in 3:**
-Required features working.
<br/>Selected shapes have a dashed outline and can be copied/pasted/deleted.
<br/>-Can undo/redo paste and delete.

### **Check-in 2:**
-Required features working.
<br/>Can draw rectangle, ellipses, and triangles of all three shading types.
<br/>-Can select and move single/multiple shapes and can undo/redo move.

### **Check-in 1:**
-Required features working.
<br/>-Can draw rectangles from all directions and can undo/redo.

### **Design patterns used:**

**Command pattern used for Draw/Select/Move shapes, Copy/Paste/Delete/Group/Ungroup shapes, and Undo/Redo features:** 
ICommand, CreateShape, SelectShape, MoveShape, CopyCommand, PasteCommand, DeleteCommand, GroupCommand, UngroupCommand
UndoCommand, RedoCommand, JPaintController, CommandHistory, IUndoable

**Static Factory pattern used for creating shapes:**
CreateShape, ShapeFactory, IShape, Shape, Rectangle, Ellipse, Triangle, Point

**Strategy pattern used for painting shapes to canvas:**
PaintCanvas, IPaintStrategy, ShapePainter, PaintRectangle, PaintEllipse, PaintTriangle

**Observer pattern used for decoupling PaintCanvas and repaint() from ShapeList, SelectShape, and MoveShape:**
PaintCanvas, ShapeList, SelectShape, MoveShape, Main, ObserverSubject, IShapeListObserver, IShapeListSubject

**Singleton pattern used for guaranteeing only a single instance of PaintCanvas:**
PaintCanvas, Main