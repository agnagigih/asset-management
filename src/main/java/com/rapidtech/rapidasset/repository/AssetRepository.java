package com.rapidtech.rapidasset.repository;

import com.rapidtech.rapidasset.entity.AssetEnitity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<AssetEnitity, Long> {
}
