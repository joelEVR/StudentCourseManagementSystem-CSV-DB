package org.cst8288Lab2.dto;

/**
 * Represents a Data Transfer Object (DTO) for student information.
 * <p>
 * This class encapsulates the student data, allowing it to be transferred between
 * different layers of the application without exposing the underlying database structure.
 * It includes basic student information like student ID, first name, and last name.
 */
public class StudentDTO {
    // Fields with basic student information
    private Integer studentId;  
    private String firstName;
    private String lastName;
    
    /**
     * Default constructor for creating a new StudentDTO instance.
     */
    public StudentDTO(){
    }

    /**
     * Gets the student ID.
     *
     * @return An Integer representing the student ID.
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID.
     *
     * @param studentId An Integer representing the student ID.
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the first name of the student.
     *
     * @return A String representing the first name of the student.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName A String representing the first name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student.
     *
     * @return A String representing the last name of the student.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName A String representing the last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}