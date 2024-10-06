package co.demo.app.service.impl;

import co.demo.app.dto.GlobalResponse;
import co.demo.app.models.entity.Users;
import co.demo.app.models.repository.UsersRepository;
import co.demo.app.service.UsersService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersHandler implements UsersService {
    private final UsersRepository usersRepository;

    public UsersHandler(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public GlobalResponse getAllUsers() {
        GlobalResponse globalResponse = new GlobalResponse();

        try{
            List<Users> employees = usersRepository.findAll();
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
    public GlobalResponse getUsersById(int id) {
        GlobalResponse globalResponse = new GlobalResponse();
        try {
            Users employee = usersRepository.findById(id).orElse(null);
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
    public GlobalResponse addUsers(Users employee) {
        GlobalResponse globalResponse = new GlobalResponse();
        try {
            Users employe = usersRepository.save(employee);
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
    public GlobalResponse updateUsers(Users employe) {
        GlobalResponse globalResponse = new GlobalResponse();
        try{
            Users employee = usersRepository.findById(employe.getId()).orElse(null);
            if(employee == null){
                globalResponse.setResponseMessage("Not Found");
                globalResponse.setResponseCode("00");
                globalResponse.setData(null);
            }
            Users newEmploy = usersRepository.save(employe);
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
    public GlobalResponse deleteUsers(int id) {
        GlobalResponse globalResponse = new GlobalResponse();
        try {
            GlobalResponse employe = getUsersById(id);
            if(employe != null){
                usersRepository.deleteById(id);
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
