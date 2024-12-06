package com.yaman.mtenancy.mapper;

import com.yaman.mtenancy.dto.UserDTO;
import com.yaman.mtenancy.entity.bat.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserEntityDTOMapper {
    UserDTO mapEntityToDTO(User entity);
    User mapDTOToEntity(UserDTO dto);
}
