package transactionManager;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.bigpong.transactionManager1.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 编程式事务管理测试类
 * Created by Cornelius on 2017/6/18.
 */
//模拟测试为了加载spring的配置
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountServiceTest {

	@Resource(name="accountService")//不写name也可以，首选按照名称查找，再是根据类型查找
	private AccountService accountService;
	
	public void demoTest(){
		accountService.transfer("aaa", "bbb", new BigDecimal(200));
	}

}
