package org.example;

import org.example.daoimpls.CourseDaoImpl;
import org.example.daoimpls.ProgrammeDaoImpl;
import org.example.daoimpls.StudentDaoImpl;
import org.example.daoimpls.TeacherDaoImpl;
import org.example.entities.Course;
import org.example.entities.Programme;
import org.example.entities.Student;
import org.example.entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    boolean run = true;

    Scanner scan = new Scanner(System.in);

    public StudentDaoImpl studentDao;
    public TeacherDaoImpl teacherDao;
    public CourseDaoImpl courseDao;
    public ProgrammeDaoImpl programmeDao;

    public Student student;
    public Teacher teacher;
    public Course course;
    public Programme programme;

    void initializer(){
        studentDao = new StudentDaoImpl();
        teacherDao = new TeacherDaoImpl();
        courseDao = new CourseDaoImpl();
        programmeDao = new ProgrammeDaoImpl();

        student = new Student();
        teacher = new Teacher();
        course = new Course();
        programme = new Programme();
    }

    public static void main(String[] args) {
        App app = new App();
        app.initializer();
        app.run();
    }

    void run() {
        int choice;

        do {
            printMenu();
            choice = verifyInteger("");
            mainMenu(choice);
        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println("""
        
        Huvudmeny?
            1. Student
            2. Lärare
            3. Kurs
            4. Program
            5. Statistik
            0. Avsluta programmet""");
    }

    private void mainMenu(int menuChoice) {
        switch(menuChoice) {
            case 1 -> studentMenu();
            case 2 -> teacherMenu();
            case 3 -> courseMenu();
            case 4 -> programmeMenu();
            case 5 -> statisticsMenu();
            case 0 -> run = false;
            default -> System.out.println("Fel input prova igen");
        }
    }

    private void statisticsMenu() {
        System.out.println("""
        
        Statistikmeny
            1. Visa antal kurser i skolan
            2. Visa antal kurser i ett program
            3. Visa antal elever i skolan
            4. Visa antal elever i ett program
            5. Visa antal lärare i skolan
            6. Visa antal lärare i en kurs
            7. Visa antal program i skolan
            0. Tillbaka till huvudmeny""");

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> courseDao.numberOfCoursesInSchool();
            case 2 -> courseDao.numberOfCoursesInProgramme(verifyInteger("Skriv in programmets ID: "));
            case 3 -> studentDao.numberOfStudentsInSchool();
            case 4 -> studentDao.numberOfStudentsInProgramme(verifyInteger("Skriv in programmets ID: "));
            case 5 -> teacherDao.numberOfTeachersInSchool();
            case 6 -> teacherDao.numberOfTeachersInCourse(verifyInteger("Skriv in kursens ID: "));
            case 7 -> programmeDao.numberOfProgrammesInSchool();
            case 0 -> run = false;
            default -> System.out.println("Fel input prova igen");
        }
    }

    private void studentMenu() {
        System.out.println("""
        
        Elevmeny
            1. Lägg till ny
            2. Uppdatera nuvarande
            3. Ta bort
            4. Visa alla elever
            5. Visa specifik elev
            0. Tillbaka till huvudmeny""");

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> studentDao.add(studentCreate());
            case 2 -> studentDao.update(studentUpdate());
            case 3 -> studentDao.remove(studentDao.getById("Skriv in det id på den elev du vill ta bort"));
            case 4 -> studentDao.showAll().forEach(System.out::println);
            case 5 -> System.out.println(studentDao.getById("Skriv in det id på den elev du vill visa"));
            case 0 -> run = false;
            default -> System.out.println("Fel input prova igen");
        }
    }

    private void teacherMenu() {
        System.out.println("""
        
        Lärarmeny
            1. Lägg till ny
            2. Uppdatera nuvarande
            3. Ta bort
            4. Visa alla lärare
            5. Visa specifik lärare
            0. Tillbaka till huvudmeny""");

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> teacherDao.add(teacherCreate());
            case 2 -> teacherDao.update(teacherUpdate());
            case 3 -> teacherDao.remove(teacherDao.getById("Skriv in det id på den lärare du vill ta bort"));
            case 4 -> teacherDao.showAll().forEach(System.out::println);
            case 5 -> System.out.println(teacherDao.getById("Skriv in det id på den lärare du vill visa"));
            case 0 -> run = false;
            default -> System.out.println("Fel input prova igen");
        }
    }

    private void courseMenu() {
        System.out.println("""
        
        Kursmeny
            1. Lägg till ny
            2. Uppdatera nuvarande
            3. Ta bort
            4. Visa alla kurser
            5. Visa specifik kurs
            0. Tillbaka till huvudmeny""");

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> courseDao.add(courseCreate());
            case 2 -> courseDao.update(courseUpdate());
            case 3 -> courseDao.remove(courseDao.getById("Skriv in det id på den kurs du vill ta bort"));
            case 4 -> courseDao.showAll().forEach(System.out::println);
            case 5 -> System.out.println(courseDao.getById("Skriv in det id på den kurs du vill visa"));
            case 0 -> run = false;
            default -> System.out.println("Fel input prova igen");
        }
    }

    private void programmeMenu() {
        System.out.println("""
        
        Programmeny
            1. Lägg till ny
            2. Uppdatera nuvarande
            3. Ta bort
            4. Visa alla program
            5. Visa specifikt program
            0. Tillbaka till huvudmeny""");

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> programmeDao.add(programmeCreate());
            case 2 -> programmeDao.update(programmeUpdate());
            case 3 -> programmeDao.remove(programmeDao.getById("Skriv in det id på det program du vill ta bort"));
            case 4 -> programmeDao.showAll().forEach(System.out::println);
            case 5 -> System.out.println(programmeDao.getById("Skriv in det id på det program du vill visa"));
            case 0 -> run = false;
            default -> System.out.println("Fel input prova igen");
        }

    }

    public String verifyString(String input) {
        System.out.println(input);

        while (scan.hasNextInt()) {
            System.out.println("Ej giltig input, försök igen");
            scan.next();
        }
        return scan.nextLine();
    }

    public int verifyInteger(String input) {
        System.out.println(input);

        while (!scan.hasNextInt()) {
            System.out.println("Ej giltig input, försök igen");
            scan.next();
        }
        return Integer.parseInt(scan.nextLine());
    }

    public Student studentCreate() {
        student.setFirstName(verifyString("Ange förnamn: "));
        student.setLastName(verifyString("Ange efternamn: "));
        student.setSSN(verifyString("Ange personnummer, endast siffror (12 siffror): "));

        return student;
    }

    public Student studentUpdate() {
        student = studentDao.getById("Skriv in id för den student du vill uppdatera");
        student.setFirstName(verifyString("Ange förnamn: "));
        student.setLastName(verifyString("Ange efternamn: "));
        student.setSSN(verifyString("Ange personnummer, endast siffror (12 siffror): "));

        return student;
    }

    public Teacher teacherCreate() {
        teacher.setFirstName(verifyString("Ange förnamn: "));
        teacher.setLastName(verifyString("Ange efternamn: "));
        teacher.setSSN(verifyString("Ange personnummer, endast siffror (12 siffror): "));

        return teacher;
    }

    public Teacher teacherUpdate() {
        teacher = teacherDao.getById("Skriv in id för den lärare du vill uppdatera");
        teacher.setFirstName(verifyString("Ange förnamn: "));
        teacher.setLastName(verifyString("Ange efternamn: "));
        teacher.setSSN(verifyString("Ange personnummer, endast siffror (12 siffror): "));

        return teacher;
    }

    public Course courseCreate() {
        course.setCourseName(verifyString("Kursens namn: "));
        course.setTeacherList(getTeacherList());
        return course;
    }

    public Course courseUpdate() {
        course = courseDao.getById("Skriv in id för den kurs du vill uppdatera");
        course.setCourseName(verifyString("Ange kursen namn: "));
        course.setTeacherList(getTeacherList());

        return course;
    }

    public Programme programmeCreate() {
        programme.setProgrammeName(verifyString("Programmets namn: "));

        programme.setStudentList(getStudentList());
        programme.setCourseList(getCourseList());

        return programme;
    }

    public Programme programmeUpdate() {
        programme = programmeDao.getById("Skriv in id för det programmet du vill uppdatera");
        programme.setProgrammeName(verifyString("Ange utbildningens namn: "));

        programme.setStudentList(getStudentList());
        programme.setCourseList(getCourseList());

        return programme;
    }

    private List<Student> getStudentList(){
        List<Student> studentList = new ArrayList<>();
        System.out.println("Hur många elever vill du lägga till i programmet?");

        int numberOfStudents = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print("Skriv id för elev nummer " + i + ":");
            studentList.add( studentDao.getById(""));
        }
        return studentList;
    }

    private List<Teacher> getTeacherList(){
        List<Teacher> teacherList = new ArrayList<>();
        System.out.println("Hur många lärare vill du lägga till i kursen?");

        int numberOfTeachers = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= numberOfTeachers; i++) {
            System.out.print("Skriv id för lärare nummer " + i + ":");
            teacherList.add(teacherDao.getById(""));
        }
        return teacherList;
    }

    private List<Course> getCourseList(){
        List<Course> courseList = new ArrayList<>();
        System.out.println("Hur många kurser vill du lägga till i programmet?");

        int numberOfCourse = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= numberOfCourse; i++) {
            System.out.print("Skriv id för kurs nummer " + i + ":");
            courseList.add(courseDao.getById(""));
        }
        return courseList;
    }
}