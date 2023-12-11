package org.yi;

import org.yi.dto.SchoolManagementSystem;

/**
 * Print Info
 *
 * @author Alessandro Pomponi
 */
public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem schoolSystem = new SchoolManagementSystem("Vanier College");

        schoolSystem.addDepartment("Computer Science");
        schoolSystem.addDepartment("Social Science");
        schoolSystem.addDepartment("Computer Technology");
        schoolSystem.addDepartment("Math");
        schoolSystem.addDepartment("Music");

        schoolSystem.printDepartments();

        schoolSystem.addStudent("Mike", "Conan", "S001");
        schoolSystem.addStudent("John", "Snow", "S002");

        schoolSystem.printStudents();

        schoolSystem.addTeacher("Yi", "Wang", "T001");

        schoolSystem.printTeachers();

        schoolSystem.addCourse("Intro to programming", 3.0, "C001");

        schoolSystem.modifyCourseTeacher("T001", "C001");
        schoolSystem.modifyCourseTeacher("T007", "C007");
        schoolSystem.modifyCourseTeacher("T001", "C007");

        schoolSystem.registerCourse("S001", "C001");
        schoolSystem.registerCourse("S001", "C001"); // Trying to register the same course again
        schoolSystem.registerCourse("S001", "C002"); // Trying to register for a different course
        schoolSystem.registerCourse("S007", "C001"); // Trying to register with a non-existent student id
        schoolSystem.registerCourse("S001", "C007"); // Trying to register with a non-existent course id
        schoolSystem.registerCourse("S001", "C002"); // Registering for another course
    }
}
