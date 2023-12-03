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
    }
}