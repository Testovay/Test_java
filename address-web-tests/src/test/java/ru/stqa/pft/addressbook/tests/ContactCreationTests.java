package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupData;


public class ContactCreationTests extends TestBase {
  @Test
  public void testContactCreation() {
    //app.getNavigationHelper().goGroupsPage();
    //if (! app.getGroupsHelper().isThereAGroup()) {
     // app.getGroupsHelper().createGroup(new GroupData("Test", "Test11","Test111"));
    //}  -- проверка на наличие группы
    app.getNavigationHelper().goHomePage();
    app.getContactHelper().createContact(new ContactDate("Test1", "Testovich", "Testovii", "89277465676", "test@test.com", "Moscow", "Test"), true);
  }

}
