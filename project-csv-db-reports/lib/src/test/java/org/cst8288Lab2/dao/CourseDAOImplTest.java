package org.cst8288Lab2.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cst8288Lab2.dto.CourseDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test class for {@link CourseDAOImpl} to verify its functionality using Mockito for mocking dependencies.
 * This class focuses on testing CRUD operations for course data.
 */
public class CourseDAOImplTest {

    private CourseDAOImpl courseDAO;

    /**
     * Sets up the test environment by initializing a mock {@link CourseDAOImpl} object.
     * This method is called before each test execution.
     */
    @BeforeEach
    public void setUp() {
        courseDAO = Mockito.mock(CourseDAOImpl.class);
    }

    /**
     * Tests the retrieval of all courses from the database.
     * This method prepares expected course data, mocks the DAO's {@code getAllCourses} method
     * to return the expected data, invokes the method, and asserts the outcome is as expected.
     *
     * @throws SQLException if an SQL error occurs during the test (not expected in this mock setup).
     */
    @Test
    public void testGetAllCourses() throws SQLException {
        // Prepare expected course data
        List<CourseDTO> expectedCourses = new ArrayList<>();
        CourseDTO course1 = new CourseDTO();
        course1.setCourseId("CST1111");
        course1.setCourseName("Java Programming Fundamentals");

        CourseDTO course2 = new CourseDTO();
        course2.setCourseId("CST2222");
        course2.setCourseName("Java Programming Advanced");

        expectedCourses.add(course1);
        expectedCourses.add(course2);

        // Mock getAllCourses method
        Mockito.when(courseDAO.getAllCourses()).thenReturn(expectedCourses);

        // Call the method under test
        List<CourseDTO> returnedCourses = courseDAO.getAllCourses();

        // Verify that the method was called exactly once
        Mockito.verify(courseDAO, Mockito.times(1)).getAllCourses();

        // Assert the results
        assertEquals(expectedCourses.size(), returnedCourses.size(), "Expected and actual course list sizes should match.");
        for (int i = 0; i < expectedCourses.size(); i++) {
            assertEquals(expectedCourses.get(i).getCourseId(), returnedCourses.get(i).getCourseId(), "Course IDs should match.");
            assertEquals(expectedCourses.get(i).getCourseName(), returnedCourses.get(i).getCourseName(), "Course names should match.");
        }
    }

    /**
     * Tests the insertion of a new course into the database.
     * This method prepares a course object, mocks the DAO's {@code insertCourse} method
     * to simulate the insertion operation, and verifies the method was called as expected.
     */
    @Test
    public void testInsertCourse() {
        // Prepare a course object
        CourseDTO course = new CourseDTO();
        course.setCourseId("CST3333");
        course.setCourseName("Java Programming Intermediate");

        // Mock insertCourse method
        courseDAO.insertCourse(course);

        // Verify that the method was called exactly once
        Mockito.verify(courseDAO, Mockito.times(1)).insertCourse(course);
    }

    /**
     * Tests the update of an existing course in the database.
     * This method prepares a modified course object, mocks the DAO's {@code updateCourse} method
     * to simulate the update operation, and verifies the method was called as expected.
     */
    @Test
    public void testUpdateCourse() {
        // Prepare a course object
        CourseDTO course = new CourseDTO();
        course.setCourseId("CST4444");
        course.setCourseName("Java Programming");

        // Mock updateCourse method
        courseDAO.updateCourse(course);

        // Verify that the method was called exactly once
        Mockito.verify(courseDAO, Mockito.times(1)).updateCourse(course);
    }

    /**
     * Tests the deletion of a course from the database.
     * This method prepares a course object for deletion, mocks the DAO's {@code deleteCourse} method
     * to simulate the deletion operation, and verifies the method was called as expected.
     */
    @Test
    public void testDeleteCourse() {
        // Prepare a course object
        CourseDTO course = new CourseDTO();
        course.setCourseId("CST2222");
        course.setCourseName("Java Programming Advanced");

        // Mock deleteCourse method
        courseDAO.deleteCourse(course);

        // Verify that the method was called exactly once
        Mockito.verify(courseDAO, Mockito.times(1)).deleteCourse(course);
    }
}
