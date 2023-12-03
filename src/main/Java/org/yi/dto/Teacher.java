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
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Teacher {
    private String lname;
    private String fname;
    private Department department;
    private String id;
    private static int nextId = 1;

    public Teacher(String fname, String lname, Department department) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.id = String.format("T%01", nextId++);
    }
}
