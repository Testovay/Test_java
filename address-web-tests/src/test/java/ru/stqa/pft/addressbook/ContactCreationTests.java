package ru.stqa.pft.addressbook;
import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {
  @Test
  public void testContactCreation() {
    app.initAddNew();
    app.fillAddNewContact(new ContactDate("Test", "Testovich", "Testovii", "89277465676", "test@test.com", "Moscow"));
    app.clickEnter();
  }


}
