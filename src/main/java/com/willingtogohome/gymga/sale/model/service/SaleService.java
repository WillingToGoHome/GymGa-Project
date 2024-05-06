package com.willingtogohome.gymga.sale.model.service;

import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;
import com.willingtogohome.gymga.pass.model.dto.PassData;
import com.willingtogohome.gymga.sale.model.dao.SaleMapper;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleMapper saleMapper;

    @Autowired
    public SaleService(SaleMapper saleMapper) {
        this.saleMapper = saleMapper;
    }

    public List<PassAndPassQualDTO> findPassAndPassQualList() {
        return saleMapper.findPassAndPassQualList();
    }

    public List<SaleDTO> findAllList() {
        return saleMapper.findAllList();
    }

    public List<PassData> sumPassData() {
        return saleMapper.sumPassData();
    }
}
