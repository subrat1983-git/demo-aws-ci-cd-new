package com.example.demo.dto;


import com.example.demo.entity.Employee;

public class EmployeeMapper {

    public static  EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(),
                employee.getFirstName(),employee.getLastName(),
                employee.getEmail());
    }

    public static  Employee EmployeeDTOToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(),
                employeeDTO.getFirstName(),employeeDTO.getLastName(),
                employeeDTO.getEmail());
    }

}
