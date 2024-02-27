package com.capefox.service.impl;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capefox.common.EmailSender;
import com.capefox.entity.PatientRegistrationEntity;
import com.capefox.model.PatientChangePassword;
import com.capefox.model.PatientRegistration;
import com.capefox.repository.IPatientRegistrationRepo;
import com.capefox.service.IPetientRegistrationService;

@Service
public class PetientRegistrationServiceImpl implements IPetientRegistrationService {

	@Autowired
	private IPatientRegistrationRepo patientRepo;

	@Autowired
	private EmailSender emailSender;

	@Override
	public List<PatientRegistrationEntity> getAllPatientDetails() {
		return patientRepo.findAll();
	}

	@Override
	public PatientRegistrationEntity savePatientDetails(PatientRegistration patient) {

		/*Optional<PatientRegistrationEntity> existingEntity = patientRepo.findById(patient.getId());
		if (existingEntity != null) {
			return null;
		} else {*/
		PatientRegistrationEntity entity = new PatientRegistrationEntity();
		entity.setName(patient.getName());
		entity.setGender(patient.getGender());
		entity.setAddress(patient.getAddress());
		entity.setDateOfBirth(patient.getDateOfBirth());
		entity.setContactNumber(patient.getContactNumber());
		entity.setEmergencyContact(patient.getEmergencyContact());
		entity.setPassword(patient.getPassword());
		entity.setEmail(patient.getEmail());
		PatientRegistrationEntity saveDetails = patientRepo.save(entity);
		return saveDetails;
		// }
	}

	@Override
	public PatientRegistrationEntity getPatientDetailByName(String name) {
		PatientRegistrationEntity byName = patientRepo.findByName(name);
		return byName;
	}

	@Override
	public PatientRegistrationEntity changePatientPassword(PatientChangePassword changePassword) {
		if (changePassword != null && changePassword.getName() != null && changePassword.getOldPassword() != null
				&& changePassword.getNewPassword() != null) {
			PatientRegistrationEntity entity = patientRepo.findByName(changePassword.getName());
			if (entity != null) {
				if (changePassword.getOldPassword().equals(entity.getPassword())) {
					entity.setPassword(changePassword.getNewPassword());
					PatientRegistrationEntity updatedEntity = patientRepo.save(entity);
					return updatedEntity;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public PatientRegistrationEntity getOtpOnEmail(Long id) {
		Optional<PatientRegistrationEntity> optionalEntity = patientRepo.findById(id);
		if (optionalEntity.isPresent()) {
			PatientRegistrationEntity entity = optionalEntity.get();
			String otp = generateOTP();
			emailSender.sendEmail(otp, entity.getEmail(), entity.getName() + " " + entity.getAddress());

			long currentTimeMillis = System.currentTimeMillis() + 600000;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date expiryDate = new Date(currentTimeMillis);
			String otpExpDate = dateFormat.format(expiryDate);

			entity.setEmailOtp(otp);
			entity.setEmailOtpExpiry(otpExpDate);

			PatientRegistrationEntity updatedEntity = patientRepo.save(entity);
			return updatedEntity;
		} else {
			return null;
		}
	}

	private String generateOTP() {
		String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
		return otp;
	}
}
