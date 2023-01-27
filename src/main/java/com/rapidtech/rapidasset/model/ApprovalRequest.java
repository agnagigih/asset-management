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
public class ApprovalRequest {
    private Long id;
    private Long requestAssetId;
    private String status;
    private String reason;
    private Date updatedDate;

    public ApprovalRequest(ApprovalEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
