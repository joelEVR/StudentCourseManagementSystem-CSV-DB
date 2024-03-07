
package org.cst8288Lab2.dao;

import java.util.List;
import org.cst8288Lab2.dto.StudentDTO;

/**
 * Interface defining the CRUD operations for managing student records in the database.
 * This interface provides methods to perform operations such as retrieval, insertion, update, and deletion of student records.
 */
public interface StudentDAO {
    /**
     * Retrieves all student records from the database.
     *
     * @return a list of StudentDTO objects, each representing a student.
     */
    public List<StudentDTO> getAllStudents();

    /**
     * Retrieves a specific student by their ID.
     *
     * @param studentId the ID of the student to retrieve.
     * @return a StudentDTO object representing the student, or null if the student does not exist.
     */
    public StudentDTO getStudentById(int studentId);

    /**
     * Inserts a new student record into the database.
     *
     * @param student the StudentDTO object representing the student to insert.
     */
    public void insertStudent(StudentDTO student);

    /**
     * Updates an existing student record in the database.
     *
     * @param student the StudentDTO object containing the updated student information.
     */
    public void updateStudent(StudentDTO student);

    /**
     * Deletes a student record from the database.
     *
     * @param student the StudentDTO object representing the student to delete.
     */
    public void deleteStudent(StudentDTO student);
}
