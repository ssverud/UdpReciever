package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Drone {
    double x;
    double y;
    int r;
    int g;
    int b;
    Color color;

    private int height = 60;
    private int width = 60;
    private boolean active = false;
    private String IP;

    // picture of drone
    private Image image = new Image("Dronepic.png");

    // constructor
    public Drone(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void changeColor(Color color) {
        this.color = color;
    }

    // drawing of drone on canvas
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(color);
        graphicsContext.fillRect(getX() - 5 , getY() - 5 , getWidth() + 10, getHeight() + 10);
        graphicsContext.drawImage(image, getX(), getY(), getWidth(), getHeight());
    }

    // print in terminal
    @Override
    public String toString() {
        return "Drone{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", color=" + color +
                ", height=" + getHeight() +
                ", width=" + getWidth() +
                ", active=" + active +
                ", IP='" + IP + '\'' +
                '}';
    }

    // getters and setters
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}