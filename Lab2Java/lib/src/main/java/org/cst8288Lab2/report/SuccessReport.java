package org.cst8288Lab2.report;

/**
 * Implements the {@link ReportBuilder} interface to generate success reports
 * for data import operations. It uses a StringBuilder to accumulate the report content.
 *
 * @since 1.0
 */
public class SuccessReport implements ReportBuilder {
    /**
     * The StringBuilder instance used to build the success report.
     */
    private StringBuilder report;

    /**
     * Constructs a new SuccessReport instance. Initializes the internal StringBuilder
     * used to accumulate report details.
     */
    public SuccessReport() {
        this.report = new StringBuilder();
    }

    /**
     * Adds the date and time of the report to the beginning of the report.
     *
     * @param dateAndTime The date and time when the report is generated, in a string format.
     */
    @Override
    public void setDateAndTime(String dateAndTime) {
        report.append("## Import Report\n");
        report.append("Date and Time: ").append(dateAndTime).append("\n\n");
    }

    /**
     * Appends the total number of records added to the report.
     *
     * @param numberOfRecords The total number of records that were successfully added.
     */
    @Override
    public void setNumberOfRecords(int numberOfRecords) {
        report.append("Number of records added: ").append(numberOfRecords).append("\n\n");
    }

    /**
     * Adds a single record's details to the report. Each record is added as a new line item.
     *
     * @param record The detail of the record that was successfully added.
     */
    @Override
    public void addRecord(String record) {
        report.append("* ").append(record).append("\n");
    }

    /**
     * Retrieves the final success report as a String.
     *
     * @return The complete success report compiled as a String.
     */
    @Override
    public String getResult() {
        return report.toString();
    }
}
