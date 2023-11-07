package cn.tbs.pojo;

import java.util.*;

public class User {
    private String username;
    private int age;

    // 数组类型
    private String[] array;
    // 集合类型
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties prop;

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public void setArray(String[] array) {this.array = array;}
    public void setList(List<String> list) {this.list = list;}
    public void setSet(Set<String> set) {this.set = set;}
    public void setMap(Map<String, String> map) {this.map = map;}
    public void setProp(Properties prop) {this.prop = prop;}

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", array=" + Arrays.toString(array) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", prop=" + prop +
                '}';
    }
}
