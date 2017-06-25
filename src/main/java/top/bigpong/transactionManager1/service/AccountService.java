package top.bigpong.transactionManager1.service;

import java.math.BigDecimal;

/**
 * Created by Cornelius on 2017/6/18.
 */
public interface AccountService {
	/**
	 * @param out 转出账号
	 * @param in 转入账号
	 * @param money 转账金额
	 */
	public void transfer(String out, String in, BigDecimal money);
}
