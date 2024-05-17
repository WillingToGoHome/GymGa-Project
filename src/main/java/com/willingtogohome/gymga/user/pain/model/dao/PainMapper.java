package com.willingtogohome.gymga.user.pain.model.dao;

import com.willingtogohome.gymga.user.pain.model.dto.PainDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PainMapper {

    PainDTO selectPain(int code, String userName, PainDTO painDTO);
}
