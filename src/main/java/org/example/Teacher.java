package org.example;

import org.example.daos.TeacherDao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    private String firstName;
    private String lastName;
    private String SSN;
    private int courseId;

    public Teacher(String firstName, String lastName, String SSN, int courseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.courseId = courseId;
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

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
               "teacherId=" + teacherId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", SSN='" + SSN + '\'' +
               ", courseId=" + courseId +
               '}';
    }

    Teacher teacherValuesInput() {
        App app = new App();

        firstName = app.verifyString("Ange förnamn: ");
        lastName = app.verifyString("Ange efternamn: ");
        SSN = app.verifyString("Ange personnummer, endast siffror (12 siffror): ");

        while (SSN.length() != 12)
            SSN = app.verifyString("Personnumret som är angivet är felaktigt, försök igen.");

        courseId = app.verifyInteger("Ange programmets ID: ");

        return new Teacher(firstName,lastName,SSN, courseId);
    }

    public Teacher teacherValuesUpdate() {
        TeacherDao teacherDao = new TeacherDao();
        App app = new App();

        Teacher teacher = teacherDao.getById("Skriv in id för den lärare du vill uppdatera");
        teacher.setFirstName(app.verifyString("Ange förnamn: "));
        teacher.setLastName(app.verifyString("Ange efternamn: "));
        teacher.setSSN(app.verifyString("Ange personnummer, endast siffror (12 siffror): "));
        teacher.setCourseId(app.verifyInteger("Ange programmets ID: "));

        return teacher;
    }
}
