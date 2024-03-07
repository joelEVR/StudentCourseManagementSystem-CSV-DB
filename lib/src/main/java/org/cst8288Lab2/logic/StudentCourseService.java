package org.cst8288Lab2.logic;

import java.util.List;

import org.cst8288Lab2.dao.StudentCourseDAO;
import org.cst8288Lab2.dao.StudentCourseDAOImpl;
import org.cst8288Lab2.dto.StudentCourseDTO;

/**
 * Service layer class that handles business logic for student course operations.
 * It interacts with the StudentCourseDAO to perform CRUD operations and validates data before passing it to the DAO layer.
 */
public class StudentCourseService {

    private StudentCourseDAO studentCourseDAO;
    private ValidatorDTO validator;

    /**
     * Constructs a StudentCourseService instance, initializing the DAO and validator.
     */
    public StudentCourseService() {
        this.studentCourseDAO = new StudentCourseDAOImpl();
        this.validator = new ValidatorDTO();
    }

    /**
     * Retrieves all student course associations from the database.
     *
     * @return A list of StudentCourseDTO objects.
     */
    public List<StudentCourseDTO> getAllStudentCourses() {
        return studentCourseDAO.getAllStudentCourses();
    }

    /**
     * Retrieves a specific student course association by student ID and course ID.
     *
     * @param studentId The ID of the student.
     * @param courseId The ID of the course.
     * @return A StudentCourseDTO object if found, null otherwise.
     */
    public StudentCourseDTO getStudentCourseByStudentAndCourseId(int studentId, String courseId) {
        return studentCourseDAO.getStudentCourseByStudentAndCourseId(studentId, courseId);
    }

    /**
     * Adds a new student course association to the database after validation.
     *
     * @param studentCourse The StudentCourseDTO object to add.
     * @throws ValidationException If the student course data fails validation.
     */
    public void addStudentCourse(StudentCourseDTO studentCourse) throws ValidationException {
        validator.validateStudentCourse(studentCourse);
        studentCourseDAO.insertStudentCourse(studentCourse);
    }

    /**
     * Updates an existing student course association in the database.
     *
     * @param studentCourse The StudentCourseDTO object to update.
     * @throws ValidationException If the student course data fails validation.
     */
    public void updateStudentCourse(StudentCourseDTO studentCourse) throws ValidationException {
        validator.validateStudentCourse(studentCourse);
        studentCourseDAO.updateStudentCourse(studentCourse);
    }

    /**
     * Deletes a student course association from the database.
     *
     * @param studentCourse The StudentCourseDTO object to delete.
     */
    public void deleteStudentCourse(StudentCourseDTO studentCourse) {
        studentCourseDAO.deleteStudentCourse(studentCourse);
    }
}