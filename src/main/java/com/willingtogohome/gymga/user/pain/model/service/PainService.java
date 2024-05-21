package com.willingtogohome.gymga.user.pain.model.service;

import com.willingtogohome.gymga.user.pain.model.dao.PainMapper;
import com.willingtogohome.gymga.user.pain.model.dto.PainDTO;
import com.willingtogohome.gymga.user.pain.model.dto.PainUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PainService {

    private final PainMapper painMapper;

    @Autowired
    public PainService(PainMapper painMapper) { this.painMapper = painMapper; }

    public PainDTO selectPain(int code) {

        return painMapper.selectPain(code);
    }

    @Transactional
    public void registPainCodeAndPos(int code, int pos) {

        painMapper.registPainCodeAndPos(code, pos);
    }

    @Transactional
    public void registPain(int code, int pos, PainDTO painDTO) {

        painMapper.registPain(painDTO, pos, code);
    }

    public void deletePain(int code, int pos) {

        painMapper.deletePain(code, pos);
    }

    public PainDTO updatePain(int code, PainDTO painDTO) {

        return painMapper.updatePain(code, painDTO);
    }

    @Transactional
    public void update(int code, int pos) {

        painMapper.update(code, pos);
    }

    public PainUpdateDTO getPainByCode(int code, PainDTO painDTO) {

        return painMapper.getPainByCode(code, painDTO);
    }

    public PainDTO resultPain(int code, PainDTO painDTO) {

        return painMapper.resultPain(code, painDTO);
    }
}
