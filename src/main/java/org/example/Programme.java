package org.example;

import javax.persistence.*;
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
}

