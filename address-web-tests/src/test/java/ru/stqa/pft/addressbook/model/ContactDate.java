package ru.stqa.pft.addressbook.model;

public class ContactDate {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String mobile;
  private final String email;
  private final String address;
  private final String group;

  public ContactDate (String firstname, String middlename, String lastname, String mobile, String email, String address, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
    this.group = group;
  }

  public String getFirstname() {return firstname;}
  public String getMiddlename() {return middlename;}
  public String getLastname() {return lastname;}
  public String getMobile() {return mobile;}
  public String getEmail() {return email;}
  public String getAddress() {return address;}
  public String getGroup() {return group;}
}


