package com.rapidtech.rapidasset.entity;

import com.rapidtech.rapidasset.model.RequestAssetReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request_asset")
public class RequestAssetEntity {
    @Id
    @TableGenerator(name = "request_asset_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "request_asset_id", initialValue = 0, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "request_asset_id_generator")
    private Long id;

    @Column(name = "pic_id", insertable = false, updatable = false)
    private Long picId;

    @ManyToOne
    @JoinColumn(name = "pic_id")
    private UserEntity pic;

    @Column(name = "specification")
    private String specification;

    @Temporal(TemporalType.DATE)
    @Column(name = "request_date")
    private Date requestDate;

    @OneToMany(mappedBy = "requestAsset", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApprovalEntity> approval;

    public RequestAssetEntity(RequestAssetReq request) {
        BeanUtils.copyProperties(request, this);
        this.requestDate = new Date();
    }
}
