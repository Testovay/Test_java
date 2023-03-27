package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

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
    Contacts before = app.contact().all();
    ContactDate modifiedContact = before.iterator().next();
    ContactDate contact = new ContactDate()
           .withId(modifiedContact.getId()).withFirstname("Kyrs").withMiddlename("Kyrsovich").withLastname("Kyrsovii").withMobile("88979876543").withEmail("kyrs@test.com").withAddress("Omsk");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
