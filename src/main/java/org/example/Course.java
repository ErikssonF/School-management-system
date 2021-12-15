package org.example;

import org.example.daos.CourseDao;
import org.example.daos.TeacherDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    private String courseName;

    @ManyToMany(targetEntity = Teacher.class)
    private List<Teacher> teacherList;

    public Course(String courseName, List<Teacher> teacherList) {
        this.courseName = courseName;
        this.teacherList = teacherList;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return "Course{" +
               "courseId=" + courseId +
               ", courseName='" + courseName + '\'' +
               ", teacherList=" + teacherList +
               '}';
    }

    Course courseValuesInput() {
        App app = new App();
        TeacherDao teacherDao = new TeacherDao();

        courseName = app.verifyString("Kursens namn: ");
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacherDao.getById("Skriv in id för den lärare du vill lägga till i kursen"));

        return new Course(courseName, teacherList);
    }

    public Course courseValuesUpdate() {
        CourseDao courseDao = new CourseDao();
        TeacherDao teacherDao = new TeacherDao();
        App app = new App();

        Course course = courseDao.getById("Skriv in id för den kurs du vill uppdatera");
        course.setCourseName(app.verifyString("Ange kursen namn: "));

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacherDao.getById("Skriv in id för den lärare du vill lägga till i kursen"));
        course.setTeacherList(teacherList);

        return course;
    }

}
