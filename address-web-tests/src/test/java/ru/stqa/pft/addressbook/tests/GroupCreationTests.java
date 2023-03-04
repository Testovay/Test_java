package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goGroupsPage();
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().createGroup(new GroupData("Test", "Test11","Test111"));
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
