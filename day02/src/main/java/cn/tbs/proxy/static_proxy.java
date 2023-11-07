package cn.tbs.proxy;

public class static_proxy implements  Star{
    private RealStar realStar;

    public static_proxy(RealStar realStar) {
        this.realStar = realStar;
    }

    public static_proxy() {

    }

    public void sing() {
        System.out.println("奏乐!!!");
        realStar.sing();

    }

    public String show(String address) {
        System.out.println("订酒店");
        return null;
    }
}
