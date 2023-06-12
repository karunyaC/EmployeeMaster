package com.java.employemaster.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.*;
@Entity
@Table(name ="employeMaster")
public class EmployeeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String empName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date doB;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date doJ;
	private double basicpay;
	@OneToMany(targetEntity = LeaveClaim.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name="emp_Id",referencedColumnName = "empId")
	private List<LeaveClaim> leaveClaim;
	public EmployeeMaster() {
		super();
	}
	public EmployeeMaster(String empName, Date doB, Date doJ, double basicpay, List<LeaveClaim> leaveClaim) {
		super();
		this.empName = empName;
		this.doB = doB;
		this.doJ = doJ;
		this.basicpay = basicpay;
		this.leaveClaim = leaveClaim;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getDoB() {
		return doB;
	}
	public void setDoB(Date doB) {
		this.doB = doB;
	}
	public Date getDoJ() {
		return doJ;
	}
	public void setDoJ(Date doJ) {
		this.doJ = doJ;
	}
	public double getBasicpay() {
		return basicpay;
	}
	public void setBasicpay(double basicpay) {
		this.basicpay = basicpay;
	}
	public List<LeaveClaim> getLeaveClaim() {
		return leaveClaim;
	}
	public void setLeaveClaim(List<LeaveClaim> leaveClaim) {
		this.leaveClaim = leaveClaim;
	}
	
	

}
