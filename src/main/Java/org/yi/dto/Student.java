package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Information pertaining to students.
 *
 * @author Alessandro Pomponi
 */
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String fname;
    private Course[] courses;
    private String id;
    private int courseNum;
    private int nextId;
    private String lname;
    private Department department;

    public void Student(int nextId, String name, String fname, int courseNum, Department department, Course[] courses, String lname, String id) {
        this.nextId = nextId;
        this.name = fname + " " + lname;
        this.fname = fname;
        this.courseNum = courseNum;
        this.department = department;
        this.courses = courses;
        this.lname = lname;
        this.id = String.format("S%01", nextId++);
    }
    @Override
    public String toString() {
    }
}
