package cn.tbs.dao;

public interface AccountDao {
    void outUser(String user, Double money);

    /**
     * 转入操作
     * @param user  转入的账号
     * @param money 转入金额
     */
    void inUser(String user, Double money);
}
