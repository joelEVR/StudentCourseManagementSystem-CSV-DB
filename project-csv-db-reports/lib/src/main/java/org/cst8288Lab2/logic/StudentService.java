package org.cst8288Lab2.logic;

import java.util.List;

import org.cst8288Lab2.dao.StudentDAO;
import org.cst8288Lab2.dao.StudentDAOImpl;
import org.cst8288Lab2.dto.StudentDTO;

/**
 * Service layer class that handles business logic for student operations.
 * It interacts with the StudentDAO to perform CRUD operations and validates data before passing it to the DAO layer.
 */
public class StudentService {

    private StudentDAO studentDAO;
    private ValidatorDTO validator;

    /**
     * Constructs a StudentService instance, initializing the DAO and validator.
     */
    public StudentService() {
        studentDAO = new StudentDAOImpl();
        validator = new ValidatorDTO();
    }

    /**
     * Retrieves a student by their ID from the database.
     *
     * @param studentId The ID of the student to retrieve.
     * @return A StudentDTO object if found, null otherwise.
     */
    public StudentDTO getStudent(int studentId) {
        return studentDAO.getStudentById(studentId);
    }

    /**
     * Retrieves all students from the database.
     *
     * @return A list of StudentDTO objects.
     */
    public List<StudentDTO> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    /**
     * Adds a new student to the database after validation.
     *
     * @param student The StudentDTO object to add.
     * @throws ValidationException If the student data fails validation.
     */
    public void addStudent(StudentDTO student) throws ValidationException {
        validator.validateStudent(student);
        studentDAO.insertStudent(student);
    }

    /**
     * Updates an existing student in the database.
     *
     * @param student The StudentDTO object to update.
     * @throws ValidationException If the student data fails validation.
     */
    public void updateStudent(StudentDTO student) throws ValidationException {
        validator.validateStudent(student);
        studentDAO.updateStudent(student);
    }

    /**
     * Deletes a student from the database.
     *
     * @param student The StudentDTO object to delete.
     * @throws ValidationException If the student data fails validation.
     */
    public void deleteStudent(StudentDTO student) throws ValidationException {
        validator.validateStudent(student);
        studentDAO.deleteStudent(student);
    }
}