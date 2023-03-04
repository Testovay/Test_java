package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.ArrayList;
import java.util.List;

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

  public void selectedContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();;
  }

  public void clickEnter() {
    click(By.cssSelector("input:nth-child(87)"));
  }

  public void returnHomePage() {click(By.linkText("home page"));}

  public void fillAddNewContact(ContactDate contactDate, boolean creation) {
    type(By.name("firstname"), contactDate.getFirstname());
    type(By.name("middlename"), contactDate.getMiddlename());
    type(By.name("lastname"), contactDate.getLastname());
    type(By.name("mobile"), contactDate.getMobile());
    type(By.name("email"), contactDate.getEmail());
    type(By.name("address"), contactDate.getAddress());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initAddNew() {
    click(By.linkText("add new"));
  }

  public void initContactModification(int index) {wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void clickUpdate() {click(By.cssSelector("input:nth-child(86)"));
  }

  public void createContact(ContactDate contact, boolean create) {
    initAddNew();
    fillAddNewContact(contact, create);
    clickEnter();
    returnHomePage();
  }

  public boolean isThereAContact() { return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactDate> getContactList() {
    List<ContactDate> contacts = new ArrayList<ContactDate>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      List<WebElement> data = element.findElements(By.tagName("td"));
      String lastname = data.get(1).getText();
      String firstname = data.get(2).getText();
      String address = data.get(3).getText();
      String email = data.get(4).getText();
      String mobile = data.get(5).getText();
      ContactDate contact = new ContactDate(firstname, null, lastname,mobile, email, address, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
