package org.cst8288Lab2.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import org.cst8288Lab2.logic.ValidationException;
import org.cst8288Lab2.dto.StudentCourseDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for StudentCourseDAOImpl, focused on verifying the DAO's ability to handle
 * CRUD operations for student course data. Utilizes Mockito to mock the DAO's behavior.
 */
public class StudentCourseDAOImplTest {

    private StudentCourseDAOImpl studentCourseDAO;

    /**
     * Initializes a mock instance of StudentCourseDAOImpl before each test.
     */
    @BeforeEach
    public void setUp() {
        studentCourseDAO = Mockito.mock(StudentCourseDAOImpl.class);
    }

    /**
     * Tests the retrieval of all student course records.
     * This test verifies that the mocked DAO's getAllStudentCourses method
     * returns the expected list of student course records.
     * 
     * @throws SQLException if a database access error occurs.
     */
    @Test
    public void testGetAllStudentCourses() throws SQLException {
        List<StudentCourseDTO> expectedStudentCourses = new ArrayList<>();
        StudentCourseDTO studentCourse1 = new StudentCourseDTO();
        studentCourse1.setStudentId(333333333);
        studentCourse1.setCourseId("CST9090");
        studentCourse1.setTerm(3);
        studentCourse1.setYear(2021);

        StudentCourseDTO studentCourse2 = new StudentCourseDTO();
        studentCourse2.setStudentId(444444444);
        studentCourse2.setCourseId("CST1010");
        studentCourse2.setTerm(2);
        studentCourse2.setYear(2022);

        expectedStudentCourses.add(studentCourse1);
        expectedStudentCourses.add(studentCourse2);

        Mockito.when(studentCourseDAO.getAllStudentCourses()).thenReturn(expectedStudentCourses);

        List<StudentCourseDTO> returnedStudentCourses = studentCourseDAO.getAllStudentCourses();

        Mockito.verify(studentCourseDAO).getAllStudentCourses();

        assertEquals(expectedStudentCourses, returnedStudentCourses, "The returned list of student courses should match the expected list.");
    }

    /**
     * Tests the insertion of a student course record.
     * Verifies that the DAO's insertStudentCourse method is called as expected.
     * 
     * @throws ValidationException if the data provided to the method is invalid.
     */
    @Test
    public void testInsertStudentCourse() throws ValidationException {
        StudentCourseDTO studentCourse = new StudentCourseDTO();
        studentCourse.setStudentId(333333333);
        studentCourse.setCourseId("CST9090");
        studentCourse.setTerm(3);
        studentCourse.setYear(2021);

        studentCourseDAO.insertStudentCourse(studentCourse);

        Mockito.verify(studentCourseDAO).insertStudentCourse(studentCourse);
    }

    /**
     * Tests the update of a student course record.
     * Verifies that the DAO's updateStudentCourse method is called as expected.
     */
    @Test
    public void testUpdateStudentCourse() {
        StudentCourseDTO studentCourse = new StudentCourseDTO();
        studentCourse.setStudentId(333333333);
        studentCourse.setCourseId("CST9091");
        studentCourse.setTerm(3);
        studentCourse.setYear(2021);

        studentCourseDAO.updateStudentCourse(studentCourse);

        Mockito.verify(studentCourseDAO).updateStudentCourse(studentCourse);
    }

    /**
     * Tests the deletion of a student course record.
     * Verifies that the DAO's deleteStudentCourse method is called as expected.
     */
    @Test
    public void testDeleteStudentCourse() {
        StudentCourseDTO studentCourse = new StudentCourseDTO();
        studentCourse.setStudentId(333333333);
        studentCourse.setCourseId("CST9091");
        studentCourse.setTerm(3);
        studentCourse.setYear(2021);

        studentCourseDAO.deleteStudentCourse(studentCourse);

        Mockito.verify(studentCourseDAO).deleteStudentCourse(studentCourse);
    }
}
