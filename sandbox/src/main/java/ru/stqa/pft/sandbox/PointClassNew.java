package ru.stqa.pft.sandbox;

public class PointClassNew {
  public static void main(String[] args) {
    PointNew p = new PointNew(3,2,4,7);
    System.out.println("Расстояние мужду точкой A=" + p.x1 + ";" + p.y1 + " и точкой B=" + p.x2 + ";" + p.y2 + " равно " + p.distance());
  }
}
