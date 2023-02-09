package ru.stqa.pft.addressbook;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ContactCreationTests {
  FirefoxDriver wd;
  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.cssSelector("input:nth-child(7)")).click();
  }

  @Test
  public void testContactCreation() {
    initAddNew();
    fillAddNewContact(new ContactDate("Test", "Testovich", "Testovii", "89277465676", "test@test.com", "Moscow"));
    clickEnter();
  }

  private void clickEnter() {
    wd.findElement(By.cssSelector("input:nth-child(87)")).click();
  }

  private void fillAddNewContact(ContactDate contactDate) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).sendKeys(contactDate.getFirstname());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).sendKeys(contactDate.getMiddlename());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).sendKeys(contactDate.getLastname());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).sendKeys(contactDate.getMobile());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).sendKeys(contactDate.getEmail());
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).sendKeys(contactDate.getAddress2());
  }

  private void initAddNew() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }

  }
}
