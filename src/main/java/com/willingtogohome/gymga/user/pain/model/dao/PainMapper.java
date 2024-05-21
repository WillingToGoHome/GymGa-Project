package com.willingtogohome.gymga.user.pain.model.dao;

import com.willingtogohome.gymga.user.pain.model.dto.PainDTO;
import com.willingtogohome.gymga.user.pain.model.dto.PainUpdateDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PainMapper {

    PainDTO selectPain(int code);

    void registPain(PainDTO painDTO);

    void registPainCodeAndPos(int code, int pos);

    void deletePain(int code, int pos);

    PainDTO updatePain(int code, PainDTO painDTO);

    void update(PainDTO painDTO);

    PainUpdateDTO getPainByCode(int code, PainDTO painDTO);

    PainDTO resultPain(int code, PainDTO painDTO);
}
