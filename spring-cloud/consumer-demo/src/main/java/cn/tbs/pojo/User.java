package cn.tbs.pojo;

import lombok.Data;

@Data
public class User {
    private String id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private Integer status;
}
