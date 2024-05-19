package com.willingtogohome.gymga.pass.model.service;

import com.willingtogohome.gymga.pass.model.dao.PassMapper;
import com.willingtogohome.gymga.pass.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<UserDTO> selectAllMember(SearchCriteria searchCriteria) {

        return passMapper.selectAllMember(searchCriteria);
    }

    public int findMaxCode() {

        return passMapper.findMaxCode();
    }

    @Transactional
    public void registNewPass(PassDTO passDTO, SaleDTO saleDTO, ValidateDTO validateDTO) {

        passMapper.registNewPassDTO(passDTO);
        passMapper.registNewSaleDTO(saleDTO);
        passMapper.registNewValidateDTO(validateDTO);

    }

    public List<PassAndPassQualDTO> selectAllPassAndUser() {
        return passMapper.selectAllPassAndUser();
    }
}
