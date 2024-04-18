package net.online.school.boxes;

import net.online.school.area.HasArea;
import net.online.school.figures.v3.Figure;

public class PairBox<T extends Figure, V extends Figure> implements HasArea, Comparable<PairBox> {

    private T obj1;
    private V obj2;

    public PairBox(T obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getContentFirst() {
        return obj1;
    }

    public void setContentFirst(T obj1) {
        this.obj1 = obj1;
    }

    public V getContentSecond() {
        return obj2;
    }

    public void setContentSecond(V obj2) {
        this.obj2 = obj2;
    }

    @Override
    public double getArea() {
        return obj1.getArea() + obj2.getArea();
    }

    @Override
    public int compareTo(PairBox o) {
        return (int) (getArea() - o.getArea());
    }

    public boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> obj1) {
        return compareTo(obj1) == 0;
    }

    public static boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> obj1,
                                      PairBox<? extends Figure, ? extends Figure> obj2) {
        return obj1.compareTo(obj2) == 0;
    }
}
