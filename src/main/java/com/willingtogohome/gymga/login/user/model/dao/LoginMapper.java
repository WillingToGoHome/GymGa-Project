package com.willingtogohome.gymga.login.user.model.dao;

import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    /* 회원가입 */
    int regist(RegistDTO registDTO);

    /* 아이디 찾아서 로그인 */
    LoginDTO findByUsername(String username);


    /* 아이디 중복체크 */
}
