package com.willingtogohome.gymga.sale.model.dao;

import com.willingtogohome.gymga.emp.model.dto.SearchCriteria;
import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;
import com.willingtogohome.gymga.pass.model.dto.PassDataDTO;
import com.willingtogohome.gymga.pass.model.dto.PassMonthDTO;
import com.willingtogohome.gymga.sale.model.dto.EmployeeAndUserDTO;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SaleMapper {
    List<PassAndPassQualDTO> findAllList();

    List<PassAndPassQualDTO> findPassAndPassQualList();


//    List<PassData> sumPassData();

    List<EmployeeAndUserDTO> empAndUser();

    List<Map<String, Object>> getData();

    @Select("SELECT " +
            "SUM(CASE WHEN pq_code LIKE 'PT%' THEN 1 ELSE 0 END) as ptCount, " +
            "SUM(CASE WHEN pq_code LIKE 'GX%' THEN 1 ELSE 0 END) as gxCount, " +
            "SUM(CASE WHEN pq_code LIKE 'GP%' THEN 1 ELSE 0 END) as gpCount " +
            "FROM passdb")
    PassDataDTO getPassDataDTO();

    List<PassMonthDTO> getPassDataForPieChart();

    List<PassAndPassQualDTO> searchedUser(SearchCriteria criteria);
}
