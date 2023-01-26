package com.rapidtech.rapidasset.entity;

import com.rapidtech.rapidasset.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @TableGenerator(name = "user_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "user_id", initialValue = 0, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id_generator")
    private Long id;

    @Column(name = "name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "pic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequestAssetEntity> requestAsset = new ArrayList<>();

    public UserEntity(UserModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
