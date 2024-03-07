
package org.cst8288Lab2.report;

public interface ReportBuilder {
    void setDateAndTime(String dateAndTime);
    void setNumberOfRecords(int numberOfRecords);
    void addRecord(String record);
    String getResult();
}