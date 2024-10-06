package co.demo.app.service.impl;

import co.demo.app.dto.GlobalResponse;
import co.demo.app.models.entity.Employees;
import co.demo.app.models.repository.EmployeeRepository;
import co.demo.app.service.EmployeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeHandler implements EmployeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeHandler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public GlobalResponse getAllEmployees() {
        GlobalResponse globalResponse = new GlobalResponse();

        try{
            List<Employees> employees = employeeRepository.findAll();
            if(employees.isEmpty()){
                globalResponse.setResponseMessage("Not Found");
                globalResponse.setResponseCode("00");
                globalResponse.setData(null);
            }
            globalResponse.setResponseMessage("Success");
            globalResponse.setResponseCode("00");
            globalResponse.setData(employees);
        }catch (Exception e){
            globalResponse.setResponseMessage("Error");
            globalResponse.setResponseCode("01");
            globalResponse.setData(e);
        }

        return globalResponse;
    }

    @Override
    public GlobalResponse getEmployeeById(int id) {
        GlobalResponse globalResponse = new GlobalResponse();
        try {
            Employees employee = employeeRepository.findById(id).orElse(null);
            if(employee == null){
                globalResponse.setResponseMessage("Not Found");
                globalResponse.setResponseCode("00");
                globalResponse.setData(null);
            }
            globalResponse.setResponseMessage("Success");
            globalResponse.setResponseCode("00");
            globalResponse.setData(employee);
        }catch (Exception e){
            globalResponse.setResponseMessage("Error");
            globalResponse.setResponseCode("01");
            globalResponse.setData(e);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse addEmployee(Employees employee) {
        GlobalResponse globalResponse = new GlobalResponse();
        try {
            Employees employe = employeeRepository.save(employee);
            globalResponse.setResponseMessage("Success");
            globalResponse.setResponseCode("00");
            globalResponse.setData(employe);
        }catch (Exception e){
            globalResponse.setResponseMessage("Error");
            globalResponse.setResponseCode("01");
            globalResponse.setData(e);
        }
        return globalResponse;
    }

    @Override
    @Transactional
    public GlobalResponse updateEmployee(Employees employe) {
        GlobalResponse globalResponse = new GlobalResponse();
        try{
            Employees employee = employeeRepository.findById(employe.getId()).orElse(null);
            if(employee == null){
                globalResponse.setResponseMessage("Not Found");
                globalResponse.setResponseCode("00");
                globalResponse.setData(null);
            }
            Employees newEmploy = employeeRepository.save(employe);
            globalResponse.setResponseMessage("Success");
            globalResponse.setResponseCode("00");
            globalResponse.setData(newEmploy);
        }catch (Exception e){
            globalResponse.setResponseMessage("Error");
            globalResponse.setResponseCode("01");
            globalResponse.setData(e);
        }
        return globalResponse;
    }

    @Override
    public GlobalResponse deleteEmployee(int id) {
        GlobalResponse globalResponse = new GlobalResponse();
        try {
            GlobalResponse employe = getEmployeeById(id);
            if(employe != null){
                employeeRepository.deleteById(id);
                globalResponse.setResponseMessage("Success");
                globalResponse.setResponseCode("00");
                Object data = "Data Employ has been deleted";
                globalResponse.setData(data);
            }
            globalResponse.setResponseMessage("Not Found");
            globalResponse.setResponseCode("00");
            globalResponse.setData(null);

        }catch (Exception e){
            globalResponse.setResponseMessage("Error");
            globalResponse.setResponseCode("01");
            globalResponse.setData(e);
        }
        return globalResponse;
    }
}
