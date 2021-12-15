package org.example;

import org.example.daos.*;

import java.util.Scanner;

public class App {

    boolean run = true;

    Scanner scan = new Scanner(System.in);

    public StudentDao studentDao;
    public TeacherDao teacherDao;
    public CourseDao courseDao;
    public ProgrammeDao programmeDao;

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
            0. Tillbaka till huvudmeny""");

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
//            case 1 -> courseDao.numberOfCoursesInSchool().forEach(System.out::println);
//            case 2 -> courseDao.update(student.studentValuesUpdate());
            case 3 -> studentDao.numberOfStudentsInSchool();
            case 4 -> studentDao.numberOfStudentsInProgramme(verifyInteger("Skriv programmets id: "));
//            case 5 -> teacherDao.numberOfTeachersInSchool().forEach(System.out::println);
//            case 5 -> teacherDao.numberOfTeachersInSchool().forEach(System.out::println);
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
            case 1 -> studentDao.add(student.studentValuesInput());
            case 2 -> studentDao.update(student.studentValuesUpdate());
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
            case 1 -> teacherDao.add(teacher.teacherValuesInput());
            case 2 -> teacherDao.update(teacher.teacherValuesUpdate());
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
            case 1 -> courseDao.add(course.courseValuesInput());
            case 2 -> courseDao.update(course.courseValuesUpdate());
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
            case 1 -> programmeDao.add(programme.programmeValuesInput());
            case 2 -> programmeDao.update(programme.programmeValuesUpdate());
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
}