package com.java.employemaster.dto;

import java.util.Date;

public class EmployeeResponse {
	private Long claimId;
	private double claimAmount;
	private Date leaveStartD;
	private Date leaveEndD;
	private int noOfDays;
	public EmployeeResponse() {
		super();
	}
	public EmployeeResponse(double claimAmount, Date leaveStartD, Date leaveEndD, int noOfDays) {
		super();
		this.claimAmount = claimAmount;
		this.leaveStartD = leaveStartD;
		this.leaveEndD = leaveEndD;
		this.noOfDays = noOfDays;
	}
	public Long getClaimId() {
		return claimId;
	}
	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public Date getLeaveStartD() {
		return leaveStartD;
	}
	public void setLeaveStartD(Date leaveStartD) {
		this.leaveStartD = leaveStartD;
	}
	public Date getLeaveEndD() {
		return leaveEndD;
	}
	public void setLeaveEndD(Date leaveEndD) {
		this.leaveEndD = leaveEndD;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	

}
