package com.java.leave;

import java.util.*;
import java.text.*;

public class leaveDAO {
	
	static List<LeaveDetails> leavelist = new ArrayList<LeaveDetails>();
	

	public static void addLeavedao(LeaveDetails leaveDetails) {
		leavelist.add(leaveDetails);
        long diff = (leaveDetails.getLeaveEndDate().getTime()) - (leaveDetails.getLeaveStartDate().getTime());
        long newdiff = diff / 1000 / 60 / 60 / 24;
        int nod = (int)newdiff;
        new LeaveDetails().setNoOfDays(nod++);
	}
	
	public void showLeavesDAO() {
		for (LeaveDetails leaveDetails : leavelist) {
			System.out.println(leaveDetails);
		}
	}

	public LeaveDetails searchLeaveDAO(int id) {
           LeaveDetails leave = null;
           for (LeaveDetails l : leavelist) {
        	   if( l.getLeaveId() == id )
        		   {   leave = l;	}
           }
           
		return leave;
	}

	public void updateLeaveDAO(LeaveDetails newld) {
                LeaveDetails old = searchLeaveDAO(newld.getLeaveId());
                if(old!=null) {
                	old.setLeaveId(newld.getLeaveId());
                	old.setEmpId(newld.getEmpId());
                	old.setLeaveStartDate(newld.getLeaveStartDate());
                	old.setLeaveEndDate(newld.getLeaveEndDate());
                	old.setLeaveReason(newld.getLeaveReason());
                	old.setNoOfDays(newld.getNoOfDays());
                	System.out.println("Updated Successfully");
                }
	}

	public void deleteLeaveDAO(int id) {
           LeaveDetails leave = searchLeaveDAO(id);
           if(leave != null) {
        	   leavelist.remove(leave);
        	  System.out.println("deleted !!");
           }
           else {
        	   System.out.println("Not Found");
           }
	}
	

}
