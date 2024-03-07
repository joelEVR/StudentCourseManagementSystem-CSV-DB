package org.cst8288Lab2.dto;

/**
 * Data Transfer Object (DTO) class for student-course relationship.
 * This class is used to transfer the association data between student and course layers without exposing the database directly.
 */
public class StudentCourseDTO {
    private Integer studentId;
    private String courseId;
    private Integer term;
    private Integer year;

    /**
     * Gets the student ID.
     *
     * @return An Integer representing the student ID.
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID.
     *
     * @param studentId An Integer representing the student ID.
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the course ID.
     *
     * @return A String representing the course ID.
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Sets the course ID.
     *
     * @param courseId A String representing the course ID.
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the term in which the student is enrolled in the course.
     *
     * @return An Integer representing the term.
     */
    public Integer getTerm() {
        return term;
    }

    /**
     * Sets the term in which the student is enrolled in the course.
     *
     * @param term An Integer representing the term.
     */
    public void setTerm(Integer term) {
        this.term = term;
    }

    /**
     * Gets the year in which the student is enrolled in the course.
     *
     * @return An Integer representing the year.
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the year in which the student is enrolled in the course.
     *
     * @param year An Integer representing the year.
     */
    public void setYear(Integer year) {
        this.year = year;
    }
}