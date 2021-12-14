package org.example;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String firstName;
    private String lastName;
    private String SSN;

    public Student(String firstName, String lastName, String SSN) {
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

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
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

    Student studentValuesInput() {
        App app = new App();

        firstName = app.verifyString("Ange förnamn: ");
        lastName = app.verifyString("Ange efternamn: ");
        SSN = app.verifyString("Ange personnummer, endast siffror (12 siffror): ");

        while (SSN.length() != 12)
            SSN = app.verifyString("Personnumret som är angivet är felaktigt, försök igen.");

        return new Student(firstName,lastName,SSN);
    }
}
