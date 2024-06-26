package com.willingtogohome.gymga.login.user.model.service;

import com.willingtogohome.gymga.emp.model.dto.EmployeeDTO;
import com.willingtogohome.gymga.emp.model.dto.PhysicalDTO;
import com.willingtogohome.gymga.login.user.model.dao.LoginMapper;
import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public int regist(RegistDTO registDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO) {
        registDTO.setUserPwd(passwordEncoder.encode(registDTO.getUserPwd()));

        int result = 0;

        try {
            result += loginMapper.regist(registDTO);
            result += loginMapper.registPhysicalDTO(physicalDTO);
            result += loginMapper.registEmployeeDTO(employeeDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public LoginDTO findByUsername(String username) {
        System.out.println("2 findByUsername" + username);
        System.out.println("3 findByUsername" + loginMapper);
        LoginDTO login = loginMapper.findByUsername(username);
        if (!Objects.isNull(login)) {
            return login;
        } else {
            return null;
        }
    }


    public String find_id(String userName, String userPhone) {
        String result = "";

        try {
            result = loginMapper.find_id(userName, userPhone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String find_pwd(String userId, String userPhone) {
        String result = "";

        try {
            result = loginMapper.find_pwd(userId, userPhone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


// 수빈님꺼 주석
//    public List<RegistDTO> idCheck() {
//        return loginMapper.idCheck();
//    }

    /* 아이디 중복 체크*/
    public int idCheck(String userId) {
        return loginMapper.idCheck(userId);
    }
}
