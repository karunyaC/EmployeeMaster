package com.java.employemaster.service;

import com.java.employemaster.dto.EmployeeResponse;
import com.java.employemaster.entity.EmployeeMaster;
import com.java.employemaster.entity.LeaveClaim;

import java.util.*;
public interface EmployeeService {
	public LeaveClaim saveClaim(Long emLong,LeaveClaim leaveclaim);
	public List<LeaveClaim> getAllLeave();
	public EmployeeMaster saveEmp(EmployeeMaster emp);
    public List<EmployeeMaster> getAllEmp();
    public EmployeeResponse findByIdClaim(Long id);

}
