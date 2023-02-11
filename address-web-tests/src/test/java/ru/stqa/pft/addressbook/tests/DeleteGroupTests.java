package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {
  @Test
  public void testDeleteGroup() {
    app.getNavigationHelper().goGroupsPage();
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().deleteSelectedGroup();
    app.getGroupsHelper().returnToGroupPage();
  }

}
