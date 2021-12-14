package org.example;

import org.example.daos.CourseDao;
import org.example.daos.ProgrammeDao;
import org.example.daos.StudentDao;
import org.example.daos.TeacherDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programmeId;

    private String programmeName;

    @OneToMany(targetEntity = Course.class)
    private List<Course> courseList;

    @OneToMany(targetEntity = Student.class)
    private List<Student> studentList;

    public Programme(String programmeName, List<Course> courseList, List<Student> studentList) {
        this.programmeName = programmeName;
        this.courseList = courseList;
        this.studentList = studentList;
    }

    public Programme() {
    }

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Programme{" +
               "programmeId=" + programmeId +
               ", programmeName='" + programmeName + '\'' +
               ", courseList=" + courseList +
               ", studentList=" + studentList +
               '}';
    }

    Programme programmeValuesInput() {
        App app = new App();
        StudentDao studentDao = new StudentDao();
        CourseDao courseDao = new CourseDao();

        programmeName = app.verifyString("Utbildningens namn: ");
        courseList.add(courseDao.getById("Skriv in id för den kurs du vill lägga till i utbildningen"));
        studentList.add(studentDao.getById("Skriv in id för den student du vill lägga till i utbildningen"));

        return new Programme(programmeName, courseList, studentList);
    }

    public Programme programmeValuesUpdate() {
        ProgrammeDao programmeDao = new ProgrammeDao();
        CourseDao courseDao = new CourseDao();
        StudentDao studentDao = new StudentDao();
        App app = new App();

        Programme programme = programmeDao.getById("Skriv in id för den utbildning du vill uppdatera");
        programme.setProgrammeName(app.verifyString("Ange utbildningens namn: "));

        List<Course> courseList = new ArrayList<>();
        courseList.add(courseDao.getById("Skriv in id för den kurs du vill lägga till i utbildningen"));
        programme.setCourseList(courseList);

        List<Student> studentList = new ArrayList<>();
        studentList.add(studentDao.getById("Skriv in id för den student du vill lägga till i utbildningen"));
        programme.setStudentList(studentList);

        return programme;
    }
}

