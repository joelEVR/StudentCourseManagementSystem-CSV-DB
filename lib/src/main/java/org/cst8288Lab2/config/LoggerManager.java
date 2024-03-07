
package org.cst8288Lab2.config;

import java.util.ArrayList;
import java.util.List;

public class LoggerManager {
    private static LoggerManager instance; // Singleton instance of the logger
    private List<String> validData;
    private List<String> invalidData;

    private LoggerManager() {
        validData = new ArrayList<>();
        invalidData = new ArrayList<>();
    }

    public static LoggerManager Instance() {
        if (instance == null) {
            instance = new LoggerManager();
        }
        return instance;
    }

    public void addValidData(String data) {
        validData.add(data);
    }

    public List<String> getValid() {
        return validData;
    }

    public void addInvalidData(String data) {
        invalidData.add(data);
    }

    public List<String> getInvalid() {
        return invalidData;
    }
}
