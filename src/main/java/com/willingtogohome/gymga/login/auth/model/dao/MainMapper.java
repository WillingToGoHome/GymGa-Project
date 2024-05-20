package com.willingtogohome.gymga.login.auth.model.dao;

import com.willingtogohome.gymga.login.auth.model.dto.MemberAndPassDTO;
import com.willingtogohome.gymga.user.model.dto.EmpDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    UserDTO selectEmpBy(int userCode);

    Integer ptCount(int userCode);

    Integer gxCount(int userCode);

    Integer gpCount(int userCode);

    Integer thisMonth(int userCode);

    Integer lastMonth(int userCode);

    Integer twoMonthsAgo(int userCode);

    List<MemberAndPassDTO> selectMemberList();
}
