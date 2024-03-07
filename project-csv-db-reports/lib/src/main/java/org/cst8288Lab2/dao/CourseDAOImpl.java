package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cst8288Lab2.config.DataSource;
import org.cst8288Lab2.dto.CourseDTO;

/**
 * Implementation of the CourseDAO interface for database operations.
 * This class provides methods to perform CRUD operations for courses in the database.
 */
public class CourseDAOImpl implements CourseDAO {

    /**
     * Retrieves all courses from the database.
     * 
     * @return A list of CourseDTO objects, each representing a course.
     */
    @Override
    public List<CourseDTO> getAllCourses() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<CourseDTO> courses = new ArrayList<>();

        try {
            connection = DataSource.Instance().getConnection();
            String query = "SELECT * FROM course";
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CourseDTO course = new CourseDTO();
                course.setCourseId(rs.getString("courseId"));
                course.setCourseName(rs.getString("courseName"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Retrieves a specific course by its ID.
     * 
     * @param courseId The ID of the course to retrieve.
     * @return The CourseDTO object if found, null otherwise.
     */
    @Override
    public CourseDTO getCourseById(String courseId) {
        Connection conectionn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CourseDTO course = null;

        try {
            conectionn = DataSource.Instance().getConnection();
            pstmt = conectionn.prepareStatement("SELECT * FROM course WHERE courseId = ?");
            pstmt.setString(1, courseId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                course = new CourseDTO();
                course.setCourseId(rs.getString("courseId"));
                course.setCourseName(rs.getString("courseName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    /**
     * Inserts a new course into the database.
     * 
     * @param course The CourseDTO object representing the course to add.
     */
    @Override
    public void insertCourse(CourseDTO course) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            CourseDTO existingData = getCourseById(course.getCourseId());
            if (existingData == null) {
                connection = DataSource.Instance().getConnection();
                pstmt = connection.prepareStatement("INSERT INTO course (courseId, courseName) VALUES (?, ?)");
                pstmt.setString(1, course.getCourseId().toUpperCase());
                pstmt.setString(2, course.getCourseName());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing course in the database.
     * 
     * @param course The CourseDTO object containing the updated course data.
     */
    @Override
    public void updateCourse(CourseDTO course) {
        Connection conectionn = null;
        PreparedStatement pstmt = null;

        try {
            conectionn = DataSource.Instance().getConnection();
            pstmt = conectionn.prepareStatement("UPDATE course SET courseName = ? WHERE courseId = ?");
            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getCourseId().toUpperCase());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a course from the database.
     * 
     * @param course The CourseDTO object representing the course to be deleted.
     */
    @Override
    public void deleteCourse(CourseDTO course) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DataSource.Instance().getConnection();
            pstmt = connection.prepareStatement("DELETE FROM course WHERE courseId = ?");
            pstmt.setString(1, course.getCourseId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
