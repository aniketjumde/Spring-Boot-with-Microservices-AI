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

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	@NotBlank
	@Size(max=15,min=6)
	private String userName;
	
	@NotBlank
	@Email
	private String emailId;
	
	@Pattern(regexp="\\d{10}")
	private String mobileNo;
	
	@NotEmpty
	private String gender;
	
	@Past
	private LocalDate birthDate;
}
