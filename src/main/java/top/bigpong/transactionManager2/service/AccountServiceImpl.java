package top.bigpong.transactionManager2.service;

import top.bigpong.transactionManager2.dao.AccountDaoImpl;

import java.math.BigDecimal;

/**
 * 声明式事务管理1:基于TransactionProxyFactoryBean的方式
 * Created by Cornelius on 2017/6/18.
 */
public class AccountServiceImpl implements AccountService {
	//注入转账的dao业务实现类
	private AccountDaoImpl accountDao;
	
	
	/**
	 * setter注入
	 * @param accountDao
	 */
	public void setAccountDao(AccountDaoImpl accountDao) {
		this.accountDao = accountDao;
	}
	
	public void transfer(String out, String in, BigDecimal money) {
		accountDao.outMoney(out, money);
		int i = 1/0;//发生异常，事务回滚
		accountDao.inMoney(in, money);
	}
}
