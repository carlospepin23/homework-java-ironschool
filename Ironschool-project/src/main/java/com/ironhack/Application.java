package com.ironhack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    private Scanner scanner;
    private String schoolName;

    //MAPS
    private Map<String, Course> teacherMap; //change later for teacher class
    private Map<String, Course> courseMap;
    private Map<String, Course> studentMap; //change later for student class

    private boolean exit = false; //can be implemented other way so it is nice

    //CONSTRUCTOR
    Application(){
        //properties
        this.scanner=new Scanner(System.in);
        teacherMap=new HashMap<>();
        courseMap=new HashMap<>();
        studentMap=new HashMap<>();

        initialization();
        schoolManagementSystem();
    }

    public void initialization(){

        System.out.println("Welcome to the school management system. Please enter the name of the school: ");
        this.schoolName=scanner.nextLine();
        System.out.println("The school "+schoolName+" has been created successfully.");

        System.out.println(); //empty line
        System.out.println("How many teachers should be added to the system?: ");
        int numberOfTeachers=scanner.nextInt();

        for(int i=0; i<numberOfTeachers; i++){
            teacherCreator();
        }
        System.out.println(); //empty line
        System.out.println("The "+ numberOfTeachers+" teachers have been added successfully.");

        System.out.println(); //empty line
        System.out.println("How many courses should be added to the system?: ");
        int numberOfCourses=scanner.nextInt();

        for(int i=0; i<numberOfCourses; i++){
            courseCreator();
        }
        System.out.println(); //empty line
        System.out.println("The "+ numberOfCourses+" courses have been added successfully.");

        System.out.println(); //empty line
        System.out.println("How many students should be added to the system?: ");
        int numberOfStudents=scanner.nextInt();

        for(int i=0; i<numberOfStudents; i++){
            studentCreator();
        }
        System.out.println(); //empty line
        System.out.println("The "+ numberOfStudents+" students have been added successfully.");

        System.out.println(); //empty line

    }

    public void schoolManagementSystem() {

        while (!exit) {
            displaySchoolInfo();
            displayCommandInfo();

            String input=scanner.nextLine();
            commandManager(input);
        }
        System.out.println("Thank you for using the school management system. Goodbye!");
    }

    public void teacherCreator() {
//        fill

    }

    public void courseCreator() {
//        fill
    }

    public void studentCreator() {
//        fill
    }

    public void displaySchoolInfo() {
        //for all the info put an emoji *look for them*
        System.out.println();
        System.out.println(schoolName+" Management System");
        System.out.println("====================================");
        System.out.println("Teachers: " + teacherMap.size()); //change for actual size
        System.out.println("Courses: " + courseMap.size());
        System.out.println("Students: " + studentMap.size()); //change for actual size
        System.out.println(); //empty line
    }

    public void displayCommandInfo() {
        System.out.println("Please enter a command from the list below: ");
        System.out.println();
        System.out.println("ENROLL: Enroll student");
        System.out.println("ASSIGN: Assign teacher");
        System.out.println("SHOW_COURSES: Show courses");
        System.out.println("LOOKUP_COURSE: Lookup course");
        System.out.println("SHOW_STUDENTS: Show students");
        System.out.println("LOOKUP_STUDENT: Lookup student");
        System.out.println("SHOW_TEACHERS: Show teachers");
        System.out.println("LOOKUP_TEACHER: Lookup teacher");
        System.out.println("SHOW_PROFIT: Show profit");
        System.out.println("EXIT: Exit the program");
        System.out.println(); //empty line

    }

    public void commandManager(String input){
        String[] parts = input.split(" ");
        Command command;
        try {
            command = Command.valueOf(parts[0].toUpperCase());
            //in the parts array will be the remaining parts of the command to use

            switch (command) {
                case ENROLL:
                    // Enroll student
                    System.out.println("working test"); //to be sure it works

                    break;
                case ASSIGN:
                    // Assign teacher
                    break;
                case SHOW_COURSES:
                    // Show courses
                    break;
                case LOOKUP_COURSE:
                    // Lookup course
                    break;
                case SHOW_STUDENTS:
                    // Show students
                    break;
                case LOOKUP_STUDENT:
                    // Lookup student
                    break;
                case SHOW_TEACHERS:
                    // Show teachers
                    break;
                case LOOKUP_TEACHER:
                    // Lookup teacher
                    break;
                case SHOW_PROFIT:
                    // Show profit
                    break;
                case EXIT:
                    exit = true;
                    break;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid command. Please try again.");
        }

    }
}
