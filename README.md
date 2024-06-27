![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# HW | Java IronSchool (Unit 2 homework)

## Introduction

For this homework, you will be building a School Management System, that will help manage students, teachers and courses with some basic functionalities.

## Instructions

Let's walk through the details of the homework:

### Classes

Three main classes are necessary to complete this homework: **Teacher**, **Student** and **Course**.

<br>

**Teacher class**

This class will have:

- Variable called `teacherId` of data type `string`, auto-generated (Private member)
- Variable called `name` of data type `string` (Private member)
- Variable called `salary` of data type `double`, representing the salary of the teacher (Private member)
- A parameterized constructor that takes `name` and `salary`
- Public Getter functions to access these variables
- Public Setter functions to change these variables
- Optional attributes are accepted if needed based on the code structure

<br>

**Course class**

This class will have:

- Variable called `courseId` of data type `string`, auto-generated (Private member)
- Variable called `name` of data type `string` (Private member)
- Variable called `price` of data type `double`, representing the price of this course (Private member)
- Variable called `money_earned` of data type `double`, representing the total money earned by this course (Private member)
- Nullable variable called `teacher` of data type `Teacher` (Private member)
- A parameterized constructor that takes `name` and `price`
- Public Getter functions to access these variables
- Public Setter functions to change these variables
- Optional attributes are accepted if needed based on the code structure

<br>

**Student class**

This class will have:

- Variable called `studentId` of data type `string`, auto-generated (Private member)
- Variable called `name` of data type `string` (Private member)
- Variable called `address` of data type `string` (Private member)
- Variable called `email` of data type `string` (Private member)
- Nullable variable called `course` of data type `Course`, representing the course this student is enrolled into (Private member)
- A parameterized constructor that takes `name`, `address` and `email`
- Public Getter functions to access these variables
- Public Setter functions to change these variables
- Optional attributes are accepted if needed based on the code structure

## How the application works

1. The application starts by asking the user for a name for the school
2. Next, the user is asked for a number of how many teachers should be created
3. Next, the user is prompted to enter the details of each teacher (based on the number chosen above)
4. Next, the user is asked for the number of courses to be created (Do not specify the teacher yet, there is a command for it)
5. Next, the user is prompted to enter details of each course based on the number chosen above
6. Next, the user is asked for the number of students to be created (Do not specify the course yet, there is a command for it)
7. Next, the user is prompted to enter details of each student based on the number chosen above
8. Next, the user is now prompted to enter any command of the list below to execute a specified action in the system.

The IDs should be automatically generated.

## Commands

- **ENROLL** **[STUDENT_ID] [COURSE_ID]**: This command will help enroll the student specified in the corresponding course. While also updating the `money_earned` of that course based on its price
- **ASSIGN** **[TEACHER_ID] [COURSE_ID]**: This command will help assign the teacher specified to the corresponding course
- **SHOW COURSES**: This command will display a list of all courses
- **LOOKUP COURSE** **[COURSE_ID]**: This command will display the full details of the specified course
- **SHOW STUDENTS**: This command will display a list of all students
- **LOOKUP STUDENT** **[STUDENT_ID]**: This command will display the full details of the specified student
- **SHOW TEACHERS**: This command will display a list of all teachers
- **LOOKUP TEACHER** **[TEACHER_ID]**: This command will display the full details of the specified teacher
- **SHOW PROFIT**: This command will calculate **(The total money earned from all courses)** - **(The sum of all the teachers' salaries)** and return the result

## Requirements

For this project you must accomplish all of the following:

1.  Navigate through a text-based menu using Standard Input and Output.
2.  Create unit tests for every method other than basic getters, setters and constructors (getters and setters with logic do require unit tests).
3.  Handle all exceptions gracefully (incorrect input should not crash the program).
4.  Create Teachers, Courses and Students specifying their full details.
5.  Handle receiving commands in the Standard Input that corresponds to actual actions in the system.

### Bonus

1. Add more commands that can help display more information such as (**SHOW STUDENTS** **[COURSE_ID]**, **SHOW MONEY EARNED**, **SHOW MONEY SPENT**, etc.)

## Important Notes

- Everyone in the squad should contribute equally to the project in time and lines of code written.
- All code must be reviewed before it is merged into the `master` branch.
- All squad members must participate in code review.
- Every repository should have a README file with clear instructions, demo files, or any documentation needed so other teams don't have problems with the review.
- This is intended to be a challenging assignment. You will have to rely heavily on your teammates and independent research. Learning independently is a hallmark of a good developer and our job is to turn you into good developers. This process may be frustrating but you will learn a ton!