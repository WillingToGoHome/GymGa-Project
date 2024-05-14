package com.willingtogohome.gymga.pass.model.service;

import com.willingtogohome.gymga.pass.model.dao.PassMapper;
import com.willingtogohome.gymga.pass.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassService {

    private final PassMapper passMapper;

    @Autowired
    public PassService(PassMapper passMapper) {

        this.passMapper = passMapper;
    }

    public List<UserDTO> selectAllEmp() {

        return passMapper.selectAllEmp();
    }
}
