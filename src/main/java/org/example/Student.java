package org.example;

import org.example.daos.StudentDao;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String firstName;
    private String lastName;
    private String SSN;
    private int programmeId;

    public Student(String firstName, String lastName, String SSN, int programmeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.programmeId = programmeId;
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

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }

    @Override
    public String toString() {
        return "Student{" +
               "studentId=" + studentId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", SSN='" + SSN + '\'' +
               ", programmeId=" + programmeId +
               '}';
    }

    Student studentValuesInput() {
        App app = new App();

        firstName = app.verifyString("Ange förnamn: ");
        lastName = app.verifyString("Ange efternamn: ");
        SSN = app.verifyString("Ange personnummer, endast siffror (12 siffror): ");

        while (SSN.length() != 12)
            SSN = app.verifyString("Personnumret som är angivet är felaktigt, försök igen.");

        programmeId = app.verifyInteger("Ange utbildningens ID: ");

        return new Student(firstName,lastName,SSN, programmeId);
    }

    public Student studentValuesUpdate() {
        StudentDao studentDao = new StudentDao();
        App app = new App();

        Student student = studentDao.getById("Skriv in id för den student du vill uppdatera");
        student.setFirstName(app.verifyString("Ange förnamn: "));
        student.setLastName(app.verifyString("Ange efternamn: "));
        student.setSSN(app.verifyString("Ange personnummer, endast siffror (12 siffror): "));
        student.setProgrammeId(app.verifyInteger("Ange utbildningens ID: "));

        return student;
    }
}
