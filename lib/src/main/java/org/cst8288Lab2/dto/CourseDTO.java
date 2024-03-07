package org.cst8288Lab2.dto;

/**
 * Data Transfer Object (DTO) class for course information.
 * This class is used to transfer course data between layers without exposing the database directly.
 */
public class CourseDTO {
    private String courseId;
    private String courseName;

    /**
     * Default constructor for creating a new CourseDTO instance.
     */
    public CourseDTO() {
    }

    /**
     * Gets the course ID.
     *
     * @return A string representing the course ID.
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Sets the course ID.
     *
     * @param courseId A string representing the course ID.
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the course name.
     *
     * @return A string representing the course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name.
     *
     * @param courseName A string representing the course name.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
