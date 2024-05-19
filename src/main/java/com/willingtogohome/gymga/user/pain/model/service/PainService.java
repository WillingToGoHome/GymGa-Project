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

    public PainDTO selectPain(int code, String userName, PainDTO painDTO) {

        System.out.println(code);

        return painMapper.selectPain(code, userName, painDTO);
    }

    @Transactional
    public void registPainCodeAndPos(int code, int pos) {

        painMapper.registPainCodeAndPos(code, pos);
    }

    @Transactional
    public void registPain(PainDTO painDTO) {

        painMapper.registPain(painDTO);
    }

    public void deletePain(int code, int pos) {

        painMapper.deletePain(code, pos);
    }

    public PainDTO updatePain(int code) {

        return painMapper.updatePain(code);
    }

    @Transactional
    public void update(PainDTO painDTO) {

        painMapper.update(painDTO);
    }

    public PainUpdateDTO getPainByCode(int code) {

        return painMapper.getPainByCode(code);
    }
}
