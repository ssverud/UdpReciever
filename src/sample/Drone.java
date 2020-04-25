package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Drone {
    double x;
    double y;
    int r;
    int g;
    int b;
    Color color = Color.BLACK;

    private int height = 20;
    private int width = 20;
    private boolean active = false;
    private String IP;


    public Drone(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void changeColor(Color color) {
        this.color = color;
    }



    public void draw(GraphicsContext graphicsContext) {


        graphicsContext.setFill(color);
        graphicsContext.fillRect(x-2, y-2, 20, 20);
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
}
