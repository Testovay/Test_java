package ru.stqa.pft.addressbook;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {
  @Test
  public void testDeleteGroup() {
    app.goGroupsPage();
    app.selectGroup();
    app.deleteSelectedGroup();
    app.returnToGroupPage();
  }

}