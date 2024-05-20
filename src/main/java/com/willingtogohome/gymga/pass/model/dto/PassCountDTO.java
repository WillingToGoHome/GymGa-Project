package com.willingtogohome.gymga.pass.model.dto;

import com.willingtogohome.gymga.sale.model.dto.SaleDTO;
import com.willingtogohome.gymga.sale.model.dto.ValidateDTO;
import com.willingtogohome.gymga.user.model.dto.EmpDTO;
import com.willingtogohome.gymga.user.model.dto.UserDTO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PassCountDTO {

    private Integer passCode;
    private String passStatus;
    private Date passStart;
    private Date passEnd;
    private Integer passTotal;
    private Integer passUse;
    private Integer userCode;
    private String pqCode;
    private int ptCount;
    private int gxCount;
    private int gpCount;

    private PassQualDTO passQualDTO;
    private UserDTO userDTO;
    private ValidateDTO validateDTO;
    private SaleDTO saleDTO;
    private EmpDTO empDTO;


}
