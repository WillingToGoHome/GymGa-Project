package com.willingtogohome.gymga.user.service;

import com.willingtogohome.gymga.user.model.dao.UserMapper;
import com.willingtogohome.gymga.user.model.dto.PhysicalDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import com.willingtogohome.gymga.user.model.dto.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserService {

    private final UserMapper userMapper;
    @Autowired
    public UserService(UserMapper userMapper) { this.userMapper = userMapper; }
    public List<UserDTO> AllUser() {

        return userMapper.AllUser();
    }

    @Transactional
    public void deleteUser(int code) {

        userMapper.userPain(code);
        userMapper.facilityUser(code);
        userMapper.physicalUser(code);
        userMapper.scheduleUser(code);
        userMapper.validateUser(code);
        userMapper.deleteUser(code);
    }

    public List<UserDTO> searchedUser(SearchCriteria criteria) {
        return userMapper.searchedUser(criteria);
    }

    @Transactional
    public void registUser(UserDTO newUser, PhysicalDTO physical) {

        userMapper.registUser(newUser);
        userMapper.registUserPhysical(physical);
    }

    public int findLastCode() {
        return userMapper.findLastCode();
    }
}
