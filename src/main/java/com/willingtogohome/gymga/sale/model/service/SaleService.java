package com.willingtogohome.gymga.sale.model.service;

import com.willingtogohome.gymga.pass.model.dto.PassAndPassQualDTO;
import com.willingtogohome.gymga.pass.model.dto.PassDataDTO;
import com.willingtogohome.gymga.pass.model.dto.PassMonthDTO;
import com.willingtogohome.gymga.sale.model.dao.SaleMapper;
import com.willingtogohome.gymga.sale.model.dto.EmployeeAndUserDTO;
import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
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

    public List<SaleDTO> findAllList() {
        return saleMapper.findAllList();
    }


//    public List<PassData> sumPassData() {
//        return saleMapper.sumPassData();
//    }

    public List<EmployeeAndUserDTO> empAndUser() {
        return saleMapper.empAndUser();
    }

    public List<Map<String, Object>> getDataForPieChart() {

        return saleMapper.getData();
    }


    public Map<String, Integer> getPassDataFromDatabase() {
            Map<String, Integer> passData = new HashMap<>();

            try {
                saleMapper = sqlSession.getMapper(SaleMapper.class);
                PassDataDTO passDataDTO = saleMapper.getPassDataDTO();

                passData.put("ptCount", passDataDTO.getPtCount());
                passData.put("gxCount", passDataDTO.getGxCount());
                passData.put("gpCount", passDataDTO.getGpCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        return passData;
    }

    public List<PassMonthDTO> getPassDataForPieChart() {
        return saleMapper.getPassDataForPieChart();
    }

}
