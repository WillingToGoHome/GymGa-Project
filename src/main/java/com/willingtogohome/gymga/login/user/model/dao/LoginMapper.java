package com.willingtogohome.gymga.login.user.model.dao;

import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    int regist(RegistDTO registDTO);

    LoginDTO findByUserId(String userId);
}
