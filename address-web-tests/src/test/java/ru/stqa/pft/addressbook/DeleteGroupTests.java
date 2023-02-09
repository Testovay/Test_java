package ru.stqa.pft.addressbook;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {
  @Test
  public void testDeleteGroup() {
    goGroupsPage();
    selectGroup();
    deleteSelectedGroup();
    returnToGroupPage();
  }

}
