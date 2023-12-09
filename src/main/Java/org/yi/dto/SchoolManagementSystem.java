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
    private Department[] departments;
    private int departmentCount;
    private static final int MAX_STUDENT_NUM = 200;
    private Student[] students;
    private int studentCount;
    private static final int MAX_STUDENT_COURSE_REGISTRATION = 5;
    private static final int MAX_TEACHER_NUM = 20;
    private Teacher[] teachers;
    private int teacherCount;
    private static final int MAX_COURSE_NUM = 30;
    private Course[] courses;
    private int courseCount;
    private static final int MAX_COURSE_STUDENT_NUM = 5;

    public SchoolManagementSystem() {
        this.departments = new Department[MAX_DEPARTMENT_NUM];
        this.departmentCount = 0;
        this.students = new Student[MAX_STUDENT_NUM];
        this.studentCount = 0;
        this.teachers = new Teacher[MAX_TEACHER_NUM];
        this.teacherCount = 0;
        this.courses = new Course[MAX_COURSE_NUM];
        this.courseCount = 0;
    }

    /**
     * The method searches for a department in the departments based on the id.
     * @param id department id
     * @return a department or null if the id does not match with anything
     */
    public Department findDepartment(String id) {
        for (int i = 0; i < departmentCount; i++) {
            if (departments[i].getId().equals(id)) {
                return departments[i];
            }
        }
        return null;
    }

    /**
     * The method displays all teachers in a school, only display the teacher that is not null. And only display
     * the names of course and department if there is any.
     */
    public void printTeachers() {
        System.out.println("Teachers:");
        for (int i = 0; i < teacherCount; i++) {
            System.out.println(teachers[i]);
        }
    }

    /**
     * The method assigns a teacher to a specific course, based on teacherId and courseId, if no teacher or
     * course can be found with those ids, print a message.
     * @param teacherId teacher id
     * @param courseId course id
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {
        Teacher teacher = findTeacher(teacherId);
        Course course = findCourse(courseId);

        if (teacher != null && course != null) {
            course.setTeacher(teacher);
            System.out.println("Course " + course + " teacher info updated successfully.");
        } else {
            if (course == null) {
                System.out.println("Cannot find any course match with courseId " + courseId +
                        ", modify teacher for course " + courseId + " failed.");
            }
            if (teacher == null) {
                System.out.println("Cannot find any teacher match with teacherId " + teacherId +
                        ", modify teacher for course " + courseId + " failed.");
            }
        }
    }

    /**
     * The method add a new department to the list of departments.
     * @param departmentName
     */
    public void addDepartment(String departmentName) {
        if (departmentCount < MAX_DEPARTMENT_NUM) {
            Department department = new Department(departmentName);
            departments[departmentCount] = department;
            departmentCount++;
            System.out.println("Department " + department);
        } else {
            System.out.println("Cannot add department. Limit of " + MAX_DEPARTMENT_NUM + " departments reached.");
        }
    }

    /**
     * The method displays all students in a school. It will only display the student that is not null and only display
     * the names of courses and department if there is any.
     */
    public void printStudents() {
        System.out.println("Students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }

    /**
     * The method searches for a student in the students based on a studentId.
     * @param id student id
     * @return a student or null if the studentId does not match with anything in the students
     */
    public Student findStudent(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    /**
     * The method adds a new course to the list of courses in the system.
     * @param courseName the course's name
     * @param credits the amount of credits the course has
     * @param id department id
     */
    public void addCourse(String courseName, double credits, String id) {
        if (courseCount < MAX_COURSE_NUM) {
            Department department = new Department("Computer Science"); // Assuming a default department
            Course course = new Course(credits, department, null, courseName);
            courses[courseCount] = course;
            courseCount++;
            System.out.println("Course " + course + " added successfully.");
        } else {
            System.out.println("Cannot add course. Maximum course limit reached.");
        }
    }

    /**
     * The method registers a course for a student, based on studentId and courseId, which will check
     * if the studentId or courseId does not match with anything, print a message.
     * If the student has register max amount courses (5), print a message.
     * If the course has be registered by the max number of students (5), print a message.
     * If the course has be registered by the student already, it cannot be registered again, print a message.
     * Else add the course to the student’s registered courses array, and also add the student to
     * the course’s registered students array.
     * @param studentId the student id
     * @param courseId the course id
     */
    public void registerCourse(String studentId, String courseId) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);

        if (student != null && course != null) {
            if (student.getCourseNum() < MAX_STUDENT_COURSE_REGISTRATION) {
                if (course.getStudentNum() < MAX_COURSE_STUDENT_NUM) {
                    boolean alreadyRegistered = false;

                    for (int i = 0; i < student.getCourseNum(); i++) {
                        if (student.getCourses()[i].getId().equals(course.getId())) {
                            alreadyRegistered = true;
                            break;
                        }
                    }

                    if (!alreadyRegistered) {
                        student.getCourses()[student.getCourseNum()] = course;
                        student.setCourseNum(student.getCourseNum() + 1);

                        course.getStudents()[course.getStudentNum()] = student;
                        course.setStudentNum(course.getStudentNum() + 1);

                        System.out.println("Student register course successfully");
                        System.out.println("Latest student info: " + student);
                        System.out.println("Latest course info: " + course);
                    } else {
                        System.out.println("Student " + student.getId() + " has already registered Course " + course.getId() +
                                ", register course " + course.getId() + " for student " + student.getId() + " failed.");
                    }
                } else {
                    System.out.println("Course " + course.getId() + " has been fully registered, register course " + course.getId() +
                            " for student " + student.getId() + " failed.");
                }
            } else {
                System.out.println("Student " + student.getId() + " has already registered " + MAX_STUDENT_COURSE_REGISTRATION +
                        " courses, register course for student " + student.getId() + " failed.");
            }
        } else {
            if (student == null) {
                System.out.println("Cannot find any student match with studentId " + studentId +
                        ", register course for student " + studentId + " failed.");
            }
            if (course == null) {
                System.out.println("Cannot find any course match with courseId " + courseId +
                        ", register course for student " + studentId + " failed.");
            }
        }
    }

    /**
     * The method adds a new teacher to the list of teachers in the system.
     * @param fname teacher's first name
     * @param lname teacher's last name
     * @param id teacher's if
     */
    public void addTeacher(String fname, String lname, String id) {
        if (teacherCount < MAX_TEACHER_NUM) {
            Department department = new Department("Computer Science"); // Assuming a default department
            Teacher teacher = new Teacher(lname, fname, department, id);
            teachers[teacherCount] = teacher;
            teacherCount++;
            System.out.println("Teacher " + teacher + " added successfully.");
        } else {
            System.out.println("Cannot add teacher. Maximum teacher limit reached.");
        }
    }

    /**
     * The method searches for a course in the system based on a course's id.
     * @param id course id
     * @return a course or null if the courseId does not match with anything in the courses
     */
    public Course findCourse(String id) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Display all departments in a school, only display the department that is not null.
     */
    public void printDepartments() {
        System.out.println("Departments:");
        for (int i = 0; i < departmentCount; i++) {
            System.out.println(departments[i]);
        }
    }

    /**
     * The method adds a new student to the list of students in the system.
     * @param fname student's first name
     * @param lname student's last name
     * @param id student's id
     */
    public void addStudent(String fname, String lname, String id) {
        if (studentCount < MAX_STUDENT_NUM) {
            Department department = new Department("Computer Science"); // Assuming a default department
            Student student = new Student(id, fname, lname, department);
            students[studentCount] = student;
            studentCount++;
            System.out.println("Student " + student + " added successfully.");
        } else {
            System.out.println("Cannot add student. Maximum student limit reached.");
        }
    }

    /**
     * The method searches for a teacher in the system based on the id.
     * @param id teacher id
     * @returna a teacher or null if the teacherId does not match with anything in the teachers
     */
    public Teacher findTeacher(String id) {
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getId().equals(id)) {
                return teachers[i];
            }
        }
        return null;
    }

    /**
     * Display all courses in the school, only display the course that is not null.
     */
    public void printCourses() {
        System.out.println("Courses:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i]);
        }
    }
}
