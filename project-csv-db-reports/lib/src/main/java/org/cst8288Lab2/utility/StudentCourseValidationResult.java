package org.cst8288Lab2.utility;


/**
 * A helper class to represent a student-course relationship.
 */
public class StudentCourseValidationResult  {

    public int studentId;
    public String firstName;
    public String lastName;
    public String courseId;
    public String courseName;
    public int term;
    public int year;

    public StudentCourseValidationResult(int studentId, String firstName, String lastName, String courseId, String courseName, int term, int year) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.term = term;
        this.year = year;
    }
}
