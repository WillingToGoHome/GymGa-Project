package com.willingtogohome.gymga.user.pain.model.service;

import com.willingtogohome.gymga.user.pain.model.dao.PainMapper;
import com.willingtogohome.gymga.user.pain.model.dto.PainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PainService {

    private final PainMapper painMapper;

    @Autowired
    public PainService(PainMapper painMapper) { this.painMapper = painMapper; }

    public PainDTO selectPain(int code, String userName, PainDTO painDTO) {

        System.out.println(code);

        return painMapper.selectPain(code, userName, painDTO);
    }
}
