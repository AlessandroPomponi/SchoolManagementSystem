package org.yi;

import org.yi.dto.SchoolManagementSystem;

/**
 * Print Info
 *
 * @author Alessandro Pomponi
 */
public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem schoolSystem = new SchoolManagementSystem();

        schoolSystem.addDepartment("Computer Science");
        schoolSystem.addDepartment("Social Science");
        schoolSystem.addDepartment("Computer Technology");
        schoolSystem.addDepartment("Math");
        schoolSystem.addDepartment("Music");

        schoolSystem.addStudent("Alessandro", "Pomponi", "S001");
        schoolSystem.addStudent("Vanny", "Ruiz", "S002");

        schoolSystem.printStudents();

        schoolSystem.addTeacher("Exceed", "Limit", "T001");

        schoolSystem.printTeachers();

        schoolSystem.addCourse("Intro to programming", 3.0, "C001");

        schoolSystem.modifyCourseTeacher("T001", "C001");
        schoolSystem.modifyCourseTeacher("T007", "C007");
        schoolSystem.modifyCourseTeacher("T001", "C007");

        schoolSystem.registerCourse("S001", "C001");
        schoolSystem.registerCourse("S001", "C001"); // Trying to register the same course again
        schoolSystem.registerCourse("S001", "C002"); // Trying to register for a different course
        schoolSystem.registerCourse("S007", "C001"); // Trying to register with a non-existent student ID
        schoolSystem.registerCourse("S001", "C007"); // Trying to register with a non-existent course ID
        schoolSystem.registerCourse("S001", "C002"); // Registering for another course

    }
}