package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Information pertaining to courses.
 *
 * @author Alessandro Pomponi
 */
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private double credit;
    private String id;
    private Student[] students;
    private Department department;
    private int studentNum;
    private Teacher teacher;
    private String courseName;
    private static int nextId = 1;
    private static final int MAX_COURSE_STUDENT_NUM = 5;

    public Course(double credit, Department department, Teacher teacher, String courseName) {
        this.credit = credit;
        this.id = generateNextId();
        this.students = new Student[MAX_COURSE_STUDENT_NUM];
        this.department = department;
        this.teacher = teacher;
        this.courseName = courseName;
        this.studentNum = 0;
    }

    public Course(String courseName, double credit, Department department) {
        this.credit = credit;
        this.id = generateNextId();
        this.students = new Student[MAX_COURSE_STUDENT_NUM];
        this.department = department;
        this.teacher = null;
        this.courseName = courseName;
        this.studentNum = 0;
    }

    private static String generateNextId() {
        return "C" + String.format("%03d", nextId++);
    }
}
