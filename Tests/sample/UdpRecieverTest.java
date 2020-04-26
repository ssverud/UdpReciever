package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class UdpRecieverTest {

    @Test
    void messageHandler() {

        Drone drone = new Drone(50, 30);
        drone.setActive(true);
        assertTrue(drone.isActive());




    }
}