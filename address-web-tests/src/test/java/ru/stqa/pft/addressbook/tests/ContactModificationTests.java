package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillAddNewContact(new ContactDate("Test1", "Testovich1", "Testovii1", "892774656761", "test@test1.com", "Moscow1"));
    app.getContactHelper().clickUpdate();
    app.getContactHelper().returnHomePage();
  }

}
