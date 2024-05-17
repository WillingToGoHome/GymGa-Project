package com.willingtogohome.gymga.login.auth.model.dao;

import com.willingtogohome.gymga.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {
    UserDTO selectLoginInfo(int code);
}
