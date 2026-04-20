package com.example.demo.service;



import com.example.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployee(Long id,EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);


}
