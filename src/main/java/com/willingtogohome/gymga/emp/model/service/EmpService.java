package com.willingtogohome.gymga.emp.model.service;

import com.willingtogohome.gymga.emp.model.dao.EmpMapper;
import com.willingtogohome.gymga.emp.model.dao.ScheMapper;
import com.willingtogohome.gymga.emp.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpService {

    private final EmpMapper empMapper;
    private final ScheMapper scheMapper;

    @Autowired
    public EmpService (EmpMapper empMapper, ScheMapper scheMapper) {

        this.empMapper = empMapper;
        this.scheMapper = scheMapper;
    }

    public List<EmpDTO> selectAllEmp() {

        return empMapper.selectAllEmp();
    }

    public List<ScheDTO> selectAllSche() {

        return scheMapper.selectAllSche();
    }

    public EmpTotDTO searchBy(SearchCriteria searchCriteria) {

        return empMapper.searchBy(searchCriteria);
    }

    @Transactional
    public void registNewEmp(EmpDTO empDTO, PhysicalDTO physicalDTO, EmployeeDTO employeeDTO) {

        empMapper.registEmpDTO(empDTO);
        empMapper.registPhysicalDTO(physicalDTO);
        empMapper.registEmeployeeDTO(employeeDTO);
    }

    public int findLastCode() {

        return empMapper.findLastCode();
    }

    @Transactional
    public void removeEmp(int code) {

        empMapper.removePhysical(code);
        empMapper.removeEmployee(code);
        empMapper.removeEmp(code);
    }
}
