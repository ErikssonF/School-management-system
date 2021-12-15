package org.example;

import org.example.daos.*;

import java.util.Scanner;

public class App {

    boolean run = true;

    Scanner scan = new Scanner(System.in);

    public MainDao<Student> studentDao;
    public MainDao<Teacher> teacherDao;
    public MainDao<Course> courseDao;
    public MainDao<Programme> programmeDao;

    public Student student;
    public Teacher teacher;
    public Course course;
    public Programme programme;

    void initializer(){
        studentDao = new StudentDao();
        teacherDao = new TeacherDao();
        courseDao = new CourseDao();
        programmeDao = new ProgrammeDao();

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
            4. Utbildning
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
    }

    private void studentMenu() {
        System.out.println("""
        
        Studentmeny
            1. Lägg till ny
            2. Uppdatera nuvarande
            3. Ta bort
            4. Visa alla studenter
            5. Visa specifik student
            0. Tillbaka till huvudmeny""");

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> studentDao.add(student.studentValuesInput());
            case 2 -> studentDao.update(student.studentValuesUpdate());
            case 3 -> studentDao.remove(studentDao.getById("Skriv in det id på den student du vill ta bort"));
            case 4 -> studentDao.showAll().forEach(System.out::println);
            case 5 -> System.out.println(studentDao.getById("Skriv in det id på den student du vill visa"));
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
            case 1 -> teacherDao.add(teacher.teacherValuesInput());
            case 2 -> teacherDao.update(teacher.teacherValuesUpdate());
            case 3 -> teacherDao.remove(teacherDao.getById("Skriv in det id på den student du vill ta bort"));
            case 4 -> teacherDao.showAll().forEach(System.out::println);
            case 5 -> System.out.println(teacherDao.getById("Skriv in det id på den student du vill visa"));
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
            case 1 -> courseDao.add(course.courseValuesInput());
            case 2 -> courseDao.update(course.courseValuesUpdate());
            case 3 -> courseDao.remove(courseDao.getById("Skriv in det id på den student du vill ta bort"));
            case 4 -> courseDao.showAll().forEach(System.out::println);
            case 5 -> System.out.println(courseDao.getById("Skriv in det id på den student du vill visa"));
            case 0 -> run = false;
            default -> System.out.println("Fel input prova igen");
        }
    }

    private void programmeMenu() {
        System.out.println("""
        
        Utbildningsmeny
            1. Lägg till ny
            2. Uppdatera nuvarande
            3. Ta bort
            4. Visa alla utbildningar
            5. Visa specifik utbildning
            0. Tillbaka till huvudmeny""");

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> programmeDao.add(programme.programmeValuesInput());
            case 2 -> programmeDao.update(programme.programmeValuesUpdate());
            case 3 -> programmeDao.remove(programmeDao.getById("Skriv in det id på den student du vill ta bort"));
            case 4 -> programmeDao.showAll().forEach(System.out::println);
            case 5 -> System.out.println(programmeDao.getById("Skriv in det id på den student du vill visa"));
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
}