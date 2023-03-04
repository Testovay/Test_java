package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactCreationTests extends TestBase {
  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goGroupsPage();
    if (!app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("Test", "Test11", "Test111"));
    }  //проверка на наличие группы
    app.getNavigationHelper().goHomePage();
    List<ContactDate> before = app.getContactHelper().getContactList();
    ContactDate contact = new ContactDate("Test1", "Testovich", "Testovii", "89277465676", "test@test.com", "Moscow", "Test");
    app.getContactHelper().createContact(contact, true);
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactDate> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
