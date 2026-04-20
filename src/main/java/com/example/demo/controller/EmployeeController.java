package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {

        EmployeeDTO savedEmployeeDTO =  employeeService.createEmployee(employeeDTO);

        return  new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Long id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);

        return  new ResponseEntity<>(employeeDTO,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployee() {
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployee();

        return  new ResponseEntity<>(employeeDTOList,HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>   deleteEmployee(Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
