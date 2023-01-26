package com.rapidtech.rapidasset.service;

import com.rapidtech.rapidasset.model.RequestAssetReq;

import java.util.List;
import java.util.Optional;

public interface RequestAssetService {
    List<RequestAssetReq> getAll();
    Optional<RequestAssetReq> create(RequestAssetReq request);
}
