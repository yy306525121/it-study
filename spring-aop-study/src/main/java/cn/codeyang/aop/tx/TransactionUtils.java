package cn.codeyang.aop.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Component
public class TransactionUtils {
	//获取事务源
	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	/**
	 * 开启事务
	 */
	public TransactionStatus begin(){
		return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());

	}

	/**
	 * 提交事务
	 */
	public void commit(TransactionStatus status){
		dataSourceTransactionManager.commit(status);
	}

	/**
	 * 回滚事务
	 */
	public void rollback(TransactionStatus status){
		dataSourceTransactionManager.rollback(status);
	}
}
