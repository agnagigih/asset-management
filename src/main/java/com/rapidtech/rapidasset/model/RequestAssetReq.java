package com.rapidtech.rapidasset.model;

import com.rapidtech.rapidasset.entity.RequestAssetEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAssetReq {
    private Long id;
    private Long picId;
//    private UserModel pic;
    private String specification;

    @Temporal(TemporalType.DATE)
    private Date requestDate;

//    private List<ApprovalEntity> approval;

    public RequestAssetReq(RequestAssetEntity requestAssetEntity) {
        BeanUtils.copyProperties(requestAssetEntity, this);
    }
}
