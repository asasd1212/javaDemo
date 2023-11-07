package cn.tbs.service;

import cn.tbs.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;

public interface AccountService {
    /**
     * 转账
     * @param outUser 转出用户
     * @param inUser  转入用户
     * @param money   金额
     */
    public void transfer(String outUser, String inUser, Double money);
}
