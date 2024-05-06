package com.willingtogohome.gymga.fac.model.service;


import com.willingtogohome.gymga.fac.model.dao.FacMapper;
import com.willingtogohome.gymga.fac.model.dto.FacDTO;
import com.willingtogohome.gymga.fac.model.dto.UserDTO;
import org.apache.catalina.valves.JDBCAccessLogValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
    public void registNewFac(FacDTO newFac) {
    facMapper.registNewFac(newFac);
}

@Transactional
    public void updateRenewFac(FacDTO renewFac) {
        facMapper.updateRenewFac(renewFac);
    }
@Transactional
    public void deleteFac(FacDTO deleteFac) {
        facMapper.deleteFac(deleteFac);

}


    public List<FacDTO> findAllExp() {
        return facMapper.findAllExp();
    }

    @Transactional
    public FacDTO findAllPer(int facCode) {
        return facMapper.findAllPer(facCode);
    }
}
