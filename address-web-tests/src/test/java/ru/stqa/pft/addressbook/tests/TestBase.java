package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(CHROME);

  @BeforeMethod
  public void setUp() throws Exception {
      app.init();
    }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
