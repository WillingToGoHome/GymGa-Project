package com.willingtogohome.gymga.login.auth.model.service;

import com.willingtogohome.gymga.login.auth.model.dao.MainMapper;
import com.willingtogohome.gymga.login.auth.model.dto.MemberAndPassDTO;
import com.willingtogohome.gymga.pass.model.dto.PassMonthDTO;
import com.willingtogohome.gymga.user.model.dto.EmpDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainService {

    private final MainMapper mainMapper;

    @Autowired
    public MainService(MainMapper mainMapper) {
        this.mainMapper = mainMapper;
    }

    public UserDTO selectLoginInfo(int code) {

        return mainMapper.selectLoginInfo(code);

    public UserDTO selectEmpBy(String name) {
        return mainMapper.selectEmpBy(name);
    }

    public Map<String, Integer> getPieData(int userCode) {
        Map<String, Integer> pieData = new HashMap<>();

        pieData.put("pt", mainMapper.ptCount(userCode));
        pieData.put("gx", mainMapper.gxCount(userCode));
        pieData.put("gp", mainMapper.gpCount(userCode));

        System.out.println("pieData = " + pieData);

        return pieData;
    }

    public List<PassMonthDTO> getBarData(int userCode) {
        LocalDate date = LocalDate.now();
        List<PassMonthDTO> barData = new ArrayList<>();

        barData.add(new PassMonthDTO(Integer.toString(date.getMonthValue() - 2), mainMapper.twoMonthsAgo(userCode)));
        barData.add(new PassMonthDTO(Integer.toString(date.getMonthValue() - 1), mainMapper.lastMonth(userCode)));
        barData.add(new PassMonthDTO(Integer.toString(date.getMonthValue()), mainMapper.thisMonth(userCode)));

        return barData;
    }

    public List<MemberAndPassDTO> selectMemberList() {
        return mainMapper.selectMemberList();
    }
}
