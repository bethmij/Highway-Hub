package lk.ijse.gdse66.user_service.api;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;
import lk.ijse.gdse66.user_service.dto.UserDTO;
import lk.ijse.gdse66.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON)
    public List<UserDTO> getAllUser() {
//        return restTemplate.getForObject("http://vehicle-service/vehicle", String.class);
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON)
    public UserDTO getUserByID(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(path = "isExit/{userId}")
    public Boolean isUserExit(@PathVariable("userId") String userId){
        return userService.isUserExit(userId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO saveUser(@Valid @RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return userService.saveUser(userDTO);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@Valid @RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
    }

    @DeleteMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
    }




}
