package org.yi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Information pertaining to the school system.
 *
 * @author Alessandro Pomponi
 */
@EqualsAndHashCode
@Setter
@Getter
@ToString
public class SchoolManagementSystem {
    private static final int MAX_DEPARTMENT_NUM = 5;
    private static final int MAX_STUDENT_NUM = 200;
    private static final int MAX_STUDENT_COURSE_REGISTRATION = 5;
    private static final int MAX_TEACHER_NUM = 20;
    private static final int MAX_COURSE_NUM = 30;
    private static final int MAX_REGISTRATION_NUM = 5;
    public SchoolManagementSystem(String ) {

    }
    public Department findDepartment(String departmentName) {

    }

    public void printTeachers() {

    }

    public void modifyCourseTeacher(String courseName, String id) {

    }

    public void addDepartment(String departmentName) {

    }

    public void printStudents(String id) {

    }

    public Student findStudent(String id) {

    }

    public void addCourse(String, ) {

    }

    public void registerCourse() {

    }

    public void addTeacher() {

    }

    public Course findCourse() {

    }

    public void printDepartment() {

    }

    public void addStudent() {

    }

    public Teacher findTeahcer() {

    }
}
