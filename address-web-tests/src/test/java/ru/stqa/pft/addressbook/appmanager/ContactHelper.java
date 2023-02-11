package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactHelper {
  private FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
    this.wd = wd;
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
