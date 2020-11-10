package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRole {
    private int id;
    private String name;
    private String nameZh;
    private boolean enabled;


    @Transient
    private List<AdminPermission> perms;
    @Transient
    private List<AdminMenu> menus;

}
