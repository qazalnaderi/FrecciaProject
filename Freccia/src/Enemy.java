public class Enemy {
    private static PApplet p = Main.processing;
    public int X;
    public int Y=-160;
    private PImage image;
    private int resistance;

    public Enemy(PImage image,int X,int Y,int resistance) {
        this.image=image;
        this.X=X;
        this.Y=Y;
        this.resistance=resistance;
    }
    

}
