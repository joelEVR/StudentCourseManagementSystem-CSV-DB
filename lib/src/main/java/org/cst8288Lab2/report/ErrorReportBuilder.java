
package org.cst8288Lab2.report;

/**
 * A report builder for error reports.
 */
class ErrorReportBuilder implements ReportBuilder {
    private StringBuilder report = new StringBuilder();

    @Override
    public void setDateAndTime(String dateAndTime) {
        report.append("## Error Report\n");
        report.append("Date and Time: ").append(dateAndTime).append("\n\n");
    }

    @Override
    public void setNumberOfRecords(int numberOfRecords) {
        report.append("Number of errors: ").append(numberOfRecords).append("\n\n");
    }

    @Override
    public void addRecord(String record) {
        report.append("* ").append(record).append("\n");
    }

    @Override
    public String getResult() {
        return report.toString();
    }
}

