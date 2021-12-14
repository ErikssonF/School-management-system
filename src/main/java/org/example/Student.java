package org.example;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String firstName;
    private String lastName;
    private Date SSN;

    public Student(int studentId, String firstName, String lastName, Date SSN) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getSSN() {
        return SSN;
    }

    public void setSSN(Date SSN) {
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return "Student{" +
               "studentId=" + studentId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", SSN=" + SSN +
               '}';
    }
}
