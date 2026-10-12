package com.tca.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@NotBlank
	@Size(min=6,max=15)
	private String userName;
	
	@Email
	@NotBlank
	private String emailId;
	
	@Pattern(regexp = "\\d{10}")
	private String mobileNo;
	
	@NotEmpty
	private String gender;
	
	@Past
	private LocalDate birthDate;
}
