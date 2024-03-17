import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioSetTest {
    @Test
    public void testSetCurrentStationRegularFlow() {
        RadioSet radio = new RadioSet();

        radio.getCurrentStation(8);
        int actual = radio.getCurrentStation();
        int expected = 8;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentStationOverMax() {
        RadioSet radio = new RadioSet();

        radio.getCurrentStation(8);
        radio.getCurrentStation(15);
        int actual = radio.getCurrentStation();
        int expected = 8;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentStationUnderMin() {
        RadioSet radio = new RadioSet();

        radio.getCurrentStation(8);
        radio.getCurrentStation(-15);
        int actual = radio.getCurrentStation();
        int expected = 8;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetNextStation() {
        RadioSet radio = new RadioSet();

        radio.getCurrentStation(8);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 9;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetNextStationPlus() {
        RadioSet radio = new RadioSet();

        radio.getCurrentStation(9);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetPrevStation() {
        RadioSet radio = new RadioSet();

        radio.getCurrentStation(8);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetPrevStationPlus() {
        RadioSet radio = new RadioSet();

        radio.getCurrentStation(0);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 9;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetIncereaseVolume() {
        RadioSet radio = new RadioSet();

        for (int i = 0; i < 3; i++) {
            radio.increaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetIncereaseVolumeMax() {
        RadioSet radio = new RadioSet();

        for (int i = 0; i < 500; i++) {
            radio.increaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 100;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetDecereaseVolume() {
        RadioSet radio = new RadioSet();

        for (int i = 0; i < 3; i++) {
            radio.decreaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetDecereaseVolumeMax() {
        RadioSet radio = new RadioSet();

        for (int i = 0; i < 50; i++) {
            radio.increaseVolume();
        }
        for (int i = 0; i < 10; i++) {
            radio.decreaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 40;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetNextStationLimitUp() {
        RadioSet radio = new RadioSet(20);

        radio.getCurrentStation(19);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetNextStationLimitDown() {
        RadioSet radio = new RadioSet(20);

        radio.getCurrentStation(0);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 19;

        Assertions.assertEquals(expected, actual);
    }
}