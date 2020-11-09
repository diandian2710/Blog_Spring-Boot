package com.wang.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;

    @NotEmpty
    private String username;
    private String password;
    private String salt;
    private String name;
    private String phone;

    @Email
    private String email;
    private boolean enable;

    @Transient
    private List<AdminRole> roles;


}
