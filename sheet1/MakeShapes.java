/** 
* MakeShapes.java
* 
* @version 1.2 10/02/2019
* 
* @author Simonas Petkevicius
*/

//package uk.ac.sheffield.com1003.problemsheet1;
import sheffield.*;

public class MakeShapes {

  /**
  * Array of 2 Circle objects that where needed to create
  */
  private Circle[] circles = new Circle[] {
                             new Circle(50, 100, 100),
                             new Circle(100, 200, 200) };
  /**
  * Array of 3 Line objects that where needed to create
  */
  private Line[] lines = new Line[] {
                         new Line(0, 0, 10, 10),  
                         new Line(10, 20, 12, 200),
                         new Line(20, 53, 80, 400) };

    /**
    * Modifies the length of nth line and displays it's length
    * @param n Line's number in the array (which to modify)
    * @param max maximum coordinate of the line
    */
    public void modifyLineLength(int n, int max) {
      
      for(int i = 0; i < n; i++) {

        lines[i].setEndPoint((int)(Math.random() * max),
                             (int)(Math.random() * max));
      }
      System.out.println("Changed lengths: \n");
      displayLineLength(3);
    }
    /**
    * Displays all length till the nth line in the array
    * @param n How many lines tto display
    */
    public void displayLineLength(int n) {

      for(int i = 0; i < n; i++) {

        System.out.println(" " + (i + 1) + " Line length: "
                           + lines[i].getLength() + "\n");
      }
    }
    /**
    * Draws a cricle on an EasyGraphics Window
    * @param drawing EasyGraphics window object
    * @param n which circle in the circles array to draw
    */
    public void drawCircle(EasyGraphics drawing, int n) {

      n -= 1;
      drawing.drawEllipse(circles[n].getPositionX() - (int) circles[n].getRadius(),
                          circles[n].getPositionY() - (int) circles[n].getRadius(),
                          (int) circles[n].getRadius(), (int) circles[n].getRadius());
    }

    /**
    * Draws a line on an EasyGraphics Window
    * @param drawing EasyGraphics window object
    * @param n which line in the lines array to draw
    */
    public void drawLine(EasyGraphics drawing, int n) {

      n -= 1;
      drawing.moveTo(lines[n].getStartPointX(), lines[n].getStartPointY());
      drawing.lineTo(lines[n].getEndPointX(), lines[n].getEndPointY());
    }
    public static void main(String args[]){

      // Creating EasyGraphics window object
      EasyGraphics drawing = new EasyGraphics(400, 400);

      // Initializing MakeShapes object
      MakeShapes creator = new MakeShapes();

      // Draw 3 lines
      creator.drawLine(drawing, 1);
      creator.drawLine(drawing, 2);
      creator.drawLine(drawing, 3);

      // Display length of all lines
      creator.displayLineLength(3);
      // Modify length of 1 line and displays its length
      creator.modifyLineLength(3, 400);
      // draws modified line
      creator.drawLine(drawing, 1);
      creator.drawLine(drawing, 2);
      creator.drawLine(drawing, 3);

      // draws circles
      creator.drawCircle(drawing, 1);
      creator.drawCircle(drawing, 2);
    }
}