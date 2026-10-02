package com.tca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	private String userName;
	private String emailId;
	private Long mobileNo;
	private String gender;
}
