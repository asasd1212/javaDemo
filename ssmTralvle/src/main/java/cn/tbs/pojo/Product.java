package cn.tbs.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* @Data
@AllArgsConstructor
@NoArgsConstructor */
public class Product {

    private Integer id;
    private String productNum;
    private String productName;
    private String cityName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;
    private double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;

    public Product() {
    }

    public Product(Integer id, String productNum, String productName, String cityName, Date departureTime, String departureTimeStr, double productPrice, String productDesc, Integer productStatus, String productStatusStr) {
        this.id = id;
        this.productNum = productNum;
        this.productName = productName;
        this.cityName = cityName;
        this.departureTime = departureTime;
        this.departureTimeStr = departureTimeStr;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.productStatus = productStatus;
        this.productStatusStr = productStatusStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setDepartureTimeStr(String departureTimeStr) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = dateFormat.parse(departureTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.departureTime = date;
    }

    public String getDepartureTimeStr() {
        // 对日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (null != departureTime) {
            departureTimeStr = dateFormat.format(departureTime);
        }
        return departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public void setProductStatusStr(String productStatusStr) {
        if (productStatusStr.equals("关闭")){
            this.productStatus = 0;
        } else if(productStatusStr.equals("开启")){
            this.productStatus = 1;
        }
    }
    public String getProductStatusStr() {

        if (productStatus == null) {
            return "";
        }

        if (productStatus == 0){
            productStatusStr = "关闭";
        } else if(productStatus == 1){
            productStatusStr = "开启";
        }

        return productStatusStr;
    }

}
