package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }

  }

  public void init() {
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

  public void returnToGroupPage() {
      wd.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
      wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation() {
      wd.findElement(By.name("new")).click();
  }

  public void goGroupsPage() { wd.findElement(By.linkText("groups")).click(); }

  public void stop() {
    wd.quit();
  }

  public void deleteSelectedGroup() {
    wd.findElement(By.name("delete")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void confirmDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
    wd.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
  }

  public void selectedContact() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void clickEnter() {
    wd.findElement(By.cssSelector("input:nth-child(87)")).click();
  }

  public void fillAddNewContact(ContactDate contactDate) {
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

  public void initAddNew() {
    wd.findElement(By.linkText("add new")).click();
  }
}
