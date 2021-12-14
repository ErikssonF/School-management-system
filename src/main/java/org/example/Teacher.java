package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    private String firstName;
    private String lastName;
    private Date SSN;

    public Teacher(int teacherId, String firstName, String lastName, Date SSN) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }

    public Teacher() {
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
        return "Teacher{" +
               "teacherId=" + teacherId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", SSN=" + SSN +
               '}';
    }
}
