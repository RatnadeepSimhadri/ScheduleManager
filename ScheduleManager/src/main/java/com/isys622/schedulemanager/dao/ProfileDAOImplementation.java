package com.isys622.schedulemanager.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.isys622.schedulemanager.VO.ProfileVO;
import com.isys622.schedulemanager.form.CreateShiftForm;
import com.isys622.schedulemanager.form.EmployeeForm;
import com.isys622.schedulemanager.form.SelectItem;
import com.isys622.schedulemanager.util.DBConnectionManager;
import com.isys622.schedulemanager.util.Webconstants;

public class ProfileDAOImplementation implements ProfileDAO {
	/**
		 * This method returns a list of all orders from the database.
		 * @return a list of Order objects.
		 */
		public String createProfile(EmployeeForm form) {
	
			ResultSet rs = null;
			CallableStatement cs = null;
			Connection conn = null;
			DBConnectionManager manager = null;
			PreparedStatement ps = null; 
			String result = "";
			try {
	
				
				manager = new DBConnectionManager();
				conn = manager.createConnection();
				conn.setAutoCommit(false);
				cs = conn.prepareCall(Webconstants.validateUsername);
				cs.setString(1, form.getUsername());
				cs.registerOutParameter(2, java.sql.Types.VARCHAR);
				cs.executeQuery();
				result=cs.getString(2);
				if(result!=null && result.equalsIgnoreCase("exists")){
					return "Username already exists";
				}
				else
				{
					ps = conn.prepareStatement(Webconstants.insertAddress , Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, form.getAddress().getStreet());
					ps.setString(2, form.getAddress().getCity());
					ps.setString(3, form.getAddress().getState());
					ps.setString(4, form.getAddress().getZip());
					
					int affectedRows = ps.executeUpdate();

			        if (affectedRows == 0) {
			            throw new SQLException("Creating user failed, no rows affected.");
			        }
			        
			        ResultSet generatedKeys = ps.getGeneratedKeys();
			        if (generatedKeys.next()) {
			        	form.getAddress().setId(generatedKeys.getInt(1));
		            }
			       
			        cs = conn.prepareCall(Webconstants.createProfile);
			        cs.setString(1, form.getNetId());
			        cs.setString(2, form.getFirstName());
			        cs.setString(3, form.getLastName());
			        cs.setInt(4, form.getAddress().getId());
			        cs.setString(5, form.getEmail());
			        cs.setString(6, form.getGender());
			        cs.setLong(7, form.getPhone());
			        cs.setString(8, form.getRole());
			        cs.setString(9, form.getUsername());
			        cs.setString(10, form.getPassword());
			        cs.setInt(11, form.getLab());
			        cs.executeQuery();
			        conn.commit();
			        result="Employee profile has been created";
					
				}
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
			finally{
				try {
					if(rs!=null){
					rs.close();
					}
					if(cs!=null){
					cs.close();
					}
					
					if(ps!=null){
						ps.close();
					}
					manager.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
			return result;
		}

	
	public List<SelectItem> getAllManagers() {
		ResultSet rs = null;
		Connection conn = null;
		DBConnectionManager manager = null;
		PreparedStatement ps = null;
		List<SelectItem> mangers = null;
		try{
			manager = new DBConnectionManager();
			conn = manager.createConnection();
			ps = conn.prepareStatement(Webconstants.getallManagers);
			rs=ps.executeQuery();
			while(rs.next()){
				if(mangers==null){
					mangers= new ArrayList<SelectItem>();
				}
				
				SelectItem obj = new SelectItem(rs.getInt(1), rs.getString(2));
				mangers.add(obj);
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null){
				rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				manager.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return mangers;
	}

	
	public List<SelectItem> getAllEmployees(CreateShiftForm form) {
		ResultSet rs = null;
		Connection conn = null;
		DBConnectionManager manager = null;
		PreparedStatement ps = null;
		List<SelectItem> employees = null;
		try{
			manager = new DBConnectionManager();
			conn = manager.createConnection();
			ps = conn.prepareStatement(Webconstants.getallEmployees);
			ps.setInt(1, form.getLab());
			rs=ps.executeQuery();
			while(rs.next()){
				if(employees==null){
					employees= new ArrayList<SelectItem>();
				}
				
				SelectItem obj = new SelectItem(rs.getInt(1), rs.getString(2));
				employees.add(obj);
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null){
				rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				manager.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return employees;
	}
	
}

