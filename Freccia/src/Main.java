import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet {
    public static PApplet processing;
    public static PApplet pApplet;
    public static PImage knight;
    public static PImage knight2;
    public static PImage injuredKnight;
    public static PImage injuredKnight2;
    public static PImage arrow;

    private static int count=0;

    public static ArrayList<Enemy> knights = new ArrayList<>();
    public static ArrayList<Arrow> arrows = new ArrayList<>();

    private static boolean shoot=true;

    public static void main(String[] args) {PApplet.main("Main", args);}
    @Override
    public void setup() {
        processing = this;
        pApplet = this;
        knight = loadImage("knight.png");
        injuredKnight = loadImage("injured-knight.png");
        knight2 = loadImage("knight2.png");
        arrow = loadImage("arrow.png");

        Enemy enemy = new Enemy(null, 0, 0, 0);
        enemy.makeKnights();

    }
    @Override
    public void settings() {
        size(500, 700);
    }
    @Override
    public void draw() {
        moveKnights();
        for (Enemy e : knights) {
            showKnights(e.getImage(), e.getX(), e.getY());
        }

        Arrow.showArrow(arrows);
        Arrow.moveArrow(arrowSpeed);
        if (keyPressed){
            if (shoot){
                Arrow arrow = new Arrow(mouseX, 0);
                arrow.makeArrow();
                Arrow.arrowFace();
            }
            shoot = false;
            count++;
            if (count == 10) {
                shoot = true;
                count = 0;
            }
        }



    }

    public void moveKnights() {
        for (Enemy e : knights) {
            e.setY(e.getY() + 2);
        }
    }

    public void showKnights(PImage image, int X, int Y) {
        image(image, X, Y);
    }





    }
