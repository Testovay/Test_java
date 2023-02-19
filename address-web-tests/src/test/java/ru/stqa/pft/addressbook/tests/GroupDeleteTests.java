package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeleteTests extends TestBase {
  @Test
  public void testGroupDelete () {
    app.getNavigationHelper().goGroupsPage();
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("Test", "Test11","Test111"));
    }
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().deleteSelectedGroup();
    app.getGroupsHelper().returnToGroupPage();
  }

}
