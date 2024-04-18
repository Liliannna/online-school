package net.online.school.figures.v3;

import net.online.school.colors.Color;
import net.online.school.colors.ColorException;

public class Triangle extends Figure {

    private Point2D point1;
    private Point2D point2;
    private Point2D point3;

    public Triangle(Point2D point1, Point2D point2, Point2D point3, Color color) throws ColorException {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        setColor(color);
    }

    public Triangle(Point2D point1, Point2D point2, Point2D point3, String color) throws ColorException {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        setColor(color);
    }

    public Point2D getPoint1() {
        return point1;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public Point2D getPoint3() {
        return point3;
    }

    public void setPoint1(Point2D point) {
        this.point1 = point;
    }

    public void setPoint2(Point2D point) {
        this.point2 = point;
    }

    public void setPoint3(Point2D point) {
        this.point3 = point;
    }

    public double getSide(Point2D point1, Point2D point2){
        return Math.sqrt((point2.getX() - point1.getX()) * (point2.getX() - point1.getX())
                + (point2.getY() - point1.getY()) * (point2.getY() - point1.getY()));
    }
    public double getSide12() {
        return getSide(point1, point2);
    }

    public double getSide13() {
        return getSide(point1, point3);
    }

    public double getSide23() {
        return getSide(point2, point3);
    }

    @Override
    public void moveRel(int dx, int dy) {
        getPoint1().moveRel(dx, dy);
        getPoint2().moveRel(dx, dy);
        getPoint3().moveRel(dx, dy);
    }

    @Override
    public double getArea() {
        return Math.abs(((getPoint1().getX() - getPoint3().getX()) * (getPoint2().getY() - getPoint3().getY())
                - (getPoint1().getY() - getPoint3().getY()) * (getPoint2().getX() - getPoint3().getX())) * 0.5);
    }

    public double getPerimeter() {
        return getSide12() + getSide13() + getSide23();
    }

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Triangle triangle = (Triangle) o;

        if (point1 != null ? !point1.equals(triangle.point1) : triangle.point1 != null) return false;
        if (point2 != null ? !point2.equals(triangle.point2) : triangle.point2 != null) return false;
        return point3 != null ? point3.equals(triangle.point3) : triangle.point3 == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (point1 != null ? point1.hashCode() : 0);
        result = 31 * result + (point2 != null ? point2.hashCode() : 0);
        result = 31 * result + (point3 != null ? point3.hashCode() : 0);
        return result;
    }
}

