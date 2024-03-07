package org.cst8288Lab2.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private static Connection connection = null;
    private static DataSource instance;
    private DataSource() {
        try{
            String[] connectionInfo = openPropsFile();
          //  Class.forName(this.driverString);
             connection = DriverManager.getConnection(connectionInfo[0], connectionInfo[1], connectionInfo[2]);

        }catch ( SQLException e) {
                  }
    }
    // Method to get the singleton instance of DBConnection
    public static DataSource Instance() {
        if (instance == null) {

            instance = new DataSource();
        }
        return instance;
    }

    private static String[] openPropsFile() {
        // added use of Properties and try-with-resources
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(Paths.get("./data/database.properties"));) {
            props.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// catch()

        String connectionString = "jdbc:"+props.getProperty("db")+"://"+props.getProperty("host")+":"+props.getProperty("port")+"/"+props.getProperty("name");
        String username = props.getProperty("user");
        String password = props.getProperty("pass");

        String[] info = new String[3];
        info[0] = connectionString;
        info[1] = username;
        info[2] = password;

        return info;
    }
        // Method to get the database connection
    public Connection getConnection() {
    
        return connection;
    }
    
}