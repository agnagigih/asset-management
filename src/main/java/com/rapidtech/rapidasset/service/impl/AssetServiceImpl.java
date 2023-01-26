package com.rapidtech.rapidasset.service.impl;

import com.rapidtech.rapidasset.entity.AssetEnitity;
import com.rapidtech.rapidasset.model.AssetModel;
import com.rapidtech.rapidasset.repository.AssetRepository;
import com.rapidtech.rapidasset.service.AssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AssetServiceImpl implements AssetService {
    private AssetRepository assetRepository;

    @Autowired
    public AssetServiceImpl(AssetRepository assetRepository){
        this.assetRepository = assetRepository;
    }

    @Override
    public List<AssetModel> getAll() {
        return this.assetRepository.findAll().stream().map(AssetModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AssetModel> create(AssetModel model) {
        if(model == null){
            return Optional.empty();
        }
        AssetEnitity assetEnitity = new AssetEnitity(model);
        try {
            this.assetRepository.save(assetEnitity);
            return Optional.of(new AssetModel(assetEnitity));
        } catch (Exception e) {
            log.error("Failed to save asset. Error: \n{}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AssetModel> readById(Long id) {
        if(id == null) {
            return Optional.empty();
        }
        Optional<AssetEnitity> enitity = this.assetRepository.findById(id);
        return enitity.map(AssetModel::new);
    }

    @Override
    public Optional<AssetModel> update(Long id, AssetModel model) {
        if(id == null){
            return Optional.empty();
        }
        AssetEnitity entity = this.assetRepository.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        model.setId(entity.getId());
        BeanUtils.copyProperties(model, entity);
        try {
            this.assetRepository.save(entity);
            return Optional.of(new AssetModel(entity));
        } catch (Exception e) {
            log.error("Failed to update asset. Error : \n{}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AssetModel> delete(Long id) {
        if(id == null) {
            return Optional.empty();
        }
        AssetEnitity result = this.assetRepository.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        try {
            this.assetRepository.delete(result);
            return Optional.of(new AssetModel(result));
        } catch (Exception e) {
            log.error("Failed to delete asset. Error : \n{}", e.getMessage());
            return Optional.empty();
        }
    }
}
