package net.online.school.cars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import net.online.school.cars.Car;
import net.online.school.colors.Color;
import net.online.school.colors.ColorErrorCode;
import net.online.school.colors.ColorException;

public class TestCar {

    @Test
    public void testCar1() throws ColorException {
        Car car = new Car("Tesla", 1500, 400, Color.BLUE);
        assertEquals(400, car.getMaxSpeed());
        assertEquals(1500, car.getWeight());
        assertEquals("Tesla", car.getModel());
        assertEquals(Color.BLUE, car.getColor());
        car.setColor(Color.GREEN);
        assertEquals(Color.GREEN, car.getColor());
        car.setModel("Ford");
        assertEquals("Ford", car.getModel());
        car.setWeight(2000);
        assertEquals(2000, car.getWeight());
        car.setMaxSpeed(200);
        assertEquals(200, car.getMaxSpeed());

    }

    @Test
    public void testCar2() throws ColorException {
        Car car = new Car("Tesla", 1500, 400, "BLUE");
        assertEquals(400, car.getMaxSpeed());
        assertEquals(1500, car.getWeight());
        assertEquals("Tesla", car.getModel());
        assertEquals(Color.BLUE, car.getColor());
        car.setColor("GREEN");
        assertEquals(Color.GREEN, car.getColor());
        car.setModel("Ford");
        assertEquals("Ford", car.getModel());
        car.setWeight(2000);
        assertEquals(2000, car.getWeight());
        car.setMaxSpeed(200);
        assertEquals(200, car.getMaxSpeed());

    }

    @Test
    @SuppressWarnings("unused")
    public void testCarWrongColor() {
        try {
            Car car = new Car("Tesla", 1500, 400, "YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            Car car = new Car("Tesla", 1500, 400, (String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Car car = new Car("Tesla", 1500, 400, (Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Car car = new Car("Tesla", 1500, 400, "BLUE");
            car.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Car car = new Car("Tesla", 1500, 400, "BLUE");
            car.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }


}