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

	@NotBlank(message="User name is required.!!!")
	@Size(max=15,min=6,message="User name at least 6 letters")
	private String userName;
	
	@NotBlank(message="email is required.!!!")
	@Email(message="Valid Email Format")
	private String emailId;
	
	@Pattern(regexp="\\d{10}",message="Mobile must be Valid")
	private String mobileNo;
	
	@NotEmpty(message="Gender is Required")
	private String gender;
	
	@Past(message="Date of Birth must be Past Date")
	private LocalDate birthDate;
}
