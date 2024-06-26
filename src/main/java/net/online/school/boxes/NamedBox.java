package net.online.school.boxes;

import net.online.school.figures.v3.Figure;

public class NamedBox<T extends Figure> extends Box<T> {

    private String name;

    public NamedBox(T obj, String name) {
        super(obj);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
