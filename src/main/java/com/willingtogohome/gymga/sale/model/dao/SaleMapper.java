package com.willingtogohome.gymga.sale.model.dao;

import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;
import com.willingtogohome.gymga.pass.model.dto.PassData;
import com.willingtogohome.gymga.sale.model.dto.EmployeeAndUserDTO;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleMapper {
    List<SaleDTO> findAllList();

    List<PassAndPassQualDTO> findPassAndPassQualList();


    List<PassData> sumPassData();

    List<EmployeeAndUserDTO> empAndUser();
}
