package cn.tbs.service;

import cn.tbs.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.text.DateFormat;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Transactional(propagation = Propagation.SUPPORTS)
    public void transfer(String outUser, String inUser, Double money) {
//        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
//        defaultTransactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
//        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_MANDATORY);
//        TransactionStatus transaction = transactionManager.getTransaction(defaultTransactionDefinition);
//
//        try {
//            accountDao.outUser(outUser, money);
//            System.out.println(1/0);
//            accountDao.inUser(inUser, money);
//            transactionManager.commit(transaction);
//        } catch (Exception e) {
//            e.printStackTrace();
//            transactionManager.rollback(transaction);
//        }
        accountDao.outUser(outUser, money);
        System.out.println(1/0);
        accountDao.inUser(inUser, money);
    }
}
