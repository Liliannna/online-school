package net.online.school.figures.v1;

import java.util.Objects;

public class Rectangle {

    private Point2D leftTop;
    private Point2D rightBottom;

    //Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(Point2D leftTop, Point2D rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    //Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom));
    }

    // Создает Rectangle, левый нижний угол которого находится в начале координат,
    // а  длина (по оси X) и ширина (по оси Y) задаются.
    public Rectangle(int length, int width) {
        this(0, width * -1, length, 0);
    }

    //Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
    public Rectangle() {
        this(0, -1, 1, 0);
    }

    //Возвращает левую верхнюю точку Rectangle.
    public Point2D getTopLeft() {
        return leftTop;
    }

    // Возвращает правую нижнюю точку Rectangle.
    public Point2D getBottomRight() {
        return rightBottom;
    }

    //Устанавливает левую верхнюю точку Rectangle.
    public void setTopLeft(Point2D topLeft) {
        this.leftTop = topLeft;
    }

    //Устанавливает правую нижнюю точку Rectangle.
    public void setBottomRight(Point2D bottomRight) {
        this.rightBottom = bottomRight;
    }

    //Возвращает длину прямоугольника.
    public int getLength() {
        int length = getTopLeft().getX() - getBottomRight().getX();
        if (length < 0) {
            length = length * -1;
        }
        return length;
    }

    //Возвращает ширину прямоугольника.
    public int getWidth() {
        int width = getTopLeft().getY() - getBottomRight().getY();
        if (width < 0) {
            width = width * -1;
        }
        return width;
    }

    //Передвигает Rectangle на (dx, dy).
    public void moveRel(int dx, int dy) {
        getTopLeft().moveRel(dx, dy);
        getBottomRight().moveRel(dx, dy);
    }

    //Увеличивает стороны Rectangle в (nx, ny) раз при сохранении координат левой верхней вершины.
    public void enlarge(int nx, int ny) {
        setBottomRight(new Point2D(getLength() * nx + getTopLeft().getX(), getWidth() * ny + getTopLeft().getY()));
    }

    //Возвращает площадь прямоугольника.
    public double getArea() {
        return getLength() * getWidth();
    }

    //Возвращает периметр прямоугольника.
    public double getPerimeter() {
        return (getLength() + getWidth()) * 2;
    }

    //Определяет, лежит ли точка (x, y) внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        return x >= getTopLeft().getX() && x <= getBottomRight().getX()
                && y >= getTopLeft().getY() && y <= getBottomRight().getY();
    }

    //Определяет, лежит ли точка point внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    //Определяет, пересекается  ли Rectangle с другим Rectangle. Считается, что прямоугольники пересекаются, если у них есть хоть одна общая точка.
    public boolean isIntersects(Rectangle rectangle) {
        return isInside(new Point2D(rectangle.getTopLeft().getX(), rectangle.getTopLeft().getY()))
                || isInside(new Point2D(rectangle.getBottomRight().getX(), rectangle.getBottomRight().getY()))
                || getTopLeft().getX() >= rectangle.getTopLeft().getX()
                && getTopLeft().getX() <= rectangle.getBottomRight().getX()
                && getTopLeft().getY() >= rectangle.getTopLeft().getY()
                && getTopLeft().getY() <= rectangle.getBottomRight().getY();
    }

    //Определяет, лежит ли rectangle целиком внутри текущего Rectangle.
    public boolean isInside(Rectangle rectangle) {
        return isInside(new Point2D(rectangle.getTopLeft().getX(), rectangle.getTopLeft().getY()))
                && isInside(new Point2D(rectangle.getBottomRight().getX(), rectangle.getBottomRight().getY()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;

        Rectangle rectangle = (Rectangle) o;

        if (!Objects.equals(leftTop, rectangle.leftTop)) return false;
        return Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        int result = leftTop != null ? leftTop.hashCode() : 0;
        result = 31 * result + (rightBottom != null ? rightBottom.hashCode() : 0);
        return result;
    }
}
