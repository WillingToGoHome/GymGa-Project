package com.willingtogohome.gymga.fac.model.service;

import com.willingtogohome.gymga.fac.model.dao.FacMapper;
import com.willingtogohome.gymga.fac.model.dto.FacAndUserDTO;
import com.willingtogohome.gymga.fac.model.dto.FacDTO;
import com.willingtogohome.gymga.fac.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacService {

    private final FacMapper facMapper;

    public FacService(FacMapper facMapper) {
        this.facMapper=facMapper;
    }
    public List<FacDTO> findAllFac() {
        return facMapper.findAllFac();
    }

    public List<UserDTO> findAllUser() {
        return facMapper.findAllUser();
    }

    public void registNewFac(FacDTO newFac) {
        facMapper.registNewFac(newFac);
    }
}
