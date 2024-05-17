package com.willingtogohome.gymga.pass.model.dao;

import com.willingtogohome.gymga.pass.model.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.MergedAnnotations;

import java.util.List;

@Mapper
public interface PassMapper {
    List<UserDTO> selectAllEmp();

    List<UserDTO> selectAllMember(SearchCriteria searchCriteria);

    int findMaxCode();

    void registNewPassDTO(PassDTO passDTO);

    void registNewSaleDTO(SaleDTO saleDTO);

    void registNewValidateDTO(ValidateDTO validateDTO);
}
