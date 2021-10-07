package com.java.leave;

public class LeaveException extends Exception {

	public LeaveException() {
	}
	
     LeaveException(String error){
    	 super(error);
     }
}
