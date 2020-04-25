package sample;

import javafx.scene.image.Image;

import java.util.Random;



public class Apple {

    Controller controller;

    Random random = new Random();
    Image image = new Image("apple.png");
    int imageHeight = 30;
    int imageWidth = 30;

    double randomX = random.nextInt(372 - imageWidth);
    double randomY = random.nextInt(327 - imageHeight);

    public void drawImage() {


        getGraphicsContext().drawImage(image, randomX, randomY, imageWidth, imageHeight);
    }



}
