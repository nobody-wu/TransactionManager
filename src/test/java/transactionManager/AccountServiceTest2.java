package transactionManager;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.bigpong.transactionManager2.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 声明式事务管理1:基于TransactionProxyFactoryBean的方式
 * Created by Cornelius on 2017/6/18.
 */
//模拟测试为了加载spring的配置
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class AccountServiceTest2 {
	
	/**
	 * 注入代理类：因为代理类进行了事务控制增强，只能对这一个类进行控制，如果都多个service,就要写多个
	 */
//	@Resource(name="accountService")
	@Resource(name="accountServiceProxy")//不写name也可以，首选按照名称查找，再是根据类型查找
	private AccountService accountService;
	
	public void demoTest(){
		accountService.transfer("aaa", "bbb", new BigDecimal(200));
	}

}
