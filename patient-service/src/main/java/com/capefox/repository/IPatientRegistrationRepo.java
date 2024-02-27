package com.capefox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capefox.entity.PatientRegistrationEntity;

@Repository
public interface IPatientRegistrationRepo extends JpaRepository<PatientRegistrationEntity, Long> {

	PatientRegistrationEntity findByName(String name);

	PatientRegistrationEntity save(String newPasswordEncoded);
	
	

}
