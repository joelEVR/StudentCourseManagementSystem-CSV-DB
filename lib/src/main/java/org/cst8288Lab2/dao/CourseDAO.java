package org.cst8288Lab2.dao;

import java.util.List;

import org.cst8288Lab2.dto.CourseDTO;


 /* Interface defining the operations for interacting with course data in the database.
 * Provides the blueprint for CRUD (Create, Read, Update, Delete) operations on courses,
 * ensuring that any implementing class will support these essential database operations.
 * This allows for flexibility in changing or extending the way course data is managed
 * without affecting the rest of the application.
 */
public interface CourseDAO {
    /**
     * Retrieves all courses from the database.
     * 
     * @return A list of all courses as CourseDTO objects.
     */
    List<CourseDTO> getAllCourses();

    /**
     * Retrieves a specific course by its ID.
     * 
     * @param courseId The unique identifier for the course.
     * @return The CourseDTO object if found, null otherwise.
     */
    CourseDTO getCourseById(String courseId);

    /**
     * Inserts a new course into the database.
     * 
     * @param course The CourseDTO object representing the new course.
     */
    void insertCourse(CourseDTO course);

    /**
     * Updates an existing course in the database.
     * 
     * @param course The CourseDTO object containing the updated course data.
     */
    void updateCourse(CourseDTO course);

    /**
     * Deletes a course from the database.
     * 
     * @param course The CourseDTO object representing the course to be deleted.
     */
    void deleteCourse(CourseDTO course);
}
