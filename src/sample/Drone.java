package sample;

import javafx.scene.canvas.GraphicsContext;

public class Drone {
    double x;
    double y;
    int length = 20;
    int width = 20;
    private boolean active = false;

    public Drone(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeRect(x-2, y-2, 20, 20);

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
                '}';
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
