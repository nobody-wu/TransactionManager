# 事务控制
1、事务隔离级别

2、事务传播

3、相关接口

# 实现方式
1、编程式事务管理
    
    手动编写代码进行事务管理（很少使用）
     
2、声明式事务管理

基于TransactionProxyFactoryBean的方式
    
    （不经常使用）需要给每个进行事务管理的类配置一个TransactionProxyFactoryBean进行增强
    
基于AspectJXML，aop方式

    经常使用，一劳永逸的方式

基于注解的方式

    配置最简单，经常使用，但是要修改源代码，在每一个类上增加注解。

也可以基于拦截器

        <!-- 2.1 拦截器管理事务 方式 开始-->
            <bean id="basicTransactionInterceptor" class="org.springframework.transaction.interceptor.TransactionInterceptor">
                <property name="transactionManager">
                    <ref bean="basicTransactionManager"/>
                </property>
                <property name="transactionAttributes">
                    <props>
                        <prop key="insert*">PROPAGATION_REQUIRED,-Exception</prop>
                        <prop key="del*">PROPAGATION_REQUIRED,-Exception</prop>
                        <prop key="update*">PROPAGATION_REQUIRED,-Exception</prop>
                        <prop key="save*">PROPAGATION_REQUIRED,-Exception</prop>
                    </props>
                </property>
            </bean>

