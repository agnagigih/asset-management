package com.rapidtech.rapidasset.service.impl;

import com.rapidtech.rapidasset.entity.ApprovalEntity;
import com.rapidtech.rapidasset.entity.RequestAssetEntity;
import com.rapidtech.rapidasset.entity.UserEntity;
import com.rapidtech.rapidasset.model.RequestAssetReq;
import com.rapidtech.rapidasset.repository.ApprovalRepository;
import com.rapidtech.rapidasset.repository.RequestAssetRepository;
import com.rapidtech.rapidasset.repository.UserRepository;
import com.rapidtech.rapidasset.service.RequestAssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RequestAssetServiceImpl implements RequestAssetService {
    private RequestAssetRepository requestAssetRepository;
    private ApprovalRepository approvalRepository;
    private UserRepository userRepository;

    @Autowired
    public RequestAssetServiceImpl(RequestAssetRepository requestAssetRepository, ApprovalRepository approvalRepository, UserRepository userRepository) {
        this.requestAssetRepository = requestAssetRepository;
        this.approvalRepository = approvalRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<RequestAssetReq> getAll() {
        return this.requestAssetRepository.findAll().stream().map(RequestAssetReq::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RequestAssetReq> create(RequestAssetReq request) {
        if (request == null){
            return Optional.empty();
        }
        RequestAssetEntity requestAssetEntity = new RequestAssetEntity(request);

        // find pic from user table
        Optional<UserEntity> pic = this.userRepository.findById(request.getPicId());
        // set pic
        requestAssetEntity.setPic(pic.get());

        try {
            // save request asset
            this.requestAssetRepository.save(requestAssetEntity);

            // create approval with status in process
            ApprovalEntity approval = new ApprovalEntity();
            approval.setRequestAsset(requestAssetEntity);
            approval.setRequestAssetId(requestAssetEntity.getId());
            approval.setStatus("In Process");
            approval.setUpdatedDate(new Date());
            // save approval to database
            this.approvalRepository.save(approval);

            return Optional.of(new RequestAssetReq(requestAssetEntity));

        } catch (Exception e) {
            log.error("Failed to create request asset. Error : \n{}", e.getMessage());
            return Optional.empty();
        }
    }
}
