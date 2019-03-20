package learn.ijpds.ch34db.model;

import java.util.Objects;

public class Student {
    private String ssn;
    private String firstName;
    private String mi;
    private String lastName;
    private String phone;
    private String birthDate;
    private String street;
    private String zipCode;
    private String deptID;

    public Student() {
    }

    public Student(String ssn, String firstName, String mi, String lastName, String phone, String birthDate,
                   String street, String zipCode, String deptID) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.mi = mi;
        this.lastName = lastName;
        this.phone = phone;
        this.birthDate = birthDate;
        this.street = street;
        this.zipCode = zipCode;
        this.deptID = deptID;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(ssn, student.ssn) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(mi, student.mi) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(phone, student.phone) &&
                Objects.equals(birthDate, student.birthDate) &&
                Objects.equals(street, student.street) &&
                Objects.equals(zipCode, student.zipCode) &&
                Objects.equals(deptID, student.deptID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, firstName, mi, lastName, phone, birthDate, street, zipCode, deptID);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", mi='" + mi + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", deptID='" + deptID + '\'' +
                '}';
    }
}
