package com.tca.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.model.Employee;
import com.tca.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public Employee fetchById(Integer empno) {

        log.info("fetchById() - Request received to fetch employee: empno={}",empno);

        log.debug("fetchById() - Searching employee in database: empno={}",empno);

        Employee employee =employeeRepository.findById(empno).orElse(null);

        if (employee != null) 
        {

            log.info("fetchById() - Employee found successfully: empno={}",
                    empno);

            log.debug("fetchById() - Employee details: {}", employee);

            return employee;

        } else 
        {

            log.warn("fetchById() - Employee not found: empno={}", empno);
            
            return null;

        }

	}

	@Override
	public List<Employee> fetchAllEmployees() {
		
		log.info("fetchAllEmployees() - Fetching all employee records");

        log.debug("fetchAllEmployees() - Calling EmployeeRepository");
        
		
		List<Employee> empList=employeeRepository.findAll();
		
		if(!empList.isEmpty())
		{

            log.info("fetchAllEmployees() - Successfully fetched {} employee records",empList.size());
            
            log.debug("fetchAllEmployees() - Employee list: {}", empList);
            
			return empList;
		}
		else {

            log.warn("fetchAllEmployees() - No employee records available in database");

            return empList;
        }
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		  log.info("saveEmployee() - Request received to save employee: empno={}",employee.getEmpno());

	      log.debug("saveEmployee() - Checking employee existence: empno={}", employee.getEmpno());
		
		if(employeeRepository.existsById(employee.getEmpno()))
		{

            log.warn( "saveEmployee() - Employee already exists. Cannot create duplicate: empno={}",employee.getEmpno());

            return null;
		}
		else
		{
			log.debug("saveEmployee() - Saving new employee: empno={}", employee.getEmpno());

            Employee savedEmployee =employeeRepository.save(employee);

            log.info(  "saveEmployee() - Employee saved successfully: empno={}",savedEmployee.getEmpno());

            return savedEmployee;
		}
		
	}

	@Override
	public Boolean deleteById(Integer id) {


        log.info("deleteById() - Request received to delete employee: empno={}", id);

        log.debug("deleteById() - Checking employee existence: empno={}", id);
		
		if(employeeRepository.existsById(id))
		{
			log.debug("deleteById() - Employee found. Deleting record: empno={}", id);

            employeeRepository.deleteById(id);

            log.info( "deleteById() - Employee deleted successfully: empno={}",id);

            return true;
		}
		else
		{
			 log.warn("deleteById() - Employee not found. Deletion failed: empno={}",id);

	            return false;
		}
		
	}


    @Override
    public Employee updateEmployee(Employee employee) {

        log.info(
                "updateEmployee() - Request received to update employee: empno={}",
                employee.getEmpno());

        log.debug(
                "updateEmployee() - Checking employee existence: empno={}",
                employee.getEmpno());

        if (employeeRepository.existsById(employee.getEmpno())) {

            log.debug(
                    "updateEmployee() - Employee found. Updating record: empno={}",
                    employee.getEmpno());

            Employee updatedEmployee =
                    employeeRepository.save(employee);

            log.info(
                    "updateEmployee() - Employee updated successfully: empno={}",
                    updatedEmployee.getEmpno());

            log.debug(
                    "updateEmployee() - Updated employee details: {}",
                    updatedEmployee);

            return updatedEmployee;

        } else {

            log.warn(
                    "updateEmployee() - Employee not found. Update failed: empno={}",
                    employee.getEmpno());

            return null;
        }
    }


    // ==========================================
    // PARTIAL UPDATE EMPLOYEE (PATCH)
    // ==========================================

    @Override
    public Employee updateEmployeeById( Map<String, Object> fieldMap, Integer id) {

        log.info( "updateEmployeeById() - Partial update request received: empno={}",id);

        log.debug( "updateEmployeeById() - Fields requested for update: {}", fieldMap.keySet());

        if (employeeRepository.existsById(id)) {

            log.debug( "updateEmployeeById() - Employee found. Processing partial update: empno={}",id);

            Double sal = (Double) fieldMap.get("esalary");

            Integer deptNo = (Integer) fieldMap.get("deptNo");

            log.debug("updateEmployeeById() - Updating employee salary and department: empno={}",id);

            employeeRepository.updateEmployeeById(sal, deptNo, id);

            Employee updatedEmployee = employeeRepository.findById(id).orElse(null);

            if (updatedEmployee != null) {

                log.info(   "updateEmployeeById() - Employee partially updated successfully: empno={}", id);

                log.debug( "updateEmployeeById() - Updated employee details: {}",updatedEmployee);

                return updatedEmployee;
            }

            log.error("updateEmployeeById() - Employee not found after update operation: empno={}",  id);

            return null;

        } else {

            log.warn("updateEmployeeById() - Employee not found. Partial update failed: empno={}",id);

            return null;
        }
    }

}
