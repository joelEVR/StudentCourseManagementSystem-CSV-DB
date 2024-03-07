package org.cst8288Lab2.logic;

import java.util.Calendar;
import org.cst8288Lab2.config.LoggerManager;
import org.cst8288Lab2.utility.StudentCourseValidationResult;
import org.cst8288Lab2.utility.TermType;

/**
 * Handles the validation of CSV records for student courses.
 * This class ensures the integrity and correctness of data in each CSV record before it's processed further.
 * It checks for the right format, valid IDs, names, course details, term, and year based on predefined criteria.
 */
public class ValidatorStudentCourseCSV {

    private static final int STUDENT_ID_LENGTH = 9;
    private static final int COURSE_ID_LENGTH = 7;
    private static final int YEAR_LENGTH = 4;
    private static final int ALGONQUIN_YEAR_FOUNDING = 1967;

    /**
     * Initializes a new ValidatorStudentCourseCSV and retrieves an instance of LoggerManager.
     */
    public ValidatorStudentCourseCSV() {
        LoggerManager.Instance(); // Retrieves an instance of LoggerManager
    }

    /**
     * Validates a single line from a CSV file containing student course data.
     * It checks for correct data format, non-empty values, valid student and course IDs, term, and year.
     *
     * @param record The line number of the record being validated, for reference in logging.
     * @param data The actual CSV record as a String.
     * @return A StudentCourseValidationResult object representing the valid data if validation passes.
     * @throws ValidationException If any part of the CSV record fails validation due to incorrect format or invalid data.
     */
    public static StudentCourseValidationResult ValidateStudentCourseLine(int record, String data) throws ValidationException {
        String line = "Record " + record + ": " + data;
        String invalidRecord = ""; // Accumulates error messages for this record
        int studentIdInt, term, year;
        boolean isValid = true; // Flag to indicate overall validity of the record

        // Check if the data is not null
        if (data == null) {
            invalidRecord += "Data is null \n";
            isValid = false;
        }

        // Split the data string into its components
        String[] parts = data.split(",");
        // Check for the correct number of data parts
        if (parts.length != 7) {
            invalidRecord += "Invalid data format: " + data + "\n";
            isValid = false;
        }

        // Extract individual data fields from the parts array
        String studentId = parts[0].trim();
        String firstName = parts[1].trim();
        String lastName = parts[2].trim();
        String courseId = parts[3].trim();
        String courseName = parts[4].trim();
        String termStr = parts[5].trim();
        String yearStr = parts[6].trim();

        // Validate that no fields are empty
        if (studentId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
            courseId.isEmpty() || courseName.isEmpty() || termStr.isEmpty() || yearStr.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("One or more fields are empty: ");
            // Append names of empty fields to the error message
            if (studentId.isEmpty()) errorMessage.append("studentId, ");
            if (firstName.isEmpty()) errorMessage.append("firstName, ");
            if (lastName.isEmpty()) errorMessage.append("lastName, ");
            if (courseId.isEmpty()) errorMessage.append("courseId, ");
            if (courseName.isEmpty()) errorMessage.append("courseName, ");
            if (termStr.isEmpty()) errorMessage.append("term, ");
            if (yearStr.isEmpty()) errorMessage.append("year, ");
            errorMessage.deleteCharAt(errorMessage.length() - 2); // Remove the last comma and space

            invalidRecord += errorMessage.toString() + ": " + data + "\n";
            isValid = false;
        }

        // Validate student ID format
        if (studentId.length() != STUDENT_ID_LENGTH) {
            invalidRecord += "Invalid student ID format: \"" + studentId + "\". Student ID must be a 9-digit integer." + "\n";
            isValid = false;
        }

        // Validate course ID length and format
        if (courseId.length() != COURSE_ID_LENGTH) {
            invalidRecord += "Invalid course ID length: \"" + courseId + "\". Course ID must have a length of 7 characters." + "\n";
            isValid = false;
        }
        if (!courseId.matches("[A-Za-z]{3}\\d{4}")) {
            invalidRecord += "Invalid course ID format: \"" + courseId + "\". Course ID must consist of 3 letters followed by 4 digits." + "\n";
            isValid = false;
        }

        // Validate term by converting string to enum and check its value
        term = TermType.mapTerm(termStr);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (term < 1 || term > 3) {
            invalidRecord += "Invalid term value: \"" + termStr + "\". Term must be one of the following options: \"WINTER\", \"SUMMER\", \"FALL\"." + "\n";
            isValid = false;
        }

        // Validate year format and range
        year = Integer.parseInt(yearStr); // Assuming valid integer format
        if (yearStr.length() != YEAR_LENGTH) {
            invalidRecord += "Invalid year format: " + year + ". The year must consist of exactly 4 digits.\n";
            isValid = false;
        }
        if (year < ALGONQUIN_YEAR_FOUNDING || year > currentYear) {
            invalidRecord += "Invalid year value: \"" + yearStr + "\". Year must be between 1967 and " + currentYear + "." + "\n";
            isValid = false;
        }

        // If all checks pass, log valid data and return a result object
        if (isValid) {
            studentIdInt = Integer.parseInt(studentId); // Convert student ID to integer
            LoggerManager.Instance().addValidData(line + " Save successful!\n");
            return new StudentCourseValidationResult(studentIdInt, firstName, lastName, courseId, courseName, term, year);
        } else {
            // If any check fails, log invalid data and throw an exception
            LoggerManager.Instance().addInvalidData(line + "\n" + invalidRecord);
            throw new ValidationException("Invalid data");
        }
    }
}
