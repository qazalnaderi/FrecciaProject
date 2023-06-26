import processing.core.PImage;
public class FinalBoss {
    public int X;
    public int Y=-160;
    private PImage image;
    private int resistance;
    public FinalBoss horseRider;

    public FinalBoss(PImage image,int x, int y , int resistance) {
        X = x;
        Y = y;
        this.image = image;
        this.resistance = resistance;
    }

    public void setY(int y) {
        Y = y;
    }

    public void makeFinalBoss(){
        horseRider=new FinalBoss(Main.finalBoss,250,Y,10);
    }

    public PImage getImage() {
        return image;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

}
