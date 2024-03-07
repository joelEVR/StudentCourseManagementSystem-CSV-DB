package org.cst8288Lab2.logic;

import org.cst8288Lab2.dto.CourseDTO;
import org.cst8288Lab2.dto.StudentCourseDTO;
import org.cst8288Lab2.dto.StudentDTO;

/**
 * Provides validation methods for Student, Course, and StudentCourse DTOs.
 * This class ensures that the data meets certain criteria (not null) before it is processed or persisted.
 */
public class ValidatorDTO {

    /**
     * Validates the provided StudentDTO object.
     *
     * @param student The StudentDTO to validate.
     * @throws ValidationException If the validation fails.
     */
    protected void validateStudent(StudentDTO student) throws ValidationException {
        if (student == null) {
            throw new ValidationException("The student object cannot be null.");
        }
    }

    /**
     * Validates the provided CourseDTO object.
     *
     * @param course The CourseDTO to validate.
     * @throws ValidationException If the validation fails.
     */
    protected void validateCourse(CourseDTO course) throws ValidationException {
        if (course == null) {
            throw new ValidationException("The course object cannot be null.");
        }
    }

    /**
     * Validates the provided StudentCourseDTO object.
     *
     * @param studentCourse The StudentCourseDTO to validate.
     * @throws ValidationException If the validation fails.
     */
    protected void validateStudentCourse(StudentCourseDTO studentCourse) throws ValidationException {
        if (studentCourse == null) {
            throw new ValidationException("The student course object cannot be null.");
        }
    }
}
