package com.java.employemaster.repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.employemaster.entity.EmployeeMaster;

@Repository
public interface EmployeeMasterRepositry extends JpaRepository<EmployeeMaster,Long>{
	//public EmployeeMaster getById(Long id);
}
