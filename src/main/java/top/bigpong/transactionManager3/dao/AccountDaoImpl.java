package top.bigpong.transactionManager3.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.math.BigDecimal;

/**
 * Created by Cornelius on 2017/6/18.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	public void outMoney(String out, BigDecimal money) {
		String sql = "update account set money = money - ? where name = ?";
		this.getJdbcTemplate().update(sql, money, out);
	}
	
	public void inMoney(String in, BigDecimal money) {
		String sql = "update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(sql, money, in);
	}
}
