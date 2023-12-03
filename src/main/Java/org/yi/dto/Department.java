package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Information pertaining to departments.
 *
 * @author Alessandro Pomponi
 */
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Department {
    private String id;
    private static int nextId = 1;
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.id = generateNextId();
    }

    private static String generateNextId() {
        return "D" + String.format("%03d", nextId++);
    }
}
