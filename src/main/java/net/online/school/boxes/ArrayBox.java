package net.online.school.boxes;

import net.online.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> implements Comparable<ArrayBox> {

    private T[] array;

    public ArrayBox(T[] array) {
        this.array = array;
    }

    public T[] getContent() {
        return array;
    }

    public void setContent(T[] array) {
        this.array = array;
    }

    public T getElement(int i) {
        return array[i];
    }

    public void setElement(int i, T obj) {
        array[i] = obj;
    }

    @Override
    public int compareTo(ArrayBox o) {
        return array.length - o.getContent().length;
    }

    public boolean isSameSize(ArrayBox<? extends Figure> array) {
        return compareTo(array) == 0;
    }
}