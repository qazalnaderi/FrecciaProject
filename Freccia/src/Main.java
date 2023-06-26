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
    public static PImage quiver;

    private static int count=0;
    private static int countExtra=0;
    static int arrowSpeed=5;
    static int arrowNumbers=10;
    public static int scoreNumber = 0;

    public static ArrayList<Enemy> knights = new ArrayList<>();
    public static ArrayList<Arrow> arrows = new ArrayList<>();
    public static ArrayList<Extra> extras = new ArrayList<>();

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
        quiver=loadImage("quiver.png");

        Enemy enemy = new Enemy(null, 0, 0, 0);
        enemy.makeKnights();

        Extra extra=new Extra(0,0,null);
        extra.makeExtra();


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
        moveExtra();
        for (Extra a : extras) {
            showExtra(a.getImage(), a.getX(), a.getY());
        }

        Arrow.showArrow(arrows);
        Arrow.moveArrow(arrowSpeed);
        if (arrowNumbers == 0)
             lost();
        if (keyPressed){
            if (shoot){
                Arrow arrow = new Arrow(mouseX, 0);
                arrow.makeArrow();
                Arrow.arrowFace();
                arrowNumbers--;
            }
            shoot = false;
            count++;
            if (count == 10) {
                shoot = true;
                count = 0;
            }
        }
        checkCrushedWithKnights();

        //TODO add text and rect
        checkCrushedWithExtra();



    }

    public void moveKnights() {
        for (Enemy e : knights) {
            e.setY(e.getY() + 2);
        }
    }

    public void showKnights(PImage image, int X, int Y) {
        image(image, X, Y);
    }
    public void moveExtra() {
        for (Extra a : extras) {
            a.setY(a.getY() + 2);
        }
    }
    public void showExtra(PImage image, int X, int Y) {
        image(image, X, Y);
    }



    public void checkCrushedWithKnights() {
//        Two loops for checking each item X,Y
        for (int i=0;i<Main.arrows.size();i++) {
            for(int j=0;j<Main.knights.size();j++){
                if (Main.arrows.get(i).X+15 >= Main.knights.get(j).X && Main.arrows.get(i).getX()+15 <= Main.knights.get(j).getX() + 45 &&
                        Main.arrows.get(i).Y >= Main.knights.get(j).getX() && Main.arrows.get(i).Y <= Main.knights.get(j).getY() + 45) {
                    //Check the resistance and then remove
                    if (knights.get(j).getResistance()==2) {
                        Main.arrows.remove(Main.arrows.get(i));
                        knights.get(j).setImage(injuredKnight2);
                        knights.get(j).setResistance(1);
                        scoreNumber++;                    }
                    else if (knights.get(j).getResistance()==1){
                        Main.arrows.remove(Main.arrows.get(i));
                        Main.knights.remove(Main.knights.get(j));
                        scoreNumber++;
                    }
                    break;
                }
            }
        }
    }
    //    Collect scores by catching extras and also make them disappear
    public void checkCrushedWithExtra() {
        for (int i=0 ; i<Main.extras.size() ; i++) {
            if (Main.extras.get(i).X - mouseX < 15 && mouseX -  Main.extras.get(i).X < 15 && Main.extras.get(i).Y > 535 && Main.extras.get(i).Y < 630){
                Main.extras.remove(Main.extras.get(i));
                arrowNumbers+=10;
            }
        }
    }

    public void lost() {
        //TODO Change this
        //TODO add return options
        background(0, 0, 0);
        fill(194, 47, 27);
        textSize(50);
        text("GAME OVER", 125, 200);
        fill(250, 147, 37);
        textSize(35);
        text("Final Score: " + scoreNumber, 145, 330);
        //Move the time formula to draw and do sth else about it

        text("Return to menu", 130, 450);
        text("Exit", 215, 570);

        //TODO add mouse-clicked methode for checking this
    }





    }
