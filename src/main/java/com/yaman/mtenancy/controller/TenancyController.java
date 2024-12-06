package com.yaman.mtenancy.controller;

import com.yaman.mtenancy.dto.UserDTO;
import com.yaman.mtenancy.service.bat.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mtenancy")
public class TenancyController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(Long id){
        return userService.findAllUsers();
    }
}
