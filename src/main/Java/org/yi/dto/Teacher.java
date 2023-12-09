package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Information pertaining to teachers.
 *
 * @author Alessandro Pomponi
 */
@EqualsAndHashCode
@Getter
@Setter
public class Teacher {
    private String lname;
    private String fname;
    private Department department;
    private String id;
    private static int nextId = 1;

    public Teacher(String lname, String fname, Department department) {
        this.lname = lname;
        this.fname = fname;
        this.department = department;
        this.id = generateNextId();
    }

    public Teacher(String lname, String fname, Department department, String id) {
        this.lname = lname;
        this.fname = fname;
        this.department = department;
        this.id = id;
    }

    private String generateNextId() {
        return "T" + String.format("%03d", nextId++);
    }

    @Override
    public String toString() {
        return "Teacher{id='" + id + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", department=" + department +
                '}';
    }
}
