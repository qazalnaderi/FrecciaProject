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

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }
    
}
