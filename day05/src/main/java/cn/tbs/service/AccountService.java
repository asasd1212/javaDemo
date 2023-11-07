package cn.tbs.service;

public interface AccountService {
    /**
     * 转账
     * @param outUser 转出用户
     * @param inUser  转入用户
     * @param money   金额
     */
    public void transfer(String outUser, String inUser, Double money);
}
