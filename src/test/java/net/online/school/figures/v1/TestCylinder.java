package net.online.school.figures.v1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCylinder {

    private static final double DOUBLE_EPS = 1E-6;

    /*@Test
    public void testCylinder1() {
        Point2D center = new Point2D(10, 20);
        Cylinder cylinder = new Cylinder(center, 10, 10);
        assertEquals(10, cylinder.getCenter().getX());
        assertEquals(20, cylinder.getCenter().getY());
        assertEquals(10, cylinder.getRadius());
        assertEquals(10, cylinder.getHeight());
    }

    @Test
    public void testCylinder2() {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10);
        assertEquals(10, cylinder.getCenter().getX());
        assertEquals(20, cylinder.getCenter().getY());
        assertEquals(10, cylinder.getRadius());
        assertEquals(10, cylinder.getHeight());
    }

    @Test
    public void testCylinder3() {
        Cylinder cylinder = new Cylinder(10, 10);
        assertEquals(0, cylinder.getCenter().getX());
        assertEquals(0, cylinder.getCenter().getY());
        assertEquals(10, cylinder.getRadius());
        assertEquals(10, cylinder.getHeight());
    }

    @Test
    public void testCylinder4() {
        Cylinder cylinder = new Cylinder();
        assertEquals(0, cylinder.getCenter().getX());
        assertEquals(0, cylinder.getCenter().getY());
        assertEquals(1, cylinder.getRadius());
        assertEquals(1, cylinder.getHeight());
    }

    @Test
    public void testMoveRelCylinder() {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10);
        cylinder.moveRel(100, 50);
        assertEquals(110, cylinder.getCenter().getX());
        assertEquals(70, cylinder.getCenter().getY());
        assertEquals(10, cylinder.getRadius());
        assertEquals(10, cylinder.getHeight());
    }

    @Test
    public void testEnlargeCylinder() {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10);
        cylinder.enlarge(5);
        assertEquals(10, cylinder.getCenter().getX());
        assertEquals(20, cylinder.getCenter().getY());
        assertEquals(50, cylinder.getRadius());
        assertEquals(10, cylinder.getHeight());
    }

    @Test
    public void testAreaCylinder() {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10);
        assertEquals(Math.PI * 100, cylinder.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testVolumeCylinder() {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10);
        assertEquals(Math.PI * 1000, cylinder.getVolume(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterCylinder() {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10);
        assertEquals(2 * Math.PI * 10, cylinder.getPerimeter(), DOUBLE_EPS);
    }

    @Test
    public void testIsPointInsideCylinder1() {
        Cylinder cylinder = new Cylinder(10, 10, 10, 10);
        assertTrue(cylinder.isInside(10, 10, 10));
        assertTrue(cylinder.isInside(20, 10, 10));
        assertTrue(cylinder.isInside(10, 20, 10));
        assertTrue(cylinder.isInside(15, 15, 10));
    }

    @Test
    public void testIsPointInsideCylinder2() {
        Cylinder cylinder = new Cylinder(new Point2D(10, 10), 10, 10);
        assertTrue(cylinder.isInside(new Point3D(10, 10, 10)));
        assertTrue(cylinder.isInside(new Point3D(20, 10, 10)));
        assertTrue(cylinder.isInside(new Point3D(10, 20, 10)));
        assertTrue(cylinder.isInside(new Point3D(15, 15, 10)));
    }

    @Test
    public void testEqualsCylinder() {
        Cylinder cylinder1 = new Cylinder(new Point2D(10, 10), 10, 10);
        Cylinder cylinder2 = new Cylinder(new Point2D(10, 10), 10, 10);
        Cylinder cylinder3 = new Cylinder(new Point2D(10, 10), 20, 10);
        Cylinder cylinder4 = new Cylinder(new Point2D(0, 0), 10, 10);
        assertEquals(cylinder1, cylinder2);
        assertNotEquals(cylinder1, cylinder3);
        assertNotEquals(cylinder1, cylinder4);
    }*/

}
