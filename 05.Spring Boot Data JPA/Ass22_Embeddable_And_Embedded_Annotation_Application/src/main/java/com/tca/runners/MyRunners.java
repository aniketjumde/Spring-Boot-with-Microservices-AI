package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Address;
import com.tca.entity.Employee;
import com.tca.service.EmployeeService;

@Component
public class MyRunners implements ApplicationRunner {

	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

/*
		//TEST CASE : Save Employyes Details 
		
		Address address=new Address();
		address.setCity("Dehli");
		address.setHouseNumber("361230H");
		address.setPinCode("11303");
		address.setStreet("GN Road");
		
		Employee employee=new Employee();
		employee.setEmpName("Suyash");
		employee.setEmpSalary(60000.0);
		employee.setAddress(address);
		
		employeeService.saveEmployee(employee);
		
*/
	
		/*
		//TEST CASE : Fetched Employyes 
		
		Employee employee=employeeService.findByEmployee(1L);
		
		System.out.println("Employee ID     :"+employee.getEid());
		System.out.println("Employee Name   :"+employee.getEmpName());
		System.out.println("Employee Salary :"+employee.getEmpSalary());
//
//		Address address=employee.getAddress();
//		
//		System.out.println("Employee Address City      :"+address.getCity());
//		System.out.println("Employee Address House No  :"+address.getHouseNumber());
//		System.out.println("Employee Address Strret    :"+address.getStreet());
//		System.out.println("Employee Address  Pin Code :"+address.getPinCode());
		
		
		System.out.println("Employee Address City      :"+employee.getAddress().getCity());
		System.out.println("Employee Address House No  :"+employee.getAddress().getHouseNumber());
		System.out.println("Employee Address Strret    :"+employee.getAddress().getStreet());
		System.out.println("Employee Address  Pin Code :"+employee.getAddress().getPinCode());

*/
		
		// TEST CASE : DELETE BY ID
		
		employeeService.deleteById(4L);
		System.out.println("Employee Record is Deleted SuccessFully. !!!");
	}

}
