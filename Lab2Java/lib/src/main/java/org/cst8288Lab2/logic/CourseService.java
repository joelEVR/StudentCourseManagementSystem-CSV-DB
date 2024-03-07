package org.cst8288Lab2.logic;

import java.util.List;

import org.cst8288Lab2.dao.CourseDAO;
import org.cst8288Lab2.dao.CourseDAOImpl;
import org.cst8288Lab2.dto.CourseDTO;

/**
 * Service layer class that handles business logic for course operations.
 * It interacts with the CourseDAO to perform CRUD operations and validates data before passing it to the DAO layer.
 */
public class CourseService {

    private CourseDAO courseDAO;
    private ValidatorDTO validator;

    /**
     * Constructs a CourseService instance, initializing the DAO and validator.
     */
    public CourseService() {
        courseDAO = new CourseDAOImpl();
        validator = new ValidatorDTO();
    }

    /**
     * Retrieves a course by its ID.
     *
     * @param courseId The ID of the course to retrieve.
     * @return A CourseDTO object if found, null otherwise.
     */
    public CourseDTO getCourse(String courseId) {
        return courseDAO.getCourseById(courseId);
    }

    /**
     * Retrieves all courses from the database.
     *
     * @return A list of CourseDTO objects.
     */
    public List<CourseDTO> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    /**
     * Adds a new course to the database after validation.
     *
     * @param course The CourseDTO object to add.
     * @throws ValidationException If the course data fails validation.
     */
    public void addCourse(CourseDTO course) throws ValidationException {
        validator.validateCourse(course);
        courseDAO.insertCourse(course);
    }

    /**
     * Updates an existing course in the database.
     *
     * @param course The CourseDTO object to update.
     * @throws ValidationException If the course data fails validation.
     */
    public void updateCourse(CourseDTO course) throws ValidationException {
        validator.validateCourse(course);
        courseDAO.updateCourse(course);
    }

    /**
     * Deletes a course from the database.
     *
     * @param course The CourseDTO object to delete.
     * @throws ValidationException If the course data fails validation.
     */
    public void deleteCourse(CourseDTO course) throws ValidationException {
        validator.validateCourse(course);
        courseDAO.deleteCourse(course);
    }
}
