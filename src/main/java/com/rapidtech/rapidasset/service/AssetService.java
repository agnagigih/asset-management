package com.rapidtech.rapidasset.service;

import com.rapidtech.rapidasset.model.AssetModel;

import java.util.List;
import java.util.Optional;

public interface AssetService {
    List<AssetModel> getAll();
    Optional<AssetModel> create(AssetModel model);
    Optional<AssetModel> readById(Long id);
    Optional<AssetModel> update(Long id, AssetModel model);
    Optional<AssetModel> delete(Long id);

}
