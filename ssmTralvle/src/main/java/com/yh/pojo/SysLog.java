package com.yh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;
}
