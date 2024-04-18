package net.online.school.figures.v1;

public class CircleFactory {

    private static int circleCount = 0;

    public static Circle createCircle(Point2D center, int radius) {
        //Создает Circle по координатам центра и значению радиуса.
        circleCount++;
        return new Circle(center, radius);

    }


    public static int getCircleCount() {
        //Возвращает количество Circle, созданных с помощью метода createCircle.

        return circleCount;
    }


    public static void reset() {
        //Устанавливает количество Circle, созданных с помощью метода createCircle,
        // равным 0 (иными словами, реинициализирует фабрику).
        circleCount = 0;
    }


}
