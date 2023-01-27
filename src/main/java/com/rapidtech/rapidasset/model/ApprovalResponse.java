package com.rapidtech.rapidasset.model;

import com.rapidtech.rapidasset.entity.ApprovalEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalResponse {
    private Long id;
    private String status;
    private String reason;
    private Date updatedDate;

    public ApprovalResponse(ApprovalEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
