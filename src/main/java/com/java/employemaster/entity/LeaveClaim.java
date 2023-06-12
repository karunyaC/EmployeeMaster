package com.java.employemaster.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.*;

@Entity
@Table(name="leaveClaim")
public class LeaveClaim {
	@Id
	private Long cliamId;
	private double claimAmount;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date leaveStartD;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date leaveEndD;
	private int noOfDays;
	
	public LeaveClaim() {
		super();
	}
	
	public LeaveClaim(double claimAmount, Date leaveStartD, Date leaveEndD, int noOfDays) {
		super();
		this.claimAmount = claimAmount;
		this.leaveStartD = leaveStartD;
		this.leaveEndD = leaveEndD;
		this.noOfDays = noOfDays;
	}

	public Long getCliamId() {
		return cliamId;
	}
	public void setCliamId(Long cliamId) {
		this.cliamId = cliamId;
	}
	
	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
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
	
	
	
	

}
