package org.cst8288Lab2.services;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

import org.cst8288Lab2.report.ReportBuilder;
import org.cst8288Lab2.report.ReportDirector;
import org.cst8288Lab2.config.LoggerManager;
import org.cst8288Lab2.logic.CourseService;
import org.cst8288Lab2.logic.StudentService;
import org.cst8288Lab2.logic.StudentCourseService;
import org.cst8288Lab2.logic.ValidationException;
import org.cst8288Lab2.logic.ValidatorStudentCourseCSV;
import org.cst8288Lab2.report.ErrorReport;
import org.cst8288Lab2.report.SuccessReport;
import org.cst8288Lab2.dto.CourseDTO;
import org.cst8288Lab2.dto.StudentCourseDTO;
import org.cst8288Lab2.dto.StudentDTO;
import org.cst8288Lab2.utility.TermType;

/**
 * Extends {@link CSVProcessor} to specifically handle the processing of CSV files related
 * to student and course data. It validates and persists student, course, and student-course
 * relationships from the CSV data to the database and generates reports on the process.
 */
public class DataCSVProcessor extends CSVProcessor {

	private final StudentService studentService;
	private final CourseService courseService;
	private final StudentCourseService studentCourseService;

	/**
	 * Initializes new services for processing student and course data.
	 */
	public DataCSVProcessor() {
		studentService = new StudentService();
		courseService = new CourseService();
		studentCourseService = new StudentCourseService();
	}

	/**
	 * Processes a list of CSV lines representing student and course data,
	 * validating and updating the database accordingly. Generates success and error
	 * reports based on the outcome.
	 *
	 * @param lines A List of strings, each representing a line from the CSV file.
	 * @throws IOException If an I/O error occurs during report generation.
	 */
	@Override
	public void processData(List<String> lines) throws IOException {

		for (int i = 1; i < lines.size(); i++) {

			try {
				String line = lines.get(i);
				ValidatorStudentCourseCSV.ValidateStudentCourseLine(i, line);

				String[] parts = line.split(",");
				if (parts.length != 7) {
					throw new ValidationException("Invalid data format: " + line);
				}

				int studentId = Integer.parseInt(parts[0].trim());
				String firstName = parts[1].trim();
				String lastName = parts[2].trim();
				String courseId = parts[3].trim();
				String courseName = parts[4].trim();
				String termStr = parts[5].trim();
				int year = Integer.parseInt(parts[6].trim());

				StudentDTO student = new StudentDTO();
				student.setStudentId(studentId);
				student.setFirstName(firstName);
				student.setLastName(lastName);
				studentService.addStudent(student);

				CourseDTO course = new CourseDTO();
				course.setCourseId(courseId);
				course.setCourseName(courseName);
				courseService.addCourse(course);

				StudentCourseDTO studentCourse = new StudentCourseDTO();
				studentCourse.setStudentId(studentId);
				studentCourse.setCourseId(courseId);
				studentCourse.setTerm(TermType.mapTerm(termStr));
				studentCourse.setYear(year);
				studentCourseService.addStudentCourse(studentCourse);

			} catch (ValidationException e) {
				// Handle validation exceptions for individual records here, if necessary.
			}
		}
		// Generate and save reports
		saveLogFiles();
	}

	/**
	 * Generates and writes success and error reports for the CSV processing.
	 * Utilizes the builder and director patterns to assemble the reports.
	 */
	private void saveLogFiles() {
		// Setup for report generation
		Instant currentTimeUtc = Instant.now();
		String currentTimeString = currentTimeUtc.toString();

		// Success report
		ReportBuilder successReportBuilder = new SuccessReport();
		ReportDirector successReportDirector = new ReportDirector(successReportBuilder);
		successReportDirector.constructReport(currentTimeString, LoggerManager.Instance().getValid().size(),
				LoggerManager.Instance().getValid());
		String importReport = successReportDirector.getReport();
		this.writeFile(importReport, "data/import-report.md");

		// Error report
		ReportBuilder errorReportBuilder = new ErrorReport();
		ReportDirector errorReportDirector = new ReportDirector(errorReportBuilder);
		errorReportDirector.constructReport(currentTimeString, LoggerManager.Instance().getInvalid().size(),
				LoggerManager.Instance().getInvalid());
		String errorReport = errorReportDirector.getReport();
		this.writeFile(errorReport, "data/error-report.md");
	}
	
	

}
