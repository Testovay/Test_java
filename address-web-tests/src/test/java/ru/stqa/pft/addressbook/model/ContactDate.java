package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactDate {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String homephone;
  private String mobile;
  private String workphone;
  private String allphones;
  private String email;
  private String email2;
  private String email3;
  private String allemails;
  private String address;
  private String address2;
  private String group;

  public ContactDate withId(int id) {
    this.id = id;
    return this;
  }

  public ContactDate withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactDate withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactDate withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }
  public ContactDate withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }
  public ContactDate withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactDate withWorkphone(String workphone) {
    this.workphone = workphone;
    return this;
  }

  public ContactDate withAllphones(String allphones) {
    this.allphones = allphones;
    return this;
  }

  public ContactDate withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactDate withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactDate withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactDate withAllemails(String allemails) {
    this.allemails = allemails;
    return this;
  }
  public ContactDate withAddress(String address) {
    this.address = address;
    return this;
  }
  public ContactDate withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactDate withGroup(String group) {
    this.group = group;
    return this;
  }

  public int getId() {return id;}
  public String getFirstname() {return firstname;}
  public String getMiddlename() {return middlename;}
  public String getLastname() {return lastname;}
  public String getHomephone() {return homephone;}
  public String getMobile() {return mobile;}
  public String getWorkphone() {return workphone;}
  public String getAllphones() {return allphones;}
  public String getEmail() {return email;}
  public String getEmail2() {return email2;}
  public String getEmail3() {return email3;}
  public String getAllemails() {return allemails;}
  public String getAddress() {return address;}
  public String getAddress2() {return address2;}
  public String getGroup() {return group;}

  @Override
  public String toString() {
    return "ContactDate{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactDate that = (ContactDate) o;

    if (id != that.id) return false;
    if (!Objects.equals(firstname, that.firstname)) return false;
    return Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}


