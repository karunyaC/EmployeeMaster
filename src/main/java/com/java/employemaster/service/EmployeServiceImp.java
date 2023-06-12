package com.java.employemaster.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.employemaster.dto.EmployeeResponse;
import com.java.employemaster.entity.EmployeeMaster;
import com.java.employemaster.entity.LeaveClaim;
import com.java.employemaster.repositry.EmployeeMasterRepositry;
import com.java.employemaster.repositry.LeaveClaimRepositry;

@Service
public class EmployeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeMasterRepositry rep;
	@Autowired
	private LeaveClaimRepositry repositry;

	@Override
	public LeaveClaim saveClaim(Long emLong, LeaveClaim leaveclaim) {
		
		EmployeeMaster em =rep.findById(emLong).orElse(null);
		if(em !=null) {
			double ClaimAmount =0;
			LocalDate currentDate= LocalDate.now();
			LocalDate manualDate = convertToLocalDate(leaveclaim.getLeaveEndD());
			if(!currentDate.equals(manualDate)) {
				 ClaimAmount =(0.3*em.getBasicpay())*leaveclaim.getNoOfDays();
			}
			else {
				ClaimAmount =leaveclaim.getClaimAmount();
			}
			leaveclaim.setClaimAmount(ClaimAmount);
			
		}else {
			throw new IllegalArgumentException("In valid Emp_id"+emLong);
		}
		return repositry.save(leaveclaim);
	}
	
	@Override
	public EmployeeMaster saveEmp(EmployeeMaster emp) {
		return rep.save(emp);
	}
	
	@Override
	public List<LeaveClaim> getAllLeave() {
		// TODO Auto-generated method stub
		return repositry.findAll();
	}

	@Override
	public List<EmployeeMaster> getAllEmp() {
		return rep.findAll();
	}
	private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

	@Override
	public EmployeeResponse findByIdClaim(Long id) {
		EmployeeResponse response =new EmployeeResponse();
		Optional<LeaveClaim> optionalLeave =repositry.findById(id);
		if(optionalLeave.isPresent()) {
			LeaveClaim employee =optionalLeave.get();
			response.setClaimAmount(employee.getClaimAmount());
			response.setClaimId(employee.getCliamId());
			response.setLeaveStartD(employee.getLeaveStartD());
			response.setLeaveEndD(employee.getLeaveEndD());
			response.setNoOfDays(employee.getNoOfDays());
		}
		else {
			throw new IllegalArgumentException("Invalide EmployeeID ="+id);
		}
		return response;
	}

}
