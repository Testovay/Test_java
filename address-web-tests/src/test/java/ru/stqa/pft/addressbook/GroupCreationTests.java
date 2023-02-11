package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Test", "Test1", "Test2"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
