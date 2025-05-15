package com.bose.ems.controller;

import com.bose.ems.dto.EmployeeDto;
import com.bose.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{EmployeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long EmployeeId){
        EmployeeDto foundEmployee = employeeService.getEmployeeById(EmployeeId);
        return new ResponseEntity<>(foundEmployee,HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.FOUND);
    }

    @PutMapping("/{EmployeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long EmployeeId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployee = employeeService.updateEmployee(EmployeeId, employeeDto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{EmployeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long EmployeeId){
        EmployeeDto deletedEmployee = employeeService.deleteEmployee(EmployeeId);
//        return new ResponseEntity<>(deletedEmployee, HttpStatus.OK);
        return ResponseEntity.ok("Employee Deleted Successfully !!");
    }
}
