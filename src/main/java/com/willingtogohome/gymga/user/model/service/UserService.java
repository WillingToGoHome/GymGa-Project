package com.willingtogohome.gymga.user.model.service;

import com.willingtogohome.gymga.user.model.dao.UserMapper;
import com.willingtogohome.gymga.user.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserService {

    private final UserMapper userMapper;
    @Autowired
    public UserService(UserMapper userMapper) { this.userMapper = userMapper; }
    public List<UserAndEmpDTO> allUser() {

        return userMapper.allUser();
    }

    @Transactional
    public void deleteUser(int code) {

        userMapper.userPain(code);
        userMapper.facilityUser(code);
        userMapper.physicalUser(code);
        userMapper.scheduleUser(code);
        userMapper.validateUser(code);
        userMapper.salesUser(code);
        userMapper.deleteUser(code);
    }

    public List<UserAndEmpDTO> searchedUser(SearchCriteria criteria) {
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

    public List<UserDTO> findAllTeacher() {

        return userMapper.findAllTeacher();
    }

    public List<UserDTO> selectAllUserID() {

        return userMapper.selectAllUserID();
    }

    public UserTotDTO getUserDetailByCode(int code, UserDTO userDTO, PhysicalDTO physicalDTO) {

        return userMapper.getUserDetailByCode(code, userDTO, physicalDTO);
    }

    public UserTotDTO updatePage(int code, UserDTO userDTO, PhysicalDTO physicalDTO) {

        return userMapper.updatePage(code, userDTO, physicalDTO);
    }
    @Transactional
    public void update(UserDTO userDTO, PhysicalDTO physicalDTO) {

        userMapper.updateUser(userDTO);
        userMapper.updatePhy(physicalDTO);
    }

//    public void selectDetail(UserDTO userDTO, PhysicalDTO physicalDTO) {
//
//        userMapper.selectDetailUser(userDTO);
//        userMapper.selectDetailPhy(physicalDTO);
//    }

//    @Transactional
//    public void update(UserTotDTO userTotDTO) {
//
//        userMapper.update(userTotDTO);
//    }
}
