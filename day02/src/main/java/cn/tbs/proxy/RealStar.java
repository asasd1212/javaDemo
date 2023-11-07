package cn.tbs.proxy;

public class RealStar implements Star{

    public void sing() {
        System.out.println("唱歌");
    }

    public String show(String address) {
        return address;
    }


}
