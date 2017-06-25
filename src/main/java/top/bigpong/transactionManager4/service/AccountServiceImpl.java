package top.bigpong.transactionManager4.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.bigpong.transactionManager4.dao.AccountDaoImpl;

import java.math.BigDecimal;

/**
 * 声明式事务管理2:基于aspectXML，aop编程的方式
 * Created by Cornelius on 2017/6/18.
 */
@Transactional(propagation = Propagation.REQUIRED)
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
