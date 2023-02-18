package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void confirmDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
    click(By.cssSelector(".left:nth-child(8) > input"));
  }

  public void selectedContact() {
    click(By.name("selected[]"));
  }

  public void clickEnter() {
    click(By.cssSelector("input:nth-child(87)"));
  }

  public void returnHomePage() {click(By.linkText("home page"));}

  public void fillAddNewContact(ContactDate contactDate) {
    type(By.name("firstname"), contactDate.getFirstname());
    type(By.name("middlename"), contactDate.getMiddlename());
    type(By.name("lastname"), contactDate.getLastname());
    type(By.name("mobile"), contactDate.getMobile());
    type(By.name("email"), contactDate.getEmail());
    type(By.name("address2"), contactDate.getAddress2());
  }

  public void initAddNew() {
    click(By.linkText("add new"));
  }

  public void initContactModification() {click(By.cssSelector("tr:nth-child(2) > .center:nth-child(8) img"));
  }

  public void clickUpdate() {click(By.cssSelector("input:nth-child(86)"));
  }
}
