package com.willingtogohome.gymga.emp.model.dao;

import com.willingtogohome.gymga.emp.model.dto.ScheDTO;
import com.willingtogohome.gymga.emp.model.dto.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheMapper {
    List<ScheDTO> selectAllSche(SearchCriteria searchCriteria);
}
