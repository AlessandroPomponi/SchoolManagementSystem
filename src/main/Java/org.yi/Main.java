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
    }
}