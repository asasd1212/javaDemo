package cn.tbs.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private Double money;
    private Integer uid;
    private Date ordertime;
    // 一个订单从属于一个用户
    private User user;//描述了
    // order和user的多对一的关系
}
