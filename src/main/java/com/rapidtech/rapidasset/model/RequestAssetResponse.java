package com.rapidtech.rapidasset.model;

import com.rapidtech.rapidasset.entity.ApprovalEntity;
import com.rapidtech.rapidasset.entity.RequestAssetEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAssetResponse {
    private Long id;
    private Long picId;
    private String fullName;
    private String specification;

    @Temporal(TemporalType.DATE)
    private Date requestDate;

    private List<ApprovalResponse> approval = new ArrayList<>();

    public RequestAssetResponse(RequestAssetEntity entity) {
        BeanUtils.copyProperties(entity, this);
        this.fullName = entity.getPic().getFullName();
        for (ApprovalEntity status : entity.getApproval()) {
            approval.add(new ApprovalResponse(status));
        }
    }
}
