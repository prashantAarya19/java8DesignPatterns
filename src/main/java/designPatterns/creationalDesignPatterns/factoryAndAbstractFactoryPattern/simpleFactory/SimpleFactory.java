package designPatterns.creationalDesignPatterns.factoryAndAbstractFactoryPattern.simpleFactory;

class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    public static Point newCartisianPoint(double a, double b) {
//        return new Point(a, b);
//    }
//
//    public static Point newPolarPoint(double rho, double theta) {
//        return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
//    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static class Factory {
        public static Point newCartisianPoint(double a, double b) {
            return new Point(a, b);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
        }
    }
}
public class SimpleFactory {
    public static void main(String[] args) {
//        Point cartisianPoint = Point.newCartisianPoint(2, 3);
//        System.out.println(cartisianPoint);
//        Point polarPoint = Point.newPolarPoint(3, 2);
//        System.out.println(polarPoint);

        Point cartisianPoint = Point.Factory.newCartisianPoint(2, 3);
        System.out.println(cartisianPoint);
        Point polarPoint = Point.Factory.newPolarPoint(3, 2);
        System.out.println(polarPoint);

    }
}
