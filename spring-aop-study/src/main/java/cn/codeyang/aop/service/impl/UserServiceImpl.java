package cn.codeyang.aop.service.impl;

import cn.codeyang.aop.dao.UserDao;
import cn.codeyang.aop.service.UserService;
import cn.codeyang.aop.tx.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private TransactionUtils transactionUtils;

	//@Override
	//public void add() {
	//	TransactionStatus transactionStatus = null;
	//	try {
	//		transactionStatus = transactionUtils.begin();
	//		userDao.add("test001", 20);
	//		//int i = 1 / 0;
	//		System.out.println("#################");
	//		userDao.add("test002", 21);
	//		transactionUtils.commit(transactionStatus);
	//	} catch (Exception e){
	//		e.printStackTrace();
	//		transactionUtils.rollback(transactionStatus);
	//	}
	//}


	@Override
	public void add() {
		userDao.add("test001", 20);
		int i = 1 / 0;
		System.out.println("#################");
		userDao.add("test002", 21);
	}

	@Override
	@Transactional
	public void add2() {
		userDao.add("test001", 20);
		//int i = 1 / 0;
		System.out.println("#################");
		userDao.add("test002", 21);
	}
}
