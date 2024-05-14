package com.willingtogohome.gymga.pass.model.dao;

import com.willingtogohome.gymga.pass.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PassMapper {
    List<UserDTO> selectAllEmp();
}
