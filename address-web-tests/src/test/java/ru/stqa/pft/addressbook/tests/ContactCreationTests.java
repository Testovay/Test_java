package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;


public class ContactCreationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @DataProvider
  public Iterator<Object[]> validContacts() {
    File photo = new File("src/test/resources/stru.png");
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactDate().withFirstname("Test1").withMiddlename("Testovich1").withLastname("Testovii1").withMobile("89277465676").withEmail("test@test1.com").withAddress("Moscow1").withGroup("test1").withPhoto(photo)});
    list.add(new Object[] {new ContactDate().withFirstname("Test2").withMiddlename("Testovich2").withLastname("Testovii2").withMobile("89277465676").withEmail("test@test2.com").withAddress("Moscow2").withGroup("test1").withPhoto(photo)});
    list.add(new Object[] {new ContactDate().withFirstname("Test3").withMiddlename("Testovich3").withLastname("Testovii3").withMobile("89277465676").withEmail("test@test3.com").withAddress("Moscow3").withGroup("test1").withPhoto(photo)});
    return list.iterator();
  }
  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactDate contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
  @Test
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactDate contact = new ContactDate()
            .withFirstname("Test1'").withMiddlename("Testovich").withLastname("Testovii").withMobile("89277465676").withEmail("test@test.com").withAddress("Moscow").withGroup("Test");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
