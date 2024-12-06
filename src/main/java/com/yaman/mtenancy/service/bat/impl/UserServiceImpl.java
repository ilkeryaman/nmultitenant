package com.yaman.mtenancy.service.bat.impl;

import com.yaman.mtenancy.dto.UserDTO;
import com.yaman.mtenancy.entity.bat.User;
import com.yaman.mtenancy.mapper.UserEntityDTOMapper;
import com.yaman.mtenancy.repository.bat.UserRepository;
import com.yaman.mtenancy.service.bat.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityDTOMapper userEntityDTOMapper;

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        userList.forEach(u -> userDTOList.add(userEntityDTOMapper.mapEntityToDTO(u)));
        return userDTOList;
    }
}
