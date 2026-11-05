package com.tca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "emp")
@Schema(description = "Employee entity containing employee details")
public class Employee {

    @Id
    @Schema(
        description = "Unique employee ID",
        example = "101",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer empno;

    @Schema(
        description = "Name of the employee",
        example = "Aniket"
    )
    private String ename;

    @Schema(
        description = "Salary of the employee",
        example = "45000.0"
    )
    private Double esalary;

    @Schema(
        description = "Department number of the employee",
        example = "10"
    )
    private Integer deptNo;

}