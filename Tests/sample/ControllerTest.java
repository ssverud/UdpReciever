package sample;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ControllerTest {

    @Test
    void drawAppleTest() {

        Image image = new Image("apple.png");

        Apple apple;
        apple = new Apple();

        apple.setImage(image);
        apple.setActive(true);
        assertTrue(apple.isActive());


    }
}