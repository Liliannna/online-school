package net.online.school.figures.v2;

abstract class Figure implements Colored {
    private int color;

    abstract public void moveRel(int dx, int dy);

    abstract public double getArea();

    abstract public boolean isInside(int x, int y);

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
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
        return color;
    }
}
