package com.rapidtech.rapidasset.controller;

import com.rapidtech.rapidasset.model.AssetModel;
import com.rapidtech.rapidasset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asset")
public class AssetController {
    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<AssetModel> result = assetService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createAsset(@RequestBody AssetModel request){
        Optional<AssetModel> result = assetService.create(request);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readById(@PathVariable("id") Long id) {
        Optional<AssetModel> result = assetService.readById(id);
        return ResponseEntity.ok().body(result);
    }

    @PatchMapping("edit/{id}")
    public ResponseEntity<Object> updateAssetById(@PathVariable("id") Long id, @RequestBody AssetModel request) {
        Optional<AssetModel> result = assetService.update(id, request);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteAssetById(@PathVariable("id") Long id){
        Optional<AssetModel> result = assetService.delete(id);
        return ResponseEntity.ok().body(result);
    }

//    @PostMapping
//    public ResponseEntity<Object> save(@RequestBody AssetModel request){
//        return ResponseEntity.ok().body(request);
//    }
}
