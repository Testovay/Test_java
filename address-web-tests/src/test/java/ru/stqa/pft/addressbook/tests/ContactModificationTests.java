package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withFirstname("Test1").withMiddlename("Testovich").withLastname("Testovii").withMobile("89277465676").withEmail("test@test.com").withAddress("Moscow").withGroup("Test"), true);
    }
  }
  @Test
  public void testContactModification() {
    Set<ContactDate> before = app.contact().all();
    ContactDate modifiedContact = before.iterator().next();
    ContactDate contact = new ContactDate()
           .withId(modifiedContact.getId()).withFirstname("Kyrs").withMiddlename("Kyrsovich").withLastname("Kyrsovii").withMobile("88979876543").withEmail("kyrs@test.com").withAddress("Omsk");
    app.contact().modify(contact);
    Set<ContactDate> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }



}
