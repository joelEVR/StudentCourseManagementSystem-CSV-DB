
package org.cst8288Lab2.report;

import java.util.List;

public class ReportDirector {
    private ReportBuilder reportBuilder;

    public ReportDirector(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    public void constructReport(String dateAndTime, int numberOfRecords, List<String> records) {
        reportBuilder.setDateAndTime(dateAndTime);
        reportBuilder.setNumberOfRecords(numberOfRecords);
        for (String record : records) {
            reportBuilder.addRecord(record);
        }
    }
    
        public String getReport() {
        return reportBuilder.getResult();
    }
}