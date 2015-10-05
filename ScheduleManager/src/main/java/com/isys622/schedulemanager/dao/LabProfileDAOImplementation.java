package com.isys622.schedulemanager.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.isys622.schedulemanager.VO.ProfileVO;
import com.isys622.schedulemanager.form.LabProfileForm;
import com.isys622.schedulemanager.form.SelectItem;
import com.isys622.schedulemanager.form.ShiftForm;
import com.isys622.schedulemanager.util.DBConnectionManager;
import com.isys622.schedulemanager.util.Webconstants;

public class LabProfileDAOImplementation implements LabProfileDAO {
	/**
		 * This method returns a list of all orders from the database.
		 * @return a list of Order objects.
		 */
		public String createLabProfile(LabProfileForm form) {
	
			ResultSet rs = null;
			CallableStatement cs = null;
			Connection conn = null;
			DBConnectionManager manager = null;
			PreparedStatement ps = null; 
			String status=null;
			try {
	
				manager = new DBConnectionManager();
				conn = manager.createConnection();
				conn.setAutoCommit(false);
				
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
			       
			        cs = conn.prepareCall(Webconstants.createLabProfile);
			        cs.setString(1, form.getLabName());
			        cs.setInt(2, form.getAddress().getId());
			        cs.setInt(3, form.getManager());
			       
			        cs.executeQuery();
			        conn.commit();
			        status = "Lab Created Successfully";
				
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
			return status;
		}

	
	public List<SelectItem> getAll() {
		
		ResultSet rs = null;
		Connection conn = null;
		DBConnectionManager manager = null;
		PreparedStatement ps = null;
		List<SelectItem> labs = null;
		try{
			manager = new DBConnectionManager();
			conn = manager.createConnection();
			ps = conn.prepareStatement(Webconstants.getallLabs);
			rs=ps.executeQuery();
			while(rs.next()){
				if(labs==null){
					labs= new ArrayList<SelectItem>();
				}
				
				SelectItem obj = new SelectItem(rs.getInt(1), rs.getString(2));
				labs.add(obj);
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

		return labs;
	}

	
	public String saveShiftDetails(LabProfileForm form) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		CallableStatement cs = null;
		Connection conn = null;
		DBConnectionManager manager = null;
		String result="";
		ProfileVO profile = null;
		try {

			manager = new DBConnectionManager();
			conn = manager.createConnection();
			conn.setAutoCommit(false);
			List<ShiftForm> shifts = form.getAllShifts();
			for (Iterator iterator = shifts.iterator(); iterator.hasNext();) {
				ShiftForm shiftForm = (ShiftForm) iterator.next();
				if(shiftForm.isSelected()){
					cs = conn.prepareCall(Webconstants.savelabshifts);
					cs.setInt(1, shiftForm.getShiftNo());
					cs.setInt(2, form.getLabId());
					cs.setInt(3, form.getDay());
					cs.setString(4, shiftForm.getStartTime());
					cs.setString(5, shiftForm.getEndTime());
					
					cs.executeQuery();
					
				}
				
			}

			conn.commit();
			result="Lab Shifts for the day are saved";
			
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
				manager.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
	
}

