package com.willingtogohome.gymga.sale.model.dao;

import com.willingtogohome.gymga.emp.model.dto.SearchCriteria;
import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;
import com.willingtogohome.gymga.pass.model.dto.PassDataDTO;
import com.willingtogohome.gymga.pass.model.dto.PassMonthDTO;
import com.willingtogohome.gymga.pass.model.dto.UserDTO;
import com.willingtogohome.gymga.sale.model.dto.EmployeeAndUserDTO;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SaleMapper {
    List<PassAndPassQualDTO> findAllList();

    List<PassAndPassQualDTO> findPassAndPassQualList();


//    List<PassData> sumPassData();

    List<EmployeeAndUserDTO> empAndUser();

    @Select({"<script>",
            "SELECT ",
            "SUM(CASE WHEN A.pq_code LIKE 'PT%' THEN 1 ELSE 0 END) as ptCount,",
            "SUM(CASE WHEN A.pq_code LIKE 'GX%' THEN 1 ELSE 0 END) as gxCount,",
            "SUM(CASE WHEN A.pq_code LIKE 'GP%' THEN 1 ELSE 0 END) as gpCount ",
            "FROM PASSDB A",
            "left join validatedb as B on B.pass_code = A.pass_code",
            "left join userdb as C on B.user_code = C.user_code",
            "<where>",
            "<choose>",
            "<when test=\"condition == 'month'\">",
            "AND DATE_FORMAT(A.pass_start, '%m') = LPAD(#{text}, 2, '0')",
            "</when>",
            "<when test=\"condition == 'name'\">",
            "AND QUARTER(A.pass_start) and C.user_name = #{text}",
            "</when>",
            "<when test=\"condition == 'quarter1'\">",
            "AND QUARTER(pass_start) = 1",
            "</when>",
            "<when test=\"condition == 'quarter2'\">",
            "AND QUARTER(pass_start) = 2",
            "</when>",
            "<when test=\"condition == 'quarter3'\">",
            "AND QUARTER(pass_start) = 3",
            "</when>",
            "<when test=\"condition == 'quarter4'\">",
            "AND QUARTER(pass_start) = 4",
            "</when>",
            "</choose>",
            "</where>",
            "</script>"})
    PassDataDTO getPassDataDTO(SearchCriteria searchCriteria);


    List<PassMonthDTO> getPassDataForPieChart();

    List<PassAndPassQualDTO> searchedUser(SearchCriteria criteria);

    List<PassAndPassQualDTO> searchedUserTest(SearchCriteria criteria);

    List<PassAndPassQualDTO> findByUserId(String userId);

    List<PassAndPassQualDTO> searchByUserId(String userId);

//    List<Map<String, Object>> getData(SearchCriteria criteria);

//    PassAndPassQualDTO getUserDetails(String userId);

}
