package co.demo.app.controller;

import co.demo.app.dto.GlobalResponse;
import co.demo.app.models.entity.Employees;
import co.demo.app.service.EmployeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/api", produces = MediaType.APPLICATION_JSON_VALUE)
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Meiman Jaya Gea",
                        email = "jayameiman17@gmail.com",
                        url = "http://localhost:8080"),
                description = "OpenApi documentation for Spring Swager-Ui",
                title = "OpenApi specification - Meiman Jaya Gea",
                version = "1.0",
                license = @License(name = "Licence url", url = "http://localhost:8080"),
                termsOfService = "Terms of service"
        ),
        servers = {@Server(description = "Local ENV",url = "http://localhost:8080")})
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

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<GlobalResponse> findEmployeeById(@PathVariable int employeeId) {
       GlobalResponse response = employeeService.getEmployeeById(employeeId);
       return ResponseEntity.ok(response);
    }

    @PostMapping("/employees")
    public ResponseEntity<GlobalResponse> insertEmployee(@RequestBody Employees employee) {
        GlobalResponse response = employeeService.addEmployee(employee);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/employees")
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
