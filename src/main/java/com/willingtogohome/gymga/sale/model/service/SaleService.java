package com.willingtogohome.gymga.sale.model.service;

import com.willingtogohome.gymga.emp.model.dto.SearchCriteria;
import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;
import com.willingtogohome.gymga.pass.model.dto.PassDataDTO;
import com.willingtogohome.gymga.pass.model.dto.PassMonthDTO;
import com.willingtogohome.gymga.pass.model.dto.UserDTO;
import com.willingtogohome.gymga.sale.model.dao.SaleMapper;
import com.willingtogohome.gymga.sale.model.dto.EmployeeAndUserDTO;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleService {
    @Autowired
    private SqlSession sqlSession; // MyBatis SqlSession 주입

    private SaleMapper saleMapper;

    @Autowired
    public SaleService(SaleMapper saleMapper) {
        this.saleMapper = saleMapper;
    }

    public List<PassAndPassQualDTO> findPassAndPassQualList() {
        return saleMapper.findPassAndPassQualList();
    }

    public List<PassAndPassQualDTO> findAllList() {
        return saleMapper.findAllList();
    }


//    public List<PassData> sumPassData() {
//        return saleMapper.sumPassData();
//    }

    public List<EmployeeAndUserDTO> empAndUser() {
        return saleMapper.empAndUser();
    }

//    public List<Map<String, Object>> getDataForPieChart(SearchCriteria criteria) {
//
//        return saleMapper.getData(criteria);
//    }


    public Map<String, Integer> getPassDataFromDatabase(SearchCriteria searchCriteria) {
            Map<String, Integer> passData = new HashMap<>();

            try {
                saleMapper = sqlSession.getMapper(SaleMapper.class);
                PassDataDTO passDataDTO = saleMapper.getPassDataDTO(searchCriteria);
                if(passDataDTO != null) {
                    passData.put("ptCount", passDataDTO.getPtCount());
                    passData.put("gxCount", passDataDTO.getGxCount());
                    passData.put("gpCount", passDataDTO.getGpCount());
                }else {
                    System.out.println("정보없음");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return passData;
    }

    public List<PassMonthDTO> getPassDataForPieChart() {
        return saleMapper.getPassDataForPieChart();
    }

    public List<PassAndPassQualDTO> searchedUser(SearchCriteria criteria) {
        return saleMapper.searchedUser(criteria);
    }

    public List<PassAndPassQualDTO> searchedUserTest(SearchCriteria criteria) {
        return saleMapper.searchedUserTest(criteria);
    }

    public List<PassAndPassQualDTO> findByUserId(String userId) {
        return saleMapper.findByUserId(userId);
    }

    public List<PassAndPassQualDTO> searchByUserId(String userId) {
        return saleMapper.searchByUserId(userId);
    }


//    public PassAndPassQualDTO getUserDetails(String userId) {
//        return saleMapper.getUserDetails(userId);
//    }


//    public PassAndPassQualDTO getUserDetail(String userId) {
//        return saleMapper.getUserDetail(userId);
//    }
}
