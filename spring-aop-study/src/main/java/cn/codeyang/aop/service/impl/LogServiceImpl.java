package cn.codeyang.aop.service.impl;

import cn.codeyang.aop.dao.LogDao;
import cn.codeyang.aop.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author akafra
 */
@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDao logDao;

	@Transactional
	@Override
	public void addLog() {
		logDao.add("add log " + System.currentTimeMillis());
	}
}
