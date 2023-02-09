package ru.stqa.pft.addressbook;

public class ContactDate {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String mobile;
  private final String email;
  private final String address2;
  public ContactDate (String firstname, String middlename, String lastname, String mobile, String email, String address2) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address2 = address2;
  }

  public String getFirstname() {return firstname;}
  public String getMiddlename() {return middlename;}
  public String getLastname() {return lastname;}
  public String getMobile() {return mobile;}
  public String getEmail() {return email;}
  public String getAddress2() {return address2;}
}


