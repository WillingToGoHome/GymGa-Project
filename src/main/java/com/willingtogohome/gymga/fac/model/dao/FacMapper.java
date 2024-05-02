package com.willingtogohome.gymga.fac.model.dao;

import com.willingtogohome.gymga.fac.model.dto.FacAndUserDTO;
import com.willingtogohome.gymga.fac.model.dto.FacDTO;
import com.willingtogohome.gymga.fac.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FacMapper {
    List<FacDTO> findAllFac();

    List<UserDTO> findAllUser();

    void registNewFac(FacDTO newFac);
}
