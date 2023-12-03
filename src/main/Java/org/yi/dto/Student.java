package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

/**
 * Information pertaining to students.
 *
 * @author Alessandro Pomponi
 */
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String fname;
    private String lname;
    private Course[] courses;
    private String id;
    private int courseNum;
    private static int nextId = 1;
    private Department department;

    public Student(String fname, String lname, Course[] courses, Department department) {
        this.id = generateNextId();
        this.fname = fname;
        this.lname = lname;
        this.courses = courses;
        this.courseNum = courses.length;
        this.department = department;
    }

    public Student(String fname, String lname, Department department) {
        this.id = generateNextId();
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.courses = new Course[0];
        this.courseNum = 0;
    }

    private static String generateNextId() {
        return "S" + String.format("%03d", nextId++);
    }
}
