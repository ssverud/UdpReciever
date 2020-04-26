package sample;

import javafx.scene.image.Image;

import java.util.Random;

public class Apple {
    private Random random = new Random();

    private int Width = 30;
    private int Height = 30;
    private int canvasWidth = 372;
    private int canvasHeight = 327;
    private boolean active = false;

    private double x = getRandom().nextInt(getCanvasWidth() - getWidth());
    private double y = getRandom().nextInt(getCanvasHeight() - getHeight());

    private Image image = new Image("apple.png");

    public Apple() {

    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int appleWidth) {
        this.Width = appleWidth;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int appleHeight) {
        this.Height = appleHeight;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "random=" + random +
                ", Width=" + Width +
                ", Height=" + Height +
                ", canvasWidth=" + canvasWidth +
                ", canvasHeight=" + canvasHeight +
                ", active=" + active +
                ", x=" + x +
                ", y=" + y +
                ", image=" + image +
                '}';
    }
}
