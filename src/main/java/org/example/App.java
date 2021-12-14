package org.example;

import org.example.daos.*;

public class App {
    static private MainDao<Student> studentDao;
    static private MainDao<Teacher> teacherDao;
    static private MainDao<Course> courseDao;
    static private MainDao<Programme> programmeDao;

    public static void main(String[] args) {
        daoInitializer();

//        studentDao.add(new Student("Albin", "Dübech", "19960130-5114"));
//        studentDao.add(new Student("hopple", "Dübech", "19960130-5114"));
//        studentDao.add(new Student("Albin", "Dübehahdhhdahhdch", "19960130-5114"));
        System.out.println(studentDao.showSpecificInfo(1));
    }

    static void daoInitializer(){
        studentDao = new StudentDao();
        teacherDao = new TeacherDao();
        courseDao = new CourseDao();
        programmeDao = new ProgrammeDao();
    }
}