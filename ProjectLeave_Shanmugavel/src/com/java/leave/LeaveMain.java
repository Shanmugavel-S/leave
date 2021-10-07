package com.java.leave;

import java.text.*;
import java.util.*;

public class LeaveMain {
	static Scanner scan = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	static LeaveDetails ld = new LeaveDetails();
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("OPERATIONS:\n-----------");
			System.out.println("1.Show All Leaves\n2.Search Leave\n3.Add Leave\n4.Update Leave\n5.Delete Leave\n6.Exit\n");
			System.out.println("Enter your Choice:");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				showLeaves();
				break;
			case 2:
				searchLeave();
				break;
			case 3:
				try {
					try {
						addLeave();
					} catch (LeaveException e) {
                         System.out.println(e.getMessage());
					}
				} catch (ParseException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					updateLeave();
				} catch (ParseException | LeaveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				deleteLeave();
				break;
			case 6:
				System.exit(1);
			    break;
			default:
				System.out.println("Choose Correct Choice!");
			}
		}while(choice!=6);

		
	}
	private static String deleteLeave() {
               System.out.println("Enter leave id:");
               int id = scan.nextInt();
               new leaveBAL().deleteLeaveBAL(id);
               return "Deleted Successfully";
	}
	private static void updateLeave() throws ParseException, LeaveException {
		      LeaveDetails newld = new LeaveDetails();
              System.out.println("Enter Leave ID:");
              newld.setLeaveId(scan.nextInt());
              System.out.println("Enter Leave Start Date(dd-MM-yyyy):");
              String d2 = scan.next();
              newld.setLeaveStartDate(sdf.parse(d2));
              
              System.out.println("Enter Leave End Date(dd-MM-yyyy):");
              String d1 = scan.next();
              Date sdate = sdf.parse(d1);
              newld.setLeaveEndDate(sdate);
             	        
              System.out.println("Enter Employ ID:");
              newld.setEmpId(scan.nextInt());
              
              System.out.println("Enter Reason for taking leave:");
              newld.setLeaveReason(scan.next());
              
              Date today = new Date();
              newld.setLeaveAppliedOn(today);
                           
              new leaveBAL().updateleaveBAL(newld);
              
	}
	private static void addLeave() throws ParseException, LeaveException {
		System.out.println("Enter Leave ID:");
        ld.setLeaveId(scan.nextInt());
        
        System.out.println("Enter Leave Start Date(dd-MM-yyyy):");
        String d2 = scan.next();
	    ld.setLeaveStartDate(sdf.parse(d2));
        
        System.out.println("Enter Leave End Date(dd-MM-yyyy):");
        String d1 = scan.next();
        Date sdate = sdf.parse(d1);
        ld.setLeaveEndDate(sdate);
       	        
        System.out.println("Enter Employ ID:");
        ld.setEmpId(scan.nextInt());
        
        System.out.println("Enter Reason for taking leave:");
        ld.setLeaveReason(scan.next());
        
        Date today = new Date();
        ld.setLeaveAppliedOn(today);
                
        new leaveBAL().addLeave(ld);
	}
	private static void searchLeave() {
            System.out.println("Enter leave ID:");
            int id = scan.nextInt();
           LeaveDetails leavedetails = new leaveBAL().searchLeaveBAL(id);
           if(leavedetails != null) {
        	   System.out.println("LeaveID\tLeaveStartDate\t\tLeaveEndDate\t\tEmployID\t\tNoOfDays\t\tLeaveAppliedOn\n");
        	   System.out.println(leavedetails);
           }else {
        	   System.out.println("NOT FOUND");
           }
        	   
	}
	public static void showLeaves() {
		  
		  System.out.println("LeaveID\tLeaveStartDate\t\tLeaveEndDate\t\tEmployID\t\tNoOfDays\t\tLeaveAppliedOn\n");
          new leaveBAL().showLeavesBAL();		
	}

}
