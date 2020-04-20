package sample;

import javafx.scene.canvas.GraphicsContext;

public class Drone {
    int x;
    int y;
    int length = 20;
    int width = 20;

    public Drone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeRect(x-2, y-2, 20, 20);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }



    @Override
    public String toString() {
        return "Drone{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
