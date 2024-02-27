package com.capefox.service;

import java.util.List;

import com.capefox.entity.PatientRegistrationEntity;
import com.capefox.model.PatientChangePassword;
import com.capefox.model.PatientRegistration;

public interface IPetientRegistrationService {

	public List<PatientRegistrationEntity> getAllPatientDetails();
	
	public PatientRegistrationEntity getPatientDetailByName(String name);
	
	public PatientRegistrationEntity savePatientDetails(PatientRegistration patient);
	
	public PatientRegistrationEntity changePatientPassword(PatientChangePassword changePassword);
	
	public PatientRegistrationEntity getOtpOnEmail(Long id);
	
}
