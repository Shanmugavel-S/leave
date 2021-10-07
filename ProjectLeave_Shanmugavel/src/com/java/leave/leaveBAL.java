package com.java.leave;

import java.util.*;

public class leaveBAL {
    StringBuilder sb = new StringBuilder();
	public void addLeave(LeaveDetails leaveDetails) throws LeaveException {
        if((ValidateDetails(leaveDetails)) == true) {		
		   new leaveDAO().addLeavedao(leaveDetails); 
           System.out.println("Added Successfully :)") ;
        }else {
        	 throw new LeaveException(sb.toString());
        }
	}
	public boolean ValidateDetails(LeaveDetails leaveDetails) {
		boolean isAdded = true;
	    if(leaveDetails.getLeaveId()<=0)
	    {
	    	isAdded = false;
	        sb.append("Leave ID cannot Zero or Negative");
	    }
	    
	    if(leaveDetails.getEmpId()<=0) {
	    	isAdded = false;
	    	sb.append("Employee ID cannot Zero or Negative");
	    }
	    
	    if(leaveDetails.getLeaveReason().length() <= 3) {
	    	isAdded = false;
	    	sb.append("Reason cannot be less than 4 characters");
	    }
	    if((ValidateStart(leaveDetails.getLeaveStartDate())) == false) {
	    	isAdded = false;
	    	sb.append("Start Date cannot be Past Date!");
	    }
	    if(leaveDetails.getNoOfDays()<0) {
	    	isAdded = false;
	    	sb.append("End Date cannot be Past Date!");
	    }
		return isAdded;
	}
	public boolean ValidateStart(Date leaveStartDate) {
		boolean start = true;	
		Date today =  new Date();
		long diff = leaveStartDate.getTime() - today.getTime();
		long nod = diff / 1000 / 60 / 60 / 24;
        if(nod<0) {
        	start = false;
        }
				return start;
	}
	
	public void showLeavesBAL() {
		 new leaveDAO().showLeavesDAO();
	}
	public LeaveDetails searchLeaveBAL(int id) {
           return new leaveDAO().searchLeaveDAO(id);		
	}
	public void updateleaveBAL(LeaveDetails newld) throws LeaveException {
		if((ValidateDetails(newld)) == true) {
			new leaveDAO().updateLeaveDAO(newld);
		}else {
			throw new LeaveException(sb.toString());
		}
	}
	public void deleteLeaveBAL(int id) {
            new leaveDAO().deleteLeaveDAO(id);		
	}
	
	

}
