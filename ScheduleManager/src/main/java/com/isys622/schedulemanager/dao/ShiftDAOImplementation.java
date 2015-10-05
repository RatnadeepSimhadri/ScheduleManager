package com.isys622.schedulemanager.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.isys622.schedulemanager.VO.ScheduleVO;
import com.isys622.schedulemanager.form.CreateShiftForm;
import com.isys622.schedulemanager.form.SearchScheduleForm;
import com.isys622.schedulemanager.form.ShiftForm;
import com.isys622.schedulemanager.util.DBConnectionManager;
import com.isys622.schedulemanager.util.Webconstants;

public class ShiftDAOImplementation implements ShiftDAO {

	
	public List<ShiftForm> getShiftsForADay(CreateShiftForm form) {
		ResultSet rs = null;
		Connection conn = null;
		DBConnectionManager manager = null;
		PreparedStatement ps = null;
		List<ShiftForm> shifts = null;
		try{
			manager = new DBConnectionManager();
			conn = manager.createConnection();
			ps = conn.prepareStatement(Webconstants.getallShifts);
			ps.setInt(1, form.getLab());
			ps.setInt(2, form.getDate().getDay());
			rs=ps.executeQuery();
			while(rs.next()){
				if(shifts==null){
					shifts= new ArrayList<ShiftForm>();
				}
				
				ShiftForm obj = new ShiftForm();
				obj.setShiftNo(rs.getInt("shift_no"));
				obj.setStartTime(rs.getString("start_time"));
				obj.setEndTime(rs.getString("end_time"));
				shifts.add(obj);
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

		return shifts;
	}

	
	public String saveShifts(CreateShiftForm form,
			Map<Integer, Integer> shiftMap) {
		Connection conn = null;
		DBConnectionManager manager = null;
		CallableStatement cs = null;
		String result = null;
		try{
			manager = new DBConnectionManager();
			conn = manager.createConnection();
			conn.setAutoCommit(false);
			 Iterator it = shiftMap.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pairs = (Map.Entry)it.next();
			        cs = conn.prepareCall(Webconstants.saveallShiftDetails);
			        cs.setDate(1, new java.sql.Date(form.getDate().getTime()));
			        cs.setInt(2, form.getLab());
			        cs.setInt(3, (Integer)pairs.getKey());
			        cs.setInt(4, (Integer)pairs.getValue());
			        	
			        cs.execute();
			    }
			
			    conn.commit();
			    result = "Schedule saved for the Day";
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			try {
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

	
	public void getScheduleforDay(SearchScheduleForm form) {
		ResultSet rs = null;
		Connection conn = null;
		DBConnectionManager manager = null;
		PreparedStatement ps = null;
		List<ScheduleVO> schedules = null;
		try{
			manager = new DBConnectionManager();
			conn = manager.createConnection();
			ps = conn.prepareStatement(Webconstants.getSchedule);
			ps.setDate(1, new java.sql.Date(form.getDate().getTime()) );
			ps.setString(2, form.getName());
			rs=ps.executeQuery();
			while(rs.next()){
				if(schedules == null){
					schedules = new ArrayList<ScheduleVO>();
				}
				
				ScheduleVO obj = new ScheduleVO();
				obj.setStartTime(rs.getString("start_time"));
				obj.setEndTime(rs.getString("end_time"));
				obj.setShiftNumber(rs.getInt("shift_no"));
				form.setName(rs.getString("first_name"));
				form.setLabName(rs.getString("name"));
				schedules.add(obj);
			}
			
		form.setSchedule(schedules);
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

		
	}
	
}

