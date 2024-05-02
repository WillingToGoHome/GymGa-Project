package com.willingtogohome.gymga.user.model.dao;

import com.willingtogohome.gymga.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    List<UserDTO> AllUser();
}
