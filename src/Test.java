import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application
{
  public static final int NUMOFREC = 9;        //Number of recursive levels (def=9)
  public static final double TREESIZE = 1.95;   //Size of the tree. (Def = 2)
  public static final int DETAIL = 1;           //Detail level (Max = 1)
    

  @Override
  public void start(Stage stage) throws Exception
  {
    Canvas canvas = new Canvas(800, 600);
    drawFractal(canvas.getGraphicsContext2D(), 400, 600, NUMOFREC, 0);
    Pane root = new Pane();
    root.getChildren().add(canvas);
    Scene scene = new Scene(root, 1200, 1000);
    stage.setScene(scene);
    stage.show();
  }

  //Recursive method to create fractal pattern, using n levels of recursion
  public void drawFractal(GraphicsContext g, int x, int y, int n, int angle)
  {
    if (n == DETAIL)
    {
      return;
    }
    int len = (int) Math.round(Math.pow(TREESIZE, n - 1)); //Calculates the length of  branch
    int xn1 = (int) Math.round(x - (2 * len * Math.sin(Math.toRadians(angle)))); //Length and angle
    int yn1 = (int) Math.round(y - (2 * len * Math.cos(Math.toRadians(angle)))); //of the branches
    int mid1x = (x + xn1) / 2; //Positions of the branches
    int mid1y = (y + yn1) / 2;
   int mid2x = (mid1x + xn1) / 2; //Positions of the branches
    int mid2y = (mid1y + yn1) / 2;
    int mid3x = (x + mid1x) / 2; //Positions of the branches
    int mid3y = (y + mid1y) / 2;
    int mid4x = (mid3x + mid1x) / 2; //Positions of the branches
    int mid4y = (mid3y + mid1y) / 2;
    java.util.Random r = new java.util.Random(); //Creates a random number generator
    n--;
    drawFractal(g, mid1x, mid1y, n , angle - 60);
    drawFractal(g, mid1x, mid2y, n , angle + 5);
     drawFractal(g, mid1x, mid3y, n , angle -50);
    drawFractal(g, mid1x, mid4y, n , angle +45);
    g.setStroke(new Color(0,Math.random()*0.5+0.5,0,1));
    g.strokeLine(x, y, xn1, yn1); //Draws the line
    return;
  }

  public static void main(String args[])
  {
    launch(args);
  }
}
