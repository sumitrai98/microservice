package com.capefox.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PatientChangePassword {

    @NotEmpty
	private String name;
    
    @NotEmpty
	private String oldPassword;
    
    @NotEmpty
	private String newPassword;
}
