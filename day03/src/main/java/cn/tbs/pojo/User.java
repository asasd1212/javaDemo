package cn.tbs.pojo;






public class User {
    private Integer id;
    private String name;
    private Integer num;
    private String desp;

    public User(Integer id, String name, Integer num, String desp) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.desp = desp;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }
}
