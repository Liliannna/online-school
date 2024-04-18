package net.online.school.figures.v2;

public class Rectangle3D extends Rectangle {

    private int height;

    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height, int color) {
        super(leftTop, rightBottom, color);
        this.height = height;
    }

    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height, int color) {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), height, color);
    }

    public Rectangle3D(int length, int width, int height, int color) {
        this(0, width * -1, length, 0, height, color);
    }

    public Rectangle3D(int color) {
        this(0, -1, 1, 0, 1, color);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    public boolean isInside(int x, int y, int z) {
        return isInside(x, y) && z < height;
    }

    public boolean isInside(Point3D point) {
        return isInside(point.getX(), point.getY(), point.getZ());
    }

    public boolean isInside(Rectangle3D rectangle) {
        return super.isInside(rectangle) && rectangle.getHeight() <= height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Rectangle3D that = (Rectangle3D) o;

        return height == that.height;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + height;
        return result;
    }
}
