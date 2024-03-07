package org.cst8288Lab2.dao;

import java.util.List;

import org.cst8288Lab2.logic.ValidationException;
import org.cst8288Lab2.dto.StudentCourseDTO;
/**
 * Interface for the StudentCourseDAOImpl class. This interface provides methods
 * to perform CRUD operations for student-course relationships in the database.
 */
public interface StudentCourseDAO {

    // CRUD operations
    public List<StudentCourseDTO> getAllStudentCourses();

    public StudentCourseDTO getStudentCourseByStudentAndCourseId(int studentId, String courseId);

    public void insertStudentCourse(StudentCourseDTO studentCourse) throws ValidationException;

    public void updateStudentCourse(StudentCourseDTO studentCourse);

    public void deleteStudentCourse(StudentCourseDTO studentCourse);
}
