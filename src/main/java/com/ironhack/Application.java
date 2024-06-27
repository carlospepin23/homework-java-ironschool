package com.ironhack;

import java.util.Collection;
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
        manageIOMap(variableType.teacher);
        manageIOMap(variableType.course);
        manageIOMap(variableType.student);
    }

    public void schoolManagementSystem() {

        while (!exit) {
            displaySchoolInfo();
            displayCommandInfo();

            String input=scanner.nextLine();
            commandManager(input);
        }
        System.out.println("Thank you for using the "+schoolName+" management system. Goodbye!");
    }

    public void manageIOMap(variableType vType){
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

    private void displaySchoolInfo() {

        System.out.println();
        System.out.println(schoolName+" Management System");
        System.out.println("====================================");
        System.out.println("Teachers: " + teacherMap.size());
        System.out.println("Courses: " + courseMap.size());
        System.out.println("Students: " + studentMap.size());
        System.out.println(); //empty line
    }

    private void displayCommandInfo() {
        System.out.println("Please enter a command from the list below: ");
        System.out.println();
        System.out.println("ENROLL [STUDENT_ID] [COURSE_ID] : Enroll student");
        System.out.println("ASSIGN [TEACHER_ID] [COURSE_ID]: Assign teacher");
        System.out.println("SHOW_COURSES: Show courses");
        System.out.println("LOOKUP_COURSE [COURSE_ID]: Lookup course");
        System.out.println("SHOW_STUDENTS: Show students");
        System.out.println("LOOKUP_STUDENT [STUDENT_ID]: Lookup student");
        System.out.println("SHOW_TEACHERS: Show teachers");
        System.out.println("LOOKUP_TEACHER [TEACHER_ID]: Lookup teacher");
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
                    enroll(parts[1],parts[2]);
                    break;
                case ASSIGN:
                   assign(parts[1],parts[2]);
                    break;
                case SHOW_COURSES:
                   showCourses();
                    break;
                case LOOKUP_COURSE:
                    lookUpCourse(parts[1]);
                    break;
                case SHOW_STUDENTS:
                    showStudents();
                    break;
                case LOOKUP_STUDENT:
                    lookUpStudents(parts[1]);
                    break;
                case SHOW_TEACHERS:
                    showTeachers();
                    break;
                case LOOKUP_TEACHER:
                    lookUpTeacher(parts[1]);
                    break;
                case SHOW_PROFIT:
                    showProfit();
                    break;
                case EXIT:
                    exit = true;
                    break;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid command. Please try again.");
        }

    }

    public void enroll(String studentId, String courseId){
        Student foundStudent = null;
        Course foundCourse = null;
        for (String stuId : studentMap.keySet()) {
            if (stuId.equalsIgnoreCase(studentId)) {
                foundStudent = studentMap.get(stuId);
                break;
            }
        }
        for (String couId : courseMap.keySet()) {
            if (couId.equalsIgnoreCase(courseId)) {
                foundCourse = courseMap.get(couId);
                break;
            }
        }
        if (foundStudent != null && foundCourse != null) {
            foundStudent.setCourse(foundCourse);
            System.out.println("Student " + foundStudent.getName() + " has been enrolled in course " + foundCourse.getName() + ".");
        } else {
            System.out.println("Either the student or the course was not found.");
        }
    }

    public void assign(String teacherId, String courseId){
        Teacher foundTeacher = null;
        Course foundCourse = null;
        for (String teaId : teacherMap.keySet()) {
            if (teaId.equalsIgnoreCase(teacherId)) {
                foundTeacher = teacherMap.get(teaId);
                break;
            }
        }
        for (String couId : courseMap.keySet()) {
            if (couId.equalsIgnoreCase(courseId)) {
                foundCourse = courseMap.get(couId);
                break;
            }
        }
        if (foundTeacher != null && foundCourse != null) {
            foundCourse.setTeacher(foundTeacher);
            System.out.println("Teacher " + foundTeacher.getName() + " has been assigned to course " + foundCourse.getName() + ".");
        } else {
            System.out.println("Either the teacher or the course was not found.");
        }
    }

    public void showCourses(){
        for (Course course : courseMap.values()) {
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Course Name: " + course.getName());
            System.out.println("Price: $" + course.getPrice());
            System.out.println("Teacher: " + (course.getTeacher() != null ? course.getTeacher().getName() : "N/A"));
            System.out.println("------------------------");
        }
    }

    public void lookUpCourse(String courseId){
        boolean found = false;
        for (String couId : courseMap.keySet()) {
            if (couId.equalsIgnoreCase(courseId)) {
                Course course = courseMap.get(couId);
                System.out.println("Name: " + course.getName());
                System.out.println("Price: $" + course.getPrice());
                System.out.println("Teacher: " + (course.getTeacher() != null ? course.getTeacher().getName() : "N/A"));
                System.out.println("------------------------");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No course found with the provided name.");
        }
    }

    public void showStudents(){
        for (Student student : studentMap.values()) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Email: " + student.getEmail());
            System.out.printf("Course(s): %s%n", student.getCourse() != null ? student.getCourse().getName() : "N/A");
            System.out.println("------------------------");
        }
    }

    public void lookUpStudents(String studentId){
        boolean found = false;
        for (String stuId : studentMap.keySet()) {
            if (stuId.equalsIgnoreCase(studentId)) {
                Student student = studentMap.get(stuId);
                System.out.println("Name: " + student.getName());
                System.out.println("Address: " + student.getAddress());
                System.out.println("Email: " + student.getEmail());
                System.out.printf("Course(s): %s%n", student.getCourse() != null ? student.getCourse().getName() : "N/A");
                System.out.println("------------------------");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No teacher found with the provided name.");
        }
    }

    public void showTeachers(){
        for(Teacher teacher : teacherMap.values()){
            System.out.println("Teacher ID: " + teacher.getTeacherId());
            System.out.println("Name: " + teacher.getName());
            System.out.println("Salary: $" + teacher.getSalary());
            System.out.println("------------------------");
        }
    }

    public void lookUpTeacher(String teacherId){
        boolean found = false;
        for (String teaId : teacherMap.keySet()) {
            if (teaId.equalsIgnoreCase(teacherId)) {
                Teacher teacher = teacherMap.get(teaId);
                System.out.println("Name: " + teacher.getName());
                System.out.println("Salary: $" + teacher.getSalary());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No teacher found with the provided name.");
        }
    }

    public void showProfit(){
        Collection<Course> courses=courseMap.values();
        Collection<Teacher> teachers=teacherMap.values();
        double profit=0;
        for(Course course:courses){
            profit+=course.getPrice();
        }
        for(Teacher teacher:teachers){
            profit-=teacher.getSalary();
        }
        System.out.println("The profit of the school is: "+profit);
        System.out.println("------------------------");
    }

    public String getSchoolName() {
        return schoolName;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public Map<String, Course> getCourseMap() {
        return courseMap;
    }

    public Map<String, Student> getStudentMap() {
        return studentMap;
    }
}
