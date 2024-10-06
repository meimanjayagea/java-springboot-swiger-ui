package co.demo.app.service;

import co.demo.app.dto.GlobalResponse;
import co.demo.app.models.entity.Users;

public interface UsersService {
    GlobalResponse getAllUsers();

    GlobalResponse getUsersById(int id);

    GlobalResponse addUsers(Users employee);

    GlobalResponse updateUsers(Users employee);

    GlobalResponse deleteUsers(int id);

}
