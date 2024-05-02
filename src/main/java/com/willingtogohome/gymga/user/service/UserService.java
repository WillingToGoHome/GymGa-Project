package com.willingtogohome.gymga.user.service;

import com.willingtogohome.gymga.user.model.dao.UserMapper;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private final UserMapper userMapper;
    public UserService(UserMapper userMapper) { this.userMapper = userMapper; }
    public List<UserDTO> AllUser() {

        return userMapper.AllUser();
    }
}
