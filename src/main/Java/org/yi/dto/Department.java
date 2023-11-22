package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Department {
    private String id;
    private int nextId;
    private String departmentName;

    @Override
    public String toString() {

    }
}
