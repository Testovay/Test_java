package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactDate {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String mobile;
  private String email;
  private String address;
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

  public ContactDate withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactDate withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactDate withAddress(String address) {
    this.address = address;
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
  public String getMobile() {return mobile;}
  public String getEmail() {return email;}
  public String getAddress() {return address;}
  public String getGroup() {return group;}

  @Override
  public String toString() {
    return "ContactDate{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactDate that = (ContactDate) o;

    if (id != that.id) return false;
    if (!Objects.equals(firstname, that.firstname)) return false;
    if (!Objects.equals(lastname, that.lastname)) return false;
    return Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    return result;
  }
}


