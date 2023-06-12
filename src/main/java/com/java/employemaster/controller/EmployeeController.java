package com.java.employemaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.employemaster.dto.EmployeeResponse;
import com.java.employemaster.entity.EmployeeMaster;
import com.java.employemaster.entity.LeaveClaim;
import com.java.employemaster.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/add/{id}")
	public ResponseEntity<LeaveClaim> saveLeavaClaim(@PathVariable long id,@RequestBody LeaveClaim leavclaim){
		LeaveClaim lev =service.saveClaim(id, leavclaim);
		if(lev == null) {
			return new ResponseEntity<LeaveClaim>(lev,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LeaveClaim>(lev,HttpStatus.ACCEPTED);
		
	}
	@PostMapping("/addemp")
	public ResponseEntity<EmployeeMaster> saveEmp(@RequestBody EmployeeMaster emp){
		EmployeeMaster lev =service.saveEmp(emp);
		if(lev == null) {
			return new ResponseEntity<EmployeeMaster>(lev,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EmployeeMaster>(lev,HttpStatus.CREATED);
		
	}
	@GetMapping("/fetchAll")
	public ResponseEntity<?> getAllLeav(){
		List<LeaveClaim> list =service.getAllLeave();
		return new ResponseEntity<Object>(list,HttpStatus.ACCEPTED);
	}
	@GetMapping("/AllEmp")
	public ResponseEntity<?> getAllEmp(){
		List<EmployeeMaster> list =service.getAllEmp();
		return new ResponseEntity<Object>(list,HttpStatus.ACCEPTED);
	}
	@GetMapping("/fetch/{id}")
	public ResponseEntity<EmployeeResponse> getByEmplREspId(@PathVariable Long id){
		EmployeeResponse em =service.findByIdClaim(id);
		return new ResponseEntity<EmployeeResponse>(em,HttpStatus.ACCEPTED);
	}
}
