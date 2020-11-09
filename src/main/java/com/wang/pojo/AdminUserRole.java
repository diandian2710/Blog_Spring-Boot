package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserRole {
    public AdminUserRole(int uid, int rid) {
        this.uid = uid;
        this.rid = rid;
    }
    private int id;
    private int uid;
    private int rid;
}
