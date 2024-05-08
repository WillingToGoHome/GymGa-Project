package com.willingtogohome.gymga.user.model.dao;

import com.willingtogohome.gymga.user.model.dto.PhysicalDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import com.willingtogohome.gymga.user.model.dto.SearchCriteria;
import com.willingtogohome.gymga.user.model.dto.UserTotDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    List<UserDTO> AllUser();

    List<UserDTO> searchedUser(SearchCriteria criteria);

    void userPain(int code);

    void facilityUser(int code);

    void physicalUser(int code);

    void scheduleUser(int code);

    void validateUser(int code);

    void deleteUser(int code);

    void registUser(UserDTO newUser);

    void registUserPhysical(PhysicalDTO physical);

    int findLastCode();

    List<UserTotDTO> selectDetail(int code);
}
