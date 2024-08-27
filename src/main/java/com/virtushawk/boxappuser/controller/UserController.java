package com.virtushawk.boxappuser.controller;

import com.virtushawk.boxappuser.model.User;
import com.virtushawk.boxappuser.model.dto.UserCreateDTO;
import com.virtushawk.boxappuser.model.dto.UserDTO;
import com.virtushawk.boxappuser.model.dto.UserDataBulkRequest;
import com.virtushawk.boxappuser.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.findAll().stream().map(this::mapTo).toList();
    }

    @GetMapping("{id}")
    public UserDTO get(@PathVariable String id) {
        return mapTo(userService.findById(id));
    }

    @PostMapping("/data")
    public List<UserDTO> getAllData(@RequestBody UserDataBulkRequest userDataBulkRequest) {
        return userService.fetchUserData(userDataBulkRequest.getUsernames()).stream().map(this::mapTo).toList();
    }


    @PostMapping
    public UserDTO create(@RequestBody UserCreateDTO user) {
        return mapTo(userService.create(mapTo(user)));
    }

    private UserDTO mapTo(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    private User mapTo(UserCreateDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        return user;
    }
}
