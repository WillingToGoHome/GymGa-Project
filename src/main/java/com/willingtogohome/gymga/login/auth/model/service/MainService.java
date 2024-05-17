package com.willingtogohome.gymga.login.auth.model.service;

import com.willingtogohome.gymga.login.auth.model.dao.MainMapper;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    private final MainMapper mainMapper;

    @Autowired
    public MainService(MainMapper mainMapper) {
        this.mainMapper = mainMapper;
    }

    public UserDTO selectLoginInfo(int code) {

        return mainMapper.selectLoginInfo(code);
    }
}
