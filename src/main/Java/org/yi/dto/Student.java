package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

    @Override
    public String toString() {

    }
}
