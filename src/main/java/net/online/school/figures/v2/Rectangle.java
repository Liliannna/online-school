package net.online.school.figures.v2;

public class Rectangle extends Figure {
    private Point2D leftTop;
    private Point2D rightBottom;


    public Rectangle(Point2D leftTop, Point2D rightBottom, int color) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
        super.setColor(color);
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), color);
    }

    public Rectangle(int length, int width, int color) {
        this(0, width * -1, length, 0, color);
    }

    public Rectangle(int color) {
        this(0, -1, 1, 0, color);
    }

    public Point2D getTopLeft() {
        return leftTop;
    }

    public Point2D getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point2D topLeft) {
        this.leftTop = topLeft;
    }

    public void setBottomRight(Point2D bottomRight) {
        this.rightBottom = bottomRight;
    }

    public int getLength() {
        int length = getTopLeft().getX() - getBottomRight().getX();
        if (length < 0) {
            length = length * -1;
        }
        return length;
    }

    public int getWidth() {
        int width = getTopLeft().getY() - getBottomRight().getY();
        if (width < 0) {
            width = width * -1;
        }
        return width;
    }

    @Override
    public void moveRel(int dx, int dy) {
        getTopLeft().moveRel(dx, dy);
        getBottomRight().moveRel(dx, dy);
    }

    public void enlarge(int nx, int ny) {
        setBottomRight(new Point2D(getLength() * nx + getTopLeft().getX(), getWidth() * ny + getTopLeft().getY()));
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return (getLength() + getWidth()) * 2;
    }

    @Override
    public boolean isInside(int x, int y) {
        return x >= getTopLeft().getX() && x <= getBottomRight().getX()
                && y >= getTopLeft().getY() && y <= getBottomRight().getY();
    }

    public boolean isIntersects(Rectangle rectangle) {
        return isInside(new Point2D(rectangle.getTopLeft().getX(), rectangle.getTopLeft().getY()))
                || isInside(new Point2D(rectangle.getBottomRight().getX(), rectangle.getBottomRight().getY()))
                || getTopLeft().getX() >= rectangle.getTopLeft().getX()
                && getTopLeft().getX() <= rectangle.getBottomRight().getX()
                && getTopLeft().getY() >= rectangle.getTopLeft().getY()
                && getTopLeft().getY() <= rectangle.getBottomRight().getY();
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(new Point2D(rectangle.getTopLeft().getX(), rectangle.getTopLeft().getY()))
                && isInside(new Point2D(rectangle.getBottomRight().getX(), rectangle.getBottomRight().getY()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Rectangle rectangle = (Rectangle) o;

        if (leftTop != null ? !leftTop.equals(rectangle.leftTop) : rectangle.leftTop != null) return false;
        return rightBottom != null ? rightBottom.equals(rectangle.rightBottom) : rectangle.rightBottom == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (leftTop != null ? leftTop.hashCode() : 0);
        result = 31 * result + (rightBottom != null ? rightBottom.hashCode() : 0);
        return result;
    }
}

