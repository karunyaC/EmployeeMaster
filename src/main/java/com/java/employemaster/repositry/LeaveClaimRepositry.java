package com.java.employemaster.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.employemaster.dto.EmployeeResponse;
import com.java.employemaster.entity.LeaveClaim;

@Repository
public interface LeaveClaimRepositry extends JpaRepository<LeaveClaim,Long>{

}
