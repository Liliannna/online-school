package net.online.school.figures.v3;

import net.online.school.area.HasArea;
import net.online.school.colors.Color;
import net.online.school.colors.ColorErrorCode;
import net.online.school.colors.ColorException;
import net.online.school.colors.Colored;

abstract public class Figure implements Colored, HasArea {
    private Color color;

    abstract public void moveRel(int dx, int dy);

    abstract public boolean isInside(int x, int y);

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figure figure = (Figure) o;

        return color == figure.color;
    }

    @Override
    public int hashCode() {
        return color != null ? color.hashCode() : 0;
    }
}
