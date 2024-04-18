package net.online.school.figures.v1;

import java.util.Objects;

public class Triangle {
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;

    //Создает Triangle по координатам трех точек.
    public Triangle(Point2D point1, Point2D point2, Point2D point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    //Возвращает точку 1 треугольника.
    public Point2D getPoint1() {
        return point1;
    }

    //Возвращает точку 2 треугольника.
    public Point2D getPoint2() {
        return point2;
    }

    //Возвращает точку 3 треугольника.
    public Point2D getPoint3() {
        return point3;
    }

    //Устанавливает точку 1 треугольника.
    public void setPoint1(Point2D point) {
        this.point1 = point;
    }

    //Устанавливает точку 2 треугольника.
    public void setPoint2(Point2D point) {
        this.point2 = point;
    }

    //Устанавливает точку 3 треугольника.
    public void setPoint3(Point2D point) {
        this.point3 = point;
    }

    //Возвращает длину стороны
    public double getSide(Point2D point1, Point2D point2) {
        return Math.sqrt((point2.getX() - point1.getX()) * (point2.getX() - point1.getX())
                + (point2.getY() - point1.getY()) * (point2.getY() - point1.getY()));
    }

    //Возвращает длину стороны 1-2.
    public double getSide12() {
        return getSide(point1, point2);
    }

    //Возвращает длину стороны 1-3.
    public double getSide13() {
        return getSide(point1, point3);
    }

    //Возвращает длину стороны 2-3.
    public double getSide23() {
        return getSide(point2, point3);
    }

    //Передвигает Triangle на (dx, dy).
    public void moveRel(int dx, int dy) {
        getPoint1().moveRel(dx, dy);
        getPoint2().moveRel(dx, dy);
        getPoint3().moveRel(dx, dy);
    }

    //Возвращает площадь треугольника.
    public double getArea() {
        return Math.abs(((getPoint1().getX() - getPoint3().getX()) * (getPoint2().getY() - getPoint3().getY())
                - (getPoint1().getY() - getPoint3().getY()) * (getPoint2().getX() - getPoint3().getX())) * 0.5);
    }

    //Возвращает периметр треугольника.
    public double getPerimeter() {
        return getSide12() + getSide13() + getSide23();
    }

    //Определяет, лежит ли точка (x, y) внутри Triangle.
    //Если точка лежит на стороне треугольника, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        double area = getArea();
        double area1 = Math.abs(((getPoint1().getX() - getPoint2().getX()) * (y - getPoint2().getY())
                - (getPoint1().getY() - getPoint2().getY()) * (x - getPoint2().getX())) * 0.5);
        double area2 = Math.abs(((getPoint1().getX() - getPoint3().getX()) * (y - getPoint3().getY())
                - (getPoint1().getY() - getPoint3().getY()) * (x - getPoint3().getX())) * 0.5);
        double area3 = Math.abs(((getPoint2().getX() - getPoint3().getX()) * (y - getPoint3().getY())
                - (getPoint2().getY() - getPoint3().getY()) * (x - getPoint3().getX())) * 0.5);
        return area == area1 + area2 + area3;
    }

    //Определяет, лежит ли точка point внутри Triangle.
    //Если точка лежит на стороне треугольника, считается, что она лежит внутри.
    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (!Objects.equals(point1, triangle.point1)) return false;
        if (!Objects.equals(point2, triangle.point2)) return false;
        return Objects.equals(point3, triangle.point3);
    }

    @Override
    public int hashCode() {
        int result = point1 != null ? point1.hashCode() : 0;
        result = 31 * result + (point2 != null ? point2.hashCode() : 0);
        result = 31 * result + (point3 != null ? point3.hashCode() : 0);
        return result;
    }
}
