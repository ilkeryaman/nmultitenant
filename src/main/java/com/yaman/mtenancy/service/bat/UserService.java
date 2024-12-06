package com.yaman.mtenancy.service.bat;

import com.yaman.mtenancy.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();
}