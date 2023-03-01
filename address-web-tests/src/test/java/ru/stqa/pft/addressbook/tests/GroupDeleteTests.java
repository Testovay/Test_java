package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeleteTests extends TestBase {
  @Test
  public void testGroupDelete () {
    app.getNavigationHelper().goGroupsPage();
    int before = app.getGroupsHelper().getGroupCount();
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("Test", "Test11","Test111"));
    }
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().deleteSelectedGroup();
    app.getGroupsHelper().returnToGroupPage();
    int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
