package top.bigpong.transactionManager1.dao;

import java.math.BigDecimal;

/**
 * 转账案例的dao层的接口
 * Created by Cornelius on 2017/6/18.
 */
public interface AccountDao {
	/**
	 * @param out 转出账号
	 * @param money 转账金额
	 */
	public void outMoney(String out, BigDecimal money);
	
	/**
	 * @param in 转入账号
	 * @param money 转账金额
	 */
	public void inMoney(String in, BigDecimal money);
}
