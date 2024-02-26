package com.capefox.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PatientRegistration {

	//private Long id;
	
	@NotEmpty(message = "Name should not be Empty")
	private String name;
	
	@NotEmpty(message = "Gender should not be Empty")
	private String gender;
	
	@NotEmpty(message = "DateOfBirth should not be Empty")
	private String dateOfBirth;
	
	@NotEmpty(message = "Contact Number should not be Empty")
	private String contactNumber;
	
	@NotEmpty(message = "Address should not be Empty")
	private String address;
	
	@NotEmpty(message = "Emergency Contact not be Empty")
	private String emergencyContact;
	
}
