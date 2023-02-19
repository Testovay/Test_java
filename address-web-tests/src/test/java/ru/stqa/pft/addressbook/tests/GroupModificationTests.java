package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification () {
    app.getNavigationHelper().goGroupsPage();
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("Test", "Test11","Test111"));
    }
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().initGroupModification();
    app.getGroupsHelper().fillGroupForm(new GroupData("Test", "TestEdit", "TestEdit"));
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().returnToGroupPage();
  }
}
