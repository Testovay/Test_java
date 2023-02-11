package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  FirefoxDriver wd;
  private ContactHelper contactHelper;
  private NavigationHelper navigationHelper;
  private GroupsHelper groupsHelper;
  private SessionHelper sessionHelper;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupsHelper = new GroupsHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public GroupsHelper getGroupsHelper() {
    return groupsHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
