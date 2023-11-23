package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Information pertaining to departments.
 *
 * @author Alessandro Pomponi
 */
@EqualsAndHashCode
@Getter
@Setter
public class Department {
    private String id;
    private int nextId;
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.id = String.format("D%01", nextId++);
    }

    @Override
    public String toString() {

    }
}
