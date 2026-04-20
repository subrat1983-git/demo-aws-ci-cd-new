package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeMapper;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.EmpRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmpRepo employeeRepository;

    public EmployeeServiceImpl(EmpRepo employeeRepository) {

        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
      Employee employee =  EmployeeMapper.EmployeeDTOToEmployee(employeeDTO);
      Employee employeeSaved = employeeRepository.save(employee);
      return  EmployeeMapper.employeeToEmployeeDTO(employeeSaved);

    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
      Employee employee = employeeRepository.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException("The Given Employee Not Found :"+id));
      return  EmployeeMapper.employeeToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList  = employeeList.stream().map( e->
            EmployeeMapper.employeeToEmployeeDTO(e)
        ).collect(Collectors.toList());
        return  employeeDTOList;
    }

    @Override
    public EmployeeDTO updateEmployee(Long id,EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException("The Given Employee Not Found :"+id));
        employee.setEmail(employeeDTO.getEmail());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employeeRepository.save(employee);

        return EmployeeMapper.employeeToEmployeeDTO(employee);
    }

    @Override
    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);


    }
}
