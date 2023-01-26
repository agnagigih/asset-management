package com.rapidtech.rapidasset.model;

import com.rapidtech.rapidasset.entity.AssetEnitity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetModel {
    private Long id;
    private String assetName;
    private String specification;
    private String serialNumber;
    private Integer purchaseYear;

    public AssetModel(AssetEnitity assetEnitity) {
        BeanUtils.copyProperties(assetEnitity, this);
    }
}
