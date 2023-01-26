package com.rapidtech.rapidasset.repository;

import com.rapidtech.rapidasset.entity.RequestAssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestAssetRepository extends JpaRepository<RequestAssetEntity, Long> {
}
