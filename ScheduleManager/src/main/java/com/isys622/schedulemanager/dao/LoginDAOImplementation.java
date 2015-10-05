package com.isys622.schedulemanager.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.isys622.schedulemanager.VO.ProfileVO;
import com.isys622.schedulemanager.util.DBConnectionManager;
import com.isys622.schedulemanager.util.Webconstants;

public class LoginDAOImplementation implements LoginDAO {
	/**
		 * This method returns a list of all orders from the database.
		 * @return a list of Order objects.
		 */
		public ProfileVO validateLogin(String username, String password) {
	
			ResultSet rs = null;
			CallableStatement cs = null;
			Connection conn = null;
			DBConnectionManager manager = null;
			boolean isvaliduser=false;
			ProfileVO profile = null;
			try {
	
				String result = "";
				manager = new DBConnectionManager();
				conn = manager.createConnection();
				cs = conn.prepareCall(Webconstants.validateLogin);
				cs.setString(1, username);
				cs.setString(2, password);
				
				rs= cs.executeQuery();
				
				while (rs.next()) {
					profile = new ProfileVO();
					profile.setEmployeeId(rs.getInt("employee"));
					profile.setUsername(rs.getString("username"));
					profile.setPassword(rs.getString("password"));
					profile.setRole(rs.getString("role"));
				}
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
			finally{
				try {
					rs.close();
					cs.close();
					manager.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
			return profile;
		}
}

