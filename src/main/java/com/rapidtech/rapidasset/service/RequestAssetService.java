package com.rapidtech.rapidasset.service;

import com.rapidtech.rapidasset.model.ApprovalRequest;
import com.rapidtech.rapidasset.model.ApprovalResponse;
import com.rapidtech.rapidasset.model.RequestAssetReq;
import com.rapidtech.rapidasset.model.RequestAssetResponse;

import java.util.List;
import java.util.Optional;

public interface RequestAssetService {
    List<RequestAssetResponse> getAll();
    Optional<RequestAssetReq> create(RequestAssetReq request);
    Optional<ApprovalRequest> approve(ApprovalRequest request, Long requestId);
    Optional<ApprovalRequest> reject(ApprovalRequest request, Long requestId);
}
