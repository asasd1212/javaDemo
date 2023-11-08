package com.yh.pojo;

import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String productNum;
    private String productName;
    private String CityName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private Double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String departureTimeStr;
    private String productStatusStr;



    public String getDepartureTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (departureTime!=null)
        departureTimeStr=sdf.format( departureTime);
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        Date date = null;
       try {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           date = sdf.parse(departureTimeStr);

       } catch (Exception e) {
           e.printStackTrace();
       }
        this.departureTime=date;
    }

    public String getProductStatusStr() {
        productStatusStr = productStatus == 0?"关闭":"开启";
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
       this.productStatus=productStatusStr.equals("关闭")?0:1;
     }
}
