package co.demo.app.service;

import co.demo.app.dto.GlobalResponse;
import co.demo.app.models.entity.Employees;
import jakarta.transaction.Transactional;

public interface EmployeService {
    GlobalResponse getAllEmployees();

    GlobalResponse getEmployeeById(int id);

    GlobalResponse addEmployee(Employees employee);

    GlobalResponse updateEmployee(Employees employee);

    GlobalResponse deleteEmployee(int id);

}
