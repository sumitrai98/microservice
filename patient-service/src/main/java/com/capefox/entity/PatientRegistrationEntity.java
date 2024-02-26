package com.capefox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PATIENTS")
@AllArgsConstructor
@NoArgsConstructor
public class PatientRegistrationEntity {

	@Id
	@Column(name = "PATIENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMERGENCY_CONTACT")
	private String emergencyContact;

	

}
