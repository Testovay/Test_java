package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactDate {
  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String mobile;
  private final String email;
  private final String address;
  private final String group;
  public ContactDate (String firstname, String middlename, String lastname, String mobile, String email, String address, String group) {
    this.id = 0;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
    this.group = group;
  }
  public ContactDate (int id, String firstname, String middlename, String lastname, String mobile, String email, String address, String group) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
    this.group = group;
  }
  public void setId(int id) {
    this.id = id;
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


