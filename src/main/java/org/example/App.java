package org.example;

import org.example.daos.*;

import java.util.Scanner;

public class App {

    boolean run = true;

    Scanner scan = new Scanner(System.in);

    private MainDao<Student> studentDao;
    private MainDao<Teacher> teacherDao;
    private MainDao<Course> courseDao;
    private MainDao<Programme> programmeDao;

    private Student student;
    private Teacher teacher;
    private Course course;
    private Programme programme;

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

        while(run){
            printMenu();
            choice = verifyInteger("");
            mainMenu(choice);
        }
    }

    private void printMenu() {
        System.out.println("gör ditt val");
    }

    private void mainMenu(int menuChoice) {

        System.out.println("mainMenu-Test");

        switch(menuChoice) {
            case 1 -> studentMenu();
            case 2 -> courseMenu();
            case 3 -> teacherMenu();
            case 4 -> programmeMenu();
            default -> run = false;
        }
    }

    private void studentMenu() {

        System.out.println("studentmenu");
        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> studentDao.add(student.studentValuesInput());
            case 2 -> courseMenu();
            case 3 -> teacherMenu();
            case 4 -> programmeMenu();
            default -> run = false;
        }
    }

    private void courseMenu() {

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> studentMenu();
            case 2 -> courseMenu();
            case 3 -> teacherMenu();
            case 4 -> programmeMenu();
            default -> run = false;
        }
    }

    private void teacherMenu() {

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> studentMenu();
            case 2 -> courseMenu();
            case 3 -> teacherMenu();
            case 4 -> programmeMenu();
            default -> run = false;
        }
    }

    private void programmeMenu() {

        int menuChoice = Integer.parseInt(scan.nextLine());

        switch(menuChoice) {
            case 1 -> studentMenu();
            case 2 -> courseMenu();
            case 3 -> teacherMenu();
            case 4 -> programmeMenu();
            default -> run = false;
        }

    }

    String verifyString(String input) {
        System.out.println(input);

        while (scan.hasNextInt()) {
            System.out.println("Ej giltig input, försök igen");
            scan.next();
        }
        return scan.next();
    }

    int verifyInteger(String input) {
        System.out.println(input);

        while (!scan.hasNextInt()) {
            System.out.println("Ej giltig input, försök igen");
            scan.next();
        }
        return Integer.parseInt(scan.next());
    }
}