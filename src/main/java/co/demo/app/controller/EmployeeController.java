package co.demo.app.controller;

import co.demo.app.dto.GlobalResponse;
import co.demo.app.models.entity.Employees;
import co.demo.app.service.EmployeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/v1/api")
public class EmployeeController {
    private final EmployeService employeeService;

    public EmployeeController(EmployeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<GlobalResponse> findAllEmployees() {
        GlobalResponse response = employeeService.getAllEmployees();
        return ResponseEntity.ok(response);
    }

    @GetMapping("employees/{employeeId}")
    public ResponseEntity<GlobalResponse> findEmployeeById(@PathVariable int employeeId) {
       GlobalResponse response = employeeService.getEmployeeById(employeeId);
       return ResponseEntity.ok(response);
    }

    @PostMapping("employees")
    public ResponseEntity<GlobalResponse> insertEmployee(@RequestBody Employees employee) {
        GlobalResponse response = employeeService.addEmployee(employee);
        return ResponseEntity.ok(response);
    }

    @PutMapping("employees/{employeeId}")
    public ResponseEntity<GlobalResponse> updateEmployee(@RequestBody Employees employee) {
        GlobalResponse response = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<GlobalResponse> deleteEmployee(@PathVariable int employeeId) {
        GlobalResponse response = employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok(response);
    }

}
