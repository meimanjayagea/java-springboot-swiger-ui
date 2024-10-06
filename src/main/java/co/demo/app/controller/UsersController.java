package co.demo.app.controller;

import co.demo.app.dto.GlobalResponse;
import co.demo.app.models.entity.Users;
import co.demo.app.service.UsersService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
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
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<GlobalResponse> findAllEmployees() {
        GlobalResponse response = usersService.getAllUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse> findEmployeeById(@PathVariable int employeeId) {
       GlobalResponse response = usersService.getUsersById(employeeId);
       return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<GlobalResponse> insertEmployee(@RequestBody Users employee) {
        GlobalResponse response = usersService.addUsers(employee);
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<GlobalResponse> updateEmployee(@RequestBody Users employee) {
        GlobalResponse response = usersService.updateUsers(employee);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse> deleteEmployee(@PathVariable int employeeId) {
        GlobalResponse response = usersService.deleteUsers(employeeId);
        return ResponseEntity.ok(response);
    }

}
