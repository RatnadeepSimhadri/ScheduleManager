/** 
 * 
 * File: DBConnectionManager.java
 * Date: 09/26/2014
 * Course: ISYS 622 601
 * Description: This is the Class facilitates managing database connections 
 * 
 */
package com.isys622.schedulemanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

	private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionUrl = "jdbc:mysql://localhost/schedule_manager";
    private final String userName = "schedule_manager";
    private final String userPass = "p@ssw0rd";

    private Connection conn = null;

    /** 
     * Constructor Loads the MySQL Driver
     */
    public DBConnectionManager() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
    
    
    /**
     * Method to Create Connection Object
     * @return
     * @throws SQLException
     */
    public Connection createConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(connectionUrl, userName, userPass);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return conn;
    }

    /**
     * Method to Close Connection Objects
     * @throws SQLException
     */
    public  void closeConnection() throws SQLException {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
