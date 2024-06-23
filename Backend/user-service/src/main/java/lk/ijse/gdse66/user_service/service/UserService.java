package lk.ijse.gdse66.user_service.service;

import lk.ijse.gdse66.user_service.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(String userId);

    UserDTO saveUser (UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(String userId);
}
