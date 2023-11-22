package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Teacher {
    private String lname;
    private String fname;
    private Department department;
    private String id;

    @Override
    public String toString() {

    }
}
