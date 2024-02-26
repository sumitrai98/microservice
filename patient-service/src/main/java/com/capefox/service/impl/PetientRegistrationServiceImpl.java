package com.capefox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capefox.entity.PatientRegistrationEntity;
import com.capefox.model.PatientRegistration;
import com.capefox.repository.IPatientRegistrationRepo;
import com.capefox.service.IPetientRegistrationService;

@Service
public class PetientRegistrationServiceImpl implements IPetientRegistrationService {

	@Autowired
	private IPatientRegistrationRepo patientRepo;

	@Override
	public List<PatientRegistrationEntity> getAllPatientDetails() {
		return patientRepo.findAll();
	}

	@Override
	public PatientRegistrationEntity savePatientDetails(PatientRegistration patient) {

		PatientRegistrationEntity existingEntity = patientRepo.findByName(patient.getName());
		if (existingEntity != null) {
			return null;
		} else {
			PatientRegistrationEntity entity = new PatientRegistrationEntity();
			entity.setName(patient.getName());
			entity.setGender(patient.getGender());
			entity.setAddress(patient.getAddress());
			entity.setDateOfBirth(patient.getDateOfBirth());
			entity.setContactNumber(patient.getContactNumber());
			entity.setEmergencyContact(patient.getEmergencyContact());
			PatientRegistrationEntity saveDetails = patientRepo.save(entity);
			return saveDetails;
		}
	}

	@Override
	public PatientRegistrationEntity getPatientDetailByName(String name) {
		PatientRegistrationEntity byName = patientRepo.findByName(name);
		return byName;
	}

}
