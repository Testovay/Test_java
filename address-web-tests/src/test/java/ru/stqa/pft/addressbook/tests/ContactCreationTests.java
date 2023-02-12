package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;


public class ContactCreationTests extends TestBase {
  @Test
  public void testContactCreation() {
    app.getContactHelper().initAddNew();
    app.getContactHelper().fillAddNewContact(new ContactDate("Test", "Testovich", "Testovii", "89277465676", "test@test.com", "Moscow"));
    app.getContactHelper().clickEnter();
    app.getContactHelper().returnHomePage();
  }


}
