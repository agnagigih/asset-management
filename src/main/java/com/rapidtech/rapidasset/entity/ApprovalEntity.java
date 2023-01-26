package com.rapidtech.rapidasset.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "approval")
public class ApprovalEntity {
    @Id
    @TableGenerator(name = "approval_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "approval_id", initialValue = 0, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "approval_id_generator")
    private Long id;

    @Column(name = "request_asset_id")
    private Long requestAssetId;

    @ManyToOne
    @JoinColumn(name = "request_asset_id", insertable = false, updatable = false)
    private RequestAssetEntity requestAsset;

    @Column(name = "status")
    private String status;

    @Column(name = "reason")
    private String reason;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_date")
    private Date updatedDate;
}
