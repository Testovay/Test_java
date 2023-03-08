package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactDate().withFirstname("Test1").withMiddlename("Testovich").withLastname("Testovii").withMobile("89277465676").withEmail("test@test.com").withAddress("Moscow").withGroup("Test"), true);
    }
  }
  @Test
  public void testContactModification() {
    List<ContactDate> before = app.contact().list();
    int index = before.size() - 1;
    ContactDate contact = new ContactDate()
            .withId(before.get(index).getId()).withFirstname("Kyrs").withMiddlename("Kyrsovich").withLastname("Kyrsovii").withMobile("88979876543").withEmail("kyrs@test.com").withAddress("Omsk");
    app.contact().modify(index, contact);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactDate> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
