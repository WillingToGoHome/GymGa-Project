package com.willingtogohome.gymga.sale.model.dto;

import com.willingtogohome.gymga.emp.model.dto.EmployeeDTO;
import com.willingtogohome.gymga.pass.model.dto.PassDTO;
import com.willingtogohome.gymga.pass.model.dto.PassQualDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeAndUserDTO {


    private UserDTO userDTO;
    private EmployeeDTO employeeDTO;
    private PassDTO passDTO;
    private PassQualDTO passQualDTO;
    private int total1;


}
