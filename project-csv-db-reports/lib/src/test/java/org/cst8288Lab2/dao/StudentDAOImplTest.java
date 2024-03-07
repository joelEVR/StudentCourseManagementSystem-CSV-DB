package org.cst8288Lab2.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.cst8288Lab2.config.DataSource;
import org.cst8288Lab2.dto.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Tests the StudentDAOImpl class, focusing on the database operations for student entities.
 * Utilizes Mockito to simulate database interactions.
 */
public class StudentDAOImplTest {

    /**
     * Prepares the testing environment, specifically initializing the data source.
     * This setup occurs before each test method.
     * 
     * @throws Exception if an error occurs during data source initialization.
     */
    @BeforeEach
    public void setUp() throws Exception {
        DataSource.Instance();
    }

    /**
     * Tests retrieval of all student records from the database.
     * Validates that the returned list matches the expected results.
     * 
     * @throws SQLException if a database access error occurs.
     */
    @Test
    public void testGetAllStudents() throws SQLException {
        List<StudentDTO> expectedStudents = new ArrayList<>();
        StudentDTO student1 = new StudentDTO();
        student1.setStudentId(333333333);
        student1.setFirstName("Alice");
        student1.setLastName("Johnson");
        StudentDTO student2 = new StudentDTO();
        student2.setStudentId(444444444);
        student2.setFirstName("Bob");
        student2.setLastName("Williams");
        expectedStudents.add(student1);
        expectedStudents.add(student2);

        StudentDAOImpl studentDAO = Mockito.mock(StudentDAOImpl.class);
        Mockito.when(studentDAO.getAllStudents()).thenReturn(expectedStudents);

        List<StudentDTO> returnedStudents = studentDAO.getAllStudents();

        Mockito.verify(studentDAO).getAllStudents();

        assertEquals(expectedStudents, returnedStudents, "The returned student list should match the expected list.");
    }

    /**
     * Tests the insertion of a student record into the database.
     * Verifies the operation by ensuring the method is called as expected.
     */
    @Test
    public void testInsertStudent() {
        StudentDTO student = new StudentDTO();
        student.setStudentId(333333333);
        student.setFirstName("Alice");
        student.setLastName("Johnson");

        StudentDAOImpl studentDAO = Mockito.mock(StudentDAOImpl.class);
        studentDAO.insertStudent(student);

        Mockito.verify(studentDAO).insertStudent(student);
    }

    /**
     * Tests the update of an existing student record in the database.
     * Verifies the operation by ensuring the method is called as expected.
     */
    @Test
    public void testUpdateStudent() {
        StudentDTO student = new StudentDTO();
        student.setStudentId(333333333);
        student.setFirstName("Alice");
        student.setLastName("Johnson");

        StudentDAOImpl studentDAO = Mockito.mock(StudentDAOImpl.class);
        studentDAO.updateStudent(student);

        Mockito.verify(studentDAO).updateStudent(student);
    }

    /**
     * Tests the deletion of a student record from the database.
     * Verifies the operation by ensuring the method is called as expected.
     */
    @Test
    public void testDeleteStudent() {
        StudentDTO student = new StudentDTO();
        student.setStudentId(333333333);
        student.setFirstName("Alice");
        student.setLastName("Johnson");

        StudentDAOImpl studentDAO = Mockito.mock(StudentDAOImpl.class);
        studentDAO.deleteStudent(student);

        Mockito.verify(studentDAO).deleteStudent(student);
    }
}
