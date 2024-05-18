package com.willingtogohome.gymga.user.pain.model.dao;

import com.willingtogohome.gymga.user.pain.model.dto.PainDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PainMapper {

    PainDTO selectPain(int code, String userName, PainDTO painDTO);

    void registPain(PainDTO painDTO);

    void registPainCodeAndPos(PainDTO painDTO);

    void deletePain(int code, int pos);
}
