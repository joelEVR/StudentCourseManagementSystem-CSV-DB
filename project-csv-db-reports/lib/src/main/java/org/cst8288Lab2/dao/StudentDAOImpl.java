package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cst8288Lab2.config.DataSource;
import org.cst8288Lab2.dto.StudentDTO;

/**
 * Implementation of the StudentDAO interface for performing CRUD operations on student records in the database.
 * This class provides concrete methods to fetch, insert, update, and delete student records.
 */
public class StudentDAOImpl implements StudentDAO {

    /**
     * Retrieves all student records from the database, sorted by student ID.
     *
     * @return a list of StudentDTO objects representing all students.
     */
    @Override
    public List<StudentDTO> getAllStudents() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<StudentDTO> students = null;

        try {
            con = DataSource.Instance().getConnection();

            String query = "SELECT * FROM student ORDER BY studentid";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();
            students = new ArrayList<StudentDTO>();
            while (rs.next()) {
                StudentDTO student = new StudentDTO();
                student.setStudentId(rs.getInt("studentId"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Resources should be closed here to prevent resource leaks.
        }
        return students;
    }

    /**
     * Retrieves a specific student by their ID from the database.
     *
     * @param studentId the ID of the student to retrieve.
     * @return a StudentDTO object representing the student, or null if the student does not exist.
     */
    @Override
    public StudentDTO getStudentById(int studentId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentDTO student = null;

        try {
            connection = DataSource.Instance().getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM student WHERE studentid = ?");
            pstmt.setInt(1, studentId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new StudentDTO();
                student.setStudentId(rs.getInt("studentId"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Resources should be closed here.
        }
        return student;
    }

    /**
     * Inserts a new student record into the database.
     * Checks for an existing record with the same ID before insertion to avoid duplicates.
     *
     * @param student the StudentDTO object representing the student to insert.
     */
    @Override
    public void insertStudent(StudentDTO student) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            StudentDTO existingData = getStudentById(student.getStudentId());
            if (existingData == null) {
                con = DataSource.Instance().getConnection();

                pstmt = con.prepareStatement(
                        "INSERT INTO student (studentid, firstname, lastname) VALUES(?, ?, ?)");
                pstmt.setInt(1, student.getStudentId());
                pstmt.setString(2, student.getFirstName());
                pstmt.setString(3, student.getLastName());
                pstmt.executeUpdate();
            } else {
                // Ideally, an exception should be thrown or handled to indicate the record already exists.
            }
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                System.out.println("Student with ID " + student.getStudentId() + " already exists.");
            } else {
                // Handle other SQL exceptions appropriately.
            }
        }
    }

    /**
     * Updates an existing student record in the database with new information.
     *
     * @param student the StudentDTO object containing the updated student information.
     */
    @Override
    public void updateStudent(StudentDTO student) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DataSource.Instance().getConnection();
            pstmt = con.prepareStatement(
                    "UPDATE student SET FirstName = ?, LastName = ? WHERE studentid = ?");
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setInt(3, student.getStudentId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a student record from the database.
     *
     * @param student the StudentDTO object representing the student to delete.
     */
    @Override
    public void deleteStudent(StudentDTO student) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DataSource.Instance().getConnection();
            pstmt = con.prepareStatement("DELETE FROM student WHERE studentid = ?");
            pstmt.setInt(1, student.getStudentId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Resources should be closed here.
        }
    }
}
