package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().goHomePage();
      if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactDate("Test1", "Testovich", "Testovii", "89277465676", "test@test.com", "Moscow", "Test"), true);
    }
    List<ContactDate> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactDate contact = new ContactDate(before.get(before.size() - 1).getId(), "Kyrs", "Kyrsovich", "Kyrsovii", "88979876543", "kyrs@test.com", "Omsk", null);
    app.getContactHelper().fillAddNewContact(contact, false);
    app.getContactHelper().clickUpdate();
    app.getContactHelper().returnHomePage();
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after));
  }

}
