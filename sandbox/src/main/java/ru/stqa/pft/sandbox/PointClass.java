package ru.stqa.pft.sandbox;

public class PointClass {
  public static void main(String[] args) {
    Point p1 = new Point(2,2);
    Point p2 = new Point(4,4);
    System.out.println("Расстояние мужду точкой A=" + p1.x + ";" + p1.y + " и точкой B=" + p2.x + ";" + p2.y + " равно " + distance(p1,p2));
  }

  public static double distance (Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.x- p1.x),2)+Math.pow((p2.y- p1.y),2));
  }
}
