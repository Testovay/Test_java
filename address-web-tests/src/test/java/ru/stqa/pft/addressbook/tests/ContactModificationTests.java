package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().goHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactDate("Test1", "Testovich", "Testovii", "89277465676", "test@test.com", "Moscow", "Test"), true);
    }
    app.getContactHelper().initContactModification(before - 1);
    app.getContactHelper().fillAddNewContact(new ContactDate("Kyrs", "Kyrsovich", "Kyrsovii", "88979876543", "kyrs@test.com", "Omsk", null), false);
    app.getContactHelper().clickUpdate();
    app.getContactHelper().returnHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }

}
