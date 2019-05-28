package cn.codeyang.aop.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Component
@Scope(value = "prototype")
public class TransactionUtils {

	private TransactionStatus transactionStatus;
	//获取事务源
	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	/**
	 * 开启事务
	 */
	public TransactionStatus begin(){
		transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
		return transactionStatus;
	}

	/**
	 * 提交事务
	 */
	public void commit(){
		dataSourceTransactionManager.commit(transactionStatus);
	}

	/**
	 * 回滚事务
	 */
	public void rollback(){
		if (transactionStatus != null) {
			dataSourceTransactionManager.rollback(transactionStatus);
		}
	}
}
