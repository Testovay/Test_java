package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointClassNewTests {
  @Test
  public void testArea() {
    PointNew p = new PointNew(3,2,4,7);
    Assert.assertEquals(p.distance(),5.0990195135927845);
  }
}

