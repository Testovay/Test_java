package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification () {
    app.getNavigationHelper().goGroupsPage();
    int before = app.getGroupsHelper().getGroupCount();
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("Test", "Test11","Test111"));
    }
    app.getGroupsHelper().selectGroup(before - 1);
    app.getGroupsHelper().initGroupModification();
    app.getGroupsHelper().fillGroupForm(new GroupData("Kyrs", "TestEdit", "TestEdit"));
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().returnToGroupPage();
    int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
