package com.willingtogohome.gymga.login.user.model.dao;

import com.willingtogohome.gymga.emp.model.dto.EmployeeDTO;
import com.willingtogohome.gymga.emp.model.dto.PhysicalDTO;
import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper {

    /* 회원가입 */
    int regist(RegistDTO registDTO);

    /* 아이디 찾아서 로그인 */
    LoginDTO findByUsername(String username);

    /* 아이디 찾기 */
    String find_id(String userName, String userPhone);

    /* 비밀번호 찾기 */
    String find_pwd(String userId, String userPhone);


    /* 아이디 중복체크 */
    // 수빈님꺼 주석
//    List<RegistDTO> idCheck();

    /*아이디 중복체크*/
    int idCheck(String userId);

    int registPhysicalDTO(PhysicalDTO physicalDTO);

    int registEmployeeDTO(EmployeeDTO employeeDTO);
}
