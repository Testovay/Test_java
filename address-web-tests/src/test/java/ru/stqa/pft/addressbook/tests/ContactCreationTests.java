package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;


public class ContactCreationTests extends TestBase {
  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goHomePage();
    app.getContactHelper().createContact(new ContactDate("Test1", "Testovich", "Testovii", "89277465676", "test@test.com", "Moscow", "Test"), true);
  }


}
