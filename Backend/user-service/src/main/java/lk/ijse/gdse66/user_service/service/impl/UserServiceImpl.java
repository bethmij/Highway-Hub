package lk.ijse.gdse66.user_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse66.user_service.dto.UserDTO;
import lk.ijse.gdse66.user_service.entity.UserEntity;
import lk.ijse.gdse66.user_service.repo.UserRepo;
import lk.ijse.gdse66.user_service.service.UserService;
import lk.ijse.gdse66.user_service.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.user_service.service.exception.NotFoundException;
import lk.ijse.gdse66.user_service.service.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    Transformer transformer;

    @Override
    public List<UserDTO> getAllUsers() {

        List<UserEntity> users = userRepo.findAll();

        if (users.isEmpty()) {
            throw new NotFoundException("No Users Exist");
        }
        return users.stream().map(userEntity -> transformer.fromUserEntity(userEntity)).toList();
    }

    @Override
    public UserDTO getUserById(String userId) {

        if (!userRepo.existsById(userId)) {
            throw new NotFoundException("User nic : " + userId + " doesn't exist");
        }
        return transformer.fromUserEntity(userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException("User nic : " + userId + " doesn't exist")));
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        if (userRepo.existsById(userDTO.getUserNIC())) {
            throw new DuplicateRecordException("User id : " + userDTO.getUserNIC() + " already exist");
        }
        return transformer.fromUserEntity(userRepo.save(transformer.toUserEntity(userDTO)));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if (!userRepo.existsById(userDTO.getUserNIC())) {
            throw new NotFoundException("User id : " + userDTO.getUserNIC() + " doesn't exist");
        }
        userRepo.save(transformer.toUserEntity(userDTO));
    }

    @Override
    public void deleteUser(String userId) {
        if (!userRepo.existsById(userId)) {
            throw new NotFoundException("User id : " + userId + " doesn't exist");
        }
        userRepo.deleteById(userId);
    }

}
