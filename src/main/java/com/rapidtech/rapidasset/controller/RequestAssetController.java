package com.rapidtech.rapidasset.controller;

import com.rapidtech.rapidasset.model.RequestAssetReq;
import com.rapidtech.rapidasset.service.RequestAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/request")
public class RequestAssetController {
    private RequestAssetService requestAssetService;

    @Autowired
    public RequestAssetController(RequestAssetService requestAssetService){
        this.requestAssetService = requestAssetService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<RequestAssetReq> result = requestAssetService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createRequestAsset(@RequestBody RequestAssetReq req){
        Optional<RequestAssetReq> result = requestAssetService.create(req);
        return ResponseEntity.ok().body(result);
    }

    /*@PostMapping
    public ResponseEntity<Object> save(@RequestBody RequestAssetReq request){
        return ResponseEntity.ok().body(request);
    }*/
}
