package com.rapidtech.rapidasset.model;

import com.rapidtech.rapidasset.entity.ApprovalEntity;
import com.rapidtech.rapidasset.entity.RequestAssetEntity;
import com.rapidtech.rapidasset.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAssetReq {
    private Long id;
//    private UserModel pic;
    private Long picId;
    private String specification;

    @Temporal(TemporalType.DATE)
    private Date requestDate;

    public RequestAssetReq(RequestAssetEntity requestAssetEntity) {
        BeanUtils.copyProperties(requestAssetEntity, this);
    }
}
