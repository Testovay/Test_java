package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase {
  @Test
  public void testGroupDelete () {
    app.getNavigationHelper().goGroupsPage();
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().deleteSelectedGroup();
    app.getGroupsHelper().returnToGroupPage();
  }

}
