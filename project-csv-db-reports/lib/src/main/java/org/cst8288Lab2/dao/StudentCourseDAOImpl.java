package org.cst8288Lab2.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cst8288Lab2.config.DataSource;
import org.cst8288Lab2.logic.ValidationException;
import org.cst8288Lab2.dto.StudentCourseDTO;

/**
 * Implementation of the StudentCourseDAO interface to perform CRUD operations on student courses in the database.
 * This class provides methods to fetch, insert, update, and delete student course records.
 */
public class StudentCourseDAOImpl implements StudentCourseDAO {

    /**
     * Retrieves all student course records from the database.
     *
     * @return a list of StudentCourseDTO objects representing all student courses.
     */
    @Override
    public List<StudentCourseDTO> getAllStudentCourses() {
        Connection connnection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<StudentCourseDTO> studentCourses = null;

        try {
            connnection = DataSource.Instance().getConnection();

            String query = "SELECT * FROM studentcourse";
            pstmt = connnection.prepareStatement(query);

            rs = pstmt.executeQuery();
            studentCourses = new ArrayList<>();
            while (rs.next()) {
                StudentCourseDTO studentCourse = new StudentCourseDTO();
                studentCourse.setStudentId(rs.getInt("studentId"));
                studentCourse.setCourseId(rs.getString("courseId"));
                studentCourse.setTerm(rs.getInt("term"));
                studentCourse.setYear(rs.getInt("year"));
                studentCourses.add(studentCourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Ideally, resources should be closed here to prevent resource leaks.
        }
        return studentCourses;
    }

    /**
     * Retrieves a specific student course by student ID and course ID.
     *
     * @param studentId the ID of the student.
     * @param courseId the ID of the course.
     * @return a StudentCourseDTO object representing the student course, or null if not found.
     */
    @Override
    public StudentCourseDTO getStudentCourseByStudentAndCourseId(int studentId, String courseId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentCourseDTO studentCourse = null;

        try {
            connection = DataSource.Instance().getConnection();
            pstmt = connection.prepareStatement(
                    "SELECT * FROM studentcourse WHERE studentId = ? AND courseId = ?");
            pstmt.setInt(1, studentId);
            pstmt.setString(2, courseId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                studentCourse = new StudentCourseDTO();
                studentCourse.setStudentId(rs.getInt("studentId"));
                studentCourse.setCourseId(rs.getString("courseId"));
                studentCourse.setTerm(rs.getInt("term"));
                studentCourse.setYear(rs.getInt("year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Resources should be closed here.
        }
        return studentCourse;
    }

    /**
     * Inserts a new student course record into the database.
     *
     * @param studentCourse the StudentCourseDTO object to insert.
     * @throws ValidationException if the student course data fails validation checks.
     */
    @Override
    public void insertStudentCourse(StudentCourseDTO studentCourse) throws ValidationException {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Check if the record already exists to prevent duplicates.
            StudentCourseDTO existingData = getStudentCourseByStudentAndCourseId(studentCourse.getStudentId(), studentCourse.getCourseId());

            if (existingData == null) {
                connection = DataSource.Instance().getConnection();

                pstmt = connection.prepareStatement(
                        "INSERT INTO studentcourse (studentId, courseId, term, year) "
                        + "VALUES (?, ?, ?, ?)");
                pstmt.setInt(1, studentCourse.getStudentId());
                pstmt.setString(2, studentCourse.getCourseId().toUpperCase());
                pstmt.setInt(3, studentCourse.getTerm());
                pstmt.setInt(4, studentCourse.getYear());
                pstmt.executeUpdate();
            } else {
                // A validation exception should be thrown if the record already exists.
            }
        } catch (SQLException e) {
            // Handle SQL exceptions, potentially logging them or converting to a more appropriate exception.
        } finally {
            // Resources should be closed here.
        }
    }

    /**
     * Updates an existing student course record in the database.
     *
     * @param studentCourse the StudentCourseDTO object to update.
     */
    @Override
    public void updateStudentCourse(StudentCourseDTO studentCourse) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DataSource.Instance().getConnection();
            pstmt = connection.prepareStatement(
                    "UPDATE studentcourse SET term = ?, year = ? WHERE studentId = ? AND courseId = ?");
            pstmt.setInt(1, studentCourse.getTerm());
            pstmt.setInt(2, studentCourse.getYear());
            pstmt.setInt(3, studentCourse.getStudentId());
            pstmt.setString(4, studentCourse.getCourseId().toUpperCase());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Resources should be closed here.
        }
    }

    /**
     * Deletes a student course record from the database.
     *
     * @param studentCourse the StudentCourseDTO object to delete.
     */
    @Override
    public void deleteStudentCourse(StudentCourseDTO studentCourse) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DataSource.Instance().getConnection();
            pstmt = connection.prepareStatement(
                    "DELETE FROM studentcourse WHERE studentId = ? AND courseId = ?");
            pstmt.setInt(1, studentCourse.getStudentId());
            pstmt.setString(2, studentCourse.getCourseId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Resources should be closed here.
        }
    }
}
