import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static PApplet processing;
    public static PImage knight;
    public static PImage knight2;
    public static PImage injuredKnight;
    public static PImage injuredKnight2;

    public static void main(String[] args) {PApplet.main("Main", args);}
    @Override
    public void setup() {
        processing = this;
        knight = loadImage("knight.png");
        injuredKnight = loadImage("injured-knight.png");
        knight2 = loadImage("knight2.png");
    }
    @Override
    public void settings() {
        size(500, 700);
    }
    @Override
    public void draw() {}




    }
