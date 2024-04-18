package net.online.school.cars;

import net.online.school.colors.ColorErrorCode;
import net.online.school.colors.ColorException;
import net.online.school.colors.Colored;
import net.online.school.colors.Color;

public class Car implements Colored {

    private Color color;
    private String model;
    private int weight;
    private int maxSpeed;

    public Car(String model, int weight, int maxSpeed, Color color) throws ColorException {
        this.model = model;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        setColor(color);
    }

    public Car(String model, int weight, int maxSpeed, String color) throws ColorException {
        this.model = model;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        setColor(color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        this.color = color;
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
    }

    public void setColor(String color) throws ColorException {
        setColor(Color.colorFromString(color));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (weight != car.weight) return false;
        if (maxSpeed != car.maxSpeed) return false;
        if (color != car.color) return false;
        return model != null ? model.equals(car.model) : car.model == null;

    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + weight;
        result = 31 * result + maxSpeed;
        return result;
    }
}
