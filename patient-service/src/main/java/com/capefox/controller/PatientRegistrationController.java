package com.capefox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capefox.entity.PatientRegistrationEntity;
import com.capefox.model.PatientChangePassword;
import com.capefox.model.PatientRegistration;
import com.capefox.service.IPetientRegistrationService;

@RestController
@RequestMapping("/patients")
public class PatientRegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(PatientRegistrationController.class);

	@Autowired
	private IPetientRegistrationService registrationService;

	@GetMapping("/all")
	public ResponseEntity<?> getAllPatientDetails() {
		List<PatientRegistrationEntity> entity = registrationService.getAllPatientDetails();
		if (!entity.isEmpty()) {
			logger.info("All patients records");
			return new ResponseEntity<>(entity, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Record Not found", HttpStatus.OK);
		}
	}
	
	@GetMapping("/by-name")
	public ResponseEntity<?> getPatientDetailByName(@RequestParam String  name) {
		PatientRegistrationEntity entity = registrationService.getPatientDetailByName(name);
		if (entity != null) {
	        logger.info("Patient records found for name: " + name);
	        return new ResponseEntity<>(entity, HttpStatus.OK);
	    } else {
	        logger.info("No patient records found for name: " + name);
	        return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> savePatientDetails(@RequestBody PatientRegistration registration){
		PatientRegistrationEntity entity=registrationService.savePatientDetails(registration);
		if (entity != null) {
			logger.info("Save All patients records");
			return new ResponseEntity<>("Record inserted Sucessfully", HttpStatus.CREATED);
		} else {
			logger.info("Failed to save record in Database");
			return new ResponseEntity<>("Record insertion Failed ", HttpStatus.OK);
		}
	}
	
	@PutMapping("/update-password")
	public ResponseEntity<?> updatePatientPassword(@RequestBody PatientChangePassword changePassword){
		PatientRegistrationEntity updatedPatient = registrationService.changePatientPassword(changePassword);
		if (updatedPatient != null) {
	        return ResponseEntity.ok("Patient password updated successfully");
	    } else {
	        return ResponseEntity.badRequest().body("Failed to update patient password");
	    }
	}
	
	@GetMapping("email-otp")
	public ResponseEntity<String> getOtpOnEmail(@RequestParam Long id){
		PatientRegistrationEntity status=registrationService.getOtpOnEmail(id);
		if(status != null) {
			return new ResponseEntity<>("One Time OTP Send on your Register Email Id",HttpStatus.OK);
		}else {
		   return new ResponseEntity<>("Issue In OTP Verification Service, Please Try Again!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
