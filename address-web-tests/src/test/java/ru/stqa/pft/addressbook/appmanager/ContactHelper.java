package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
    wd.findElements(By.name("selected[]")).get(index).click();
  }
  public void selectedContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }
  public void clickEnter() {
    click(By.cssSelector("input:nth-child(87)"));
  }

  public void returnHomePage() {click(By.linkText("home page"));}

  public void fillAddNewContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"), contactData.getHomephone());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWorkphone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("address"), contactData.getAddress());
    type(By.name("address2"), contactData.getAddress2());
    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initAddNew() {
    click(By.linkText("add new"));
  }

  public void initContactModification(int index) {wd.findElements(By.cssSelector("img[alt=Edit]")).get(index).click(); }

  public void initContactModificationById(int id) {wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click(); }

  public void clickUpdate() {click(By.cssSelector("input:nth-child(86)"));
  }

  public void create(ContactData contact, boolean create) {
    initAddNew();
    fillAddNewContact(contact, create);
    clickEnter();
    contactCache = null;
    returnHomePage();
  }
  public void modify(int index, ContactData contact) {
    initContactModification(index);
    fillAddNewContact(contact, false);
    clickUpdate();
    returnHomePage();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillAddNewContact(contact, false);
    clickUpdate();
    contactCache = null;
    returnHomePage();
  }
  public void delete(int index) {
    selectedContact(index);
    deleteSelectedContact();
    confirmDeleteContact();
  }
  public void delete(ContactData contact) {
    selectedContactById(contact.getId());
    deleteSelectedContact();
    confirmDeleteContact();
    contactCache = null;
  }
  public boolean isThereAContact() { return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> data = element.findElements(By.tagName("td"));
      String lastname = data.get(1).getText();
      String firstname = data.get(2).getText();
      //String address = data.get(3).getText();
      //String email = data.get(4).getText();
      //String mobile = data.get(5).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }

  private Contacts contactCache = null;
  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      List<WebElement> data = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = data.get(1).getText();
      String firstname = data.get(2).getText();
      String address = data.get(3).getText();
      String allemails = data.get(4).getText();
      String allphones = data.get(5).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address).withAllphones(allphones).withAllemails(allemails));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lasttname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lasttname).withHomephone(home).withMobile(mobile).withWorkphone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address).withAddress2(address2);
  }
}
