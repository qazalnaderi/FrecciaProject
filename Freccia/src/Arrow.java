import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
public class Arrow {
    static int speedY;
    public int Y;
    public int X;
    private static PImage image;

    private static PApplet pApplet = Main.pApplet;

    public Arrow(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
    public void makeArrow() {
        Main.arrows.add(new Arrow(pApplet.mouseX,520));
    }
    public static void arrowFace() {
        image = Main.pApplet.loadImage("arrow.png");
    }



}
