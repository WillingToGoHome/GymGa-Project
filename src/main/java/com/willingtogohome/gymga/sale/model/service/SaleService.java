package com.willingtogohome.gymga.sale.model.service;

import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;
import com.willingtogohome.gymga.sale.model.dao.SaleMapper;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements SaleMapper {

    private final SaleMapper saleMapper;

    public SaleService(SaleMapper saleMapper) {
        this.saleMapper = saleMapper;
    }

    public List<SaleDTO> findAllList() {
        return saleMapper.findAllList();
    }

    public List<PassAndPassQualDTO> findPassAndPassQualList() {
        return saleMapper.findPassAndPassQualList();
    }
}
