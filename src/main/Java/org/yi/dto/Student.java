package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Information pertaining to students.
 *
 * @author Alessandro Pomponi
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Student {
    private String fname;
    private Course[] courses;
    private String id;
    private int courseNum;
    private static int nextId = 1;
    private String lname;
    private Department department;

    public Student(String fname, String lname, Department department) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.id = String.format("S%01", nextId++);
    }
}
