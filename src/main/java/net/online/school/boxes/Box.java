package net.online.school.boxes;

import net.online.school.area.HasArea;
import net.online.school.figures.v3.Figure;

public class Box<T extends Figure> implements HasArea, Comparable<Box> {
    private T obj;

    public Box(T obj) {
        this.obj = obj;
    }

    public T getContent() {
        return obj;
    }

    public void setContent(T obj) {
        this.obj = obj;
    }

    @Override
    public double getArea() {
        return obj.getArea();
    }

    @Override
    public int compareTo(Box o) {

        return (int) (getArea() - o.getArea());
    }

    public boolean isAreaEqual(Box<? extends Figure> obj) {
        return compareTo(obj) == 0;
    }

    public static boolean isAreaEqual(Box<? extends Figure> obj1, Box<? extends Figure> obj2) {
        return obj1.compareTo(obj2) == 0;
    }
}
