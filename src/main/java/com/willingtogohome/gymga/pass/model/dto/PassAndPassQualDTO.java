package com.willingtogohome.gymga.pass.model.dto;


import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import com.willingtogohome.gymga.sale.model.dto.ValidateDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import com.willingtogohome.gymga.user.model.dto.EmpDTO;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PassAndPassQualDTO {



    private Integer passCode;
    private String passStatus;
    private Date passStart;
    private Date passEnd;
    private Integer passTotal;
    private Integer passUse;
    private Integer userCode;
    private String pqCode;

    private PassQualDTO passQualDTO;
    private UserDTO userDTO;
    private ValidateDTO validateDTO;
    private SaleDTO saleDTO;
    private EmpDTO empDTO;

}
