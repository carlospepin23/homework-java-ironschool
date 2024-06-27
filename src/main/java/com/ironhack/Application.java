package com.ironhack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    private Scanner scanner;
    private String schoolName;

    //MAPS
    private Map<String, Teacher> teacherMap;
    private Map<String, Course> courseMap;
    private Map<String, Student> studentMap;

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
        while (true) {
            this.schoolName = scanner.nextLine();
            if (!schoolName.matches("\\d+") && !schoolName.isEmpty()) { //checks if it has a number or is empty
                break;
            }
            System.out.println("Invalid input. The school name cannot be a number or an empty string. Please enter the name of the school: ");
        }
        System.out.println("The school "+schoolName+" has been created successfully.");
        System.out.println(); //empty line

        //create the maps
        ioMapManager(variableType.teacher);
        ioMapManager(variableType.course);
        ioMapManager(variableType.student);
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

    public void ioMapManager(variableType vType){
        while(true){
            System.out.println("How many "+vType+"s should be added to the system?: ");
            try {
                int number = Integer.parseInt(scanner.nextLine());

                if (number < 1) {
                    System.out.println("Invalid input. The number of "+ vType+" cannot be zero or less.");
                } else {
                    for(int i=0; i<number; i++) mapCreator(vType); //creates map

                    System.out.println(); //empty line
                    System.out.println("The "+ number+" "+vType+" have been added successfully.");
                    System.out.println(); //empty line
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear the scanner
            }
        }
    }

    public void mapCreator(variableType vType){
        String name = "";
        String address = "";
        String email = "";
        while (true) {
            System.out.println("Please enter the name of the new "+vType+": ");
            name = scanner.nextLine();
            if (!name.matches(".*\\d.*") && !name.isEmpty()) { //checks if it has a number or is empty
                break;
            }
            System.out.println("Invalid input. The name cannot contain numbers or be an empty string. Please enter the name again: ");
        }

        double value = 0;
        while (true) {
            try {
                if(vType.equals(variableType.teacher)){
                    System.out.println("Please enter the salary of "+name+": ");
                    value = Double.parseDouble(scanner.nextLine());
                    if (value < 1) {
                        throw new IllegalArgumentException("Invalid input. The salary cannot be less than 1. Please enter the salary again: ");
                    }

                }else if(vType.equals(variableType.course)){
                    System.out.println("Please enter the price of "+name+": ");
                    value = Double.parseDouble(scanner.nextLine());
                    if (value < 1) {
                        throw new IllegalArgumentException("Invalid input. The price cannot be less than 1. Please enter the price again: ");
                    }

                }else if(vType.equals(variableType.student)){
                    System.out.println("Please enter the address of "+name+": ");
                    address = scanner.nextLine();
                    System.out.println("Please enter the email of "+name+": ");
                    email = scanner.nextLine();

                    //email validation
                    if (!(email.contains("@") && ((email.endsWith(".edu") || email.endsWith(".org") || email.endsWith(".com"))))) {
                        throw new IllegalArgumentException("Invalid email format. Email must contain '@' and end with '.edu', '.org', or '.com'.");
                    }
                }

                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if(vType.equals(variableType.teacher)){
            Teacher teacher=new Teacher(name, value);
            teacherMap.put(teacher.getTeacherId(), teacher);

        }else if(vType.equals(variableType.course)){
            Course course=new Course(name, value);
            courseMap.put(course.getCourseId(), course);

        }else {
            Student student=new Student(name, address, email);
            studentMap.put(student.getStudentId(), student);
        }

    }

    public void displaySchoolInfo() {
        //for all the info put an emoji *look for them*
        System.out.println();
        System.out.println(schoolName+" Management System");
        System.out.println("====================================");
        System.out.println("Teachers: " + teacherMap.size());
        System.out.println("Courses: " + courseMap.size());
        System.out.println("Students: " + studentMap.size());
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

        //Useful info:
        //parts[0] will be the command
        //parts[1] will be the first argument (if any)
        //parts[2] will be the second argument (if any)

        Command command;
        try {
            command = Command.valueOf(parts[0].toUpperCase());
            //in the parts array will be the remaining parts of the command to use

            switch (command) {
                case ENROLL:
                    // Enroll student

                    break;
                case ASSIGN:
//                    courseMap.get(parts[1]).setTeacher(teacherMap.get(parts[2]));
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
