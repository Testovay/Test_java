package ru.stqa.pft.addressbook.tests;// Generated by Selenium IDE

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;


public class ContactDeleteTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withFirstname("Test1").withMiddlename("Testovich").withLastname("Testovii").withMobile("89277465676").withEmail("test@test.com").withAddress("Moscow").withGroup("[none]"), true);
    }
  }
  @Test
  public void testContactDelete () {
    Contacts before = app.contact().all();
    ContactDate deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
