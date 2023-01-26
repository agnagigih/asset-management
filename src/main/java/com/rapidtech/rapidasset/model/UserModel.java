package com.rapidtech.rapidasset.model;

import com.rapidtech.rapidasset.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Long id;
    private String fullName;
    private String address;

    public UserModel(UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity, this);
    }
}
