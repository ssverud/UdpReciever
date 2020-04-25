package sample;

import javafx.scene.image.Image;
import java.util.Random;
public class Apple {

    private Controller controller;

    Random random = new Random();
    Image image = new Image("apple.png");
    int imageHeight = 30;
    int imageWidth = 30;
    int canvasWidth = 372;
    int canvasHeight = 327;
    boolean isActive = false;
    private double x = random.nextInt(canvasWidth - imageWidth);
    private double y = random.nextInt(canvasHeight - imageHeight);

    public double calculateDistanceBetweenDroneAndApple(double x1, double y1, double x2, double y2) {
            double ac = Math.abs(y2 - y1);
            double cb = Math.abs(x2 - x1);
        return Math.hypot(ac, cb);
    }

    public void drawImage(Apple apple) {

        //Apple apple = new Apple();


        getController().getGraphicsContext().drawImage(image, apple.getX(), apple.getY(), imageWidth, imageHeight);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
