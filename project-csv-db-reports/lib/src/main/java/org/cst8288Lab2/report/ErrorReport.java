
package org.cst8288Lab2.report;

/**
 * Implements the {@link ReportBuilder} interface to create and format an error report.
 * <p>
 * This class is responsible for constructing an error report by accumulating error information
 * and organizing it into a structured format. The report includes a header with the date and time,
 * the total number of error records, and detailed descriptions of each error.
 * </p>
 */
public class ErrorReport implements ReportBuilder {

    /** Stores the accumulated content of the error report. */
    private StringBuilder report;

    /**
     * Constructs a new {@code ErrorReport} instance.
     * <p>
     * Initializes the report with an empty {@link StringBuilder} to hold the report content.
     * </p>
     */
    public ErrorReport() {
        this.report = new StringBuilder();
    }

    /**
     * Appends the date and time of report generation to the beginning of the error report.
     * <p>
     * This method formats the start of the report with a header that includes the specified date and time,
     * marking the report's creation moment.
     * </p>
     *
     * @param dateAndTime A {@link String} specifying the date and time of the report generation.
     */
    @Override
    public void setDateAndTime(String dateAndTime) {
        report.append("## Error Report\n");
        report.append("Date and Time: ").append(dateAndTime).append("\n\n");
    }

    /**
     * Specifies the total number of error records to be included in the report.
     * <p>
     * This method adds a section to the report detailing the total number of errors that have occurred,
     * providing a quick overview of the error volume.
     * </p>
     *
     * @param numberOfRecords An {@code int} representing the total number of error records.
     */
    @Override
    public void setNumberOfRecords(int numberOfRecords) {
        report.append("Number of errors: ").append(numberOfRecords).append("\n\n");
    }

    /**
     * Adds a detailed description of an individual error record to the report.
     * <p>
     * Each error record is added as a list item, allowing for easy reading and identification
     * of specific errors within the report.
     * </p>
     *
     * @param record A {@link String} containing the error record to be added.
     */
    @Override
    public void addRecord(String record) {
        report.append("* ").append(record).append("\n");
    }

    /**
     * Compiles and returns the complete error report as a single string.
     * <p>
     * This method consolidates all the information added to the report into a formatted string,
     * making it suitable for output, logging, or further processing.
     * </p>
     *
     * @return A {@link String} representing the final error report, including all added content.
     */
    @Override
    public String getResult() {
        return report.toString();
    }
}
