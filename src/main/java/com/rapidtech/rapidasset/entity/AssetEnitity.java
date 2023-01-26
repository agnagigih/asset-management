package com.rapidtech.rapidasset.entity;

import com.rapidtech.rapidasset.model.AssetModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asset")
public class AssetEnitity {
    @Id
    @TableGenerator(name = "asset_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "asset_id", initialValue = 0, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "asset_id_generator")
    private Long id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "specification")
    private String specification;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "purchase_year")
    private Integer purchaseYear;

    public AssetEnitity(AssetModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
