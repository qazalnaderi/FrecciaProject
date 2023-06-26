import processing.core.PApplet;
import processing.core.PImage;
public class Extra {
    private static PApplet p = Main.processing;
    public int X;
    public int Y=-80;
    private PImage image;

    public Extra(int x, int y, PImage image) {
        X = x;
        Y = y;
        this.image = image;
    }


}
