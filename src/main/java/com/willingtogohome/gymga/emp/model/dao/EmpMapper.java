package com.willingtogohome.gymga.emp.model.dao;

import com.willingtogohome.gymga.emp.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<EmpDTO> selectAllEmp();

    EmpTotDTO searchBy(SearchCriteria searchCriteria);

    void registNewEmp(EmpDTO emp);

    void registEmpDTO(EmpDTO emp);

    void registPhysicalDTO(PhysicalDTO physicalDTO);

    void registEmeployeeDTO(EmployeeDTO employeeDTO);

    int findLastCode();

    void removeEmp(int code);

    void removePhysical(int code);

    void removeEmployee(int code);

    void updateEmp(EmpDTO empDTO);

    void updatePhysical(PhysicalDTO physicalDTO);

    void updateEmployee(EmployeeDTO employeeDTO);
}
