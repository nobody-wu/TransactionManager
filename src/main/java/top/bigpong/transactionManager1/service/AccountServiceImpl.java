package top.bigpong.transactionManager1.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import top.bigpong.transactionManager1.dao.AccountDaoImpl;

import java.math.BigDecimal;

/**
 * 编程式事务管理
 * Created by Cornelius on 2017/6/18.
 */
public class AccountServiceImpl implements AccountService {
	//注入转账的dao业务实现类
	private AccountDaoImpl accountDao;
	//事务管理的模版
	private TransactionTemplate transactionTemplate;
	
	/**
	 * Setter注入
	 * @param transactionTemplate
	 */
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	/**
	 * setter注入
	 * @param accountDao
	 */
	public void setAccountDao(AccountDaoImpl accountDao) {
		this.accountDao = accountDao;
	}
	
	public void transfer(final String out, final String in, final BigDecimal money) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				//匿名内部类要使用外部类的变量，必须是final
				accountDao.outMoney(out, money);
				int i = 1/0;//发生异常，事务回滚
				accountDao.inMoney(in, money);
			}
		});
	}
}
