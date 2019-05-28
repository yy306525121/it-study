package cn.codeyang.aop.tx;

import cn.codeyang.aop.annotation.ExtTransaction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;

/**
 * 事务注解切面类
 * @author akafra
 */
@Component
@Aspect
public class AopExtTransaction {
	@Autowired
	private TransactionUtils transactionUtils;


	@Around("execution(* cn.codeyang.aop.service.*.*.*(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Method targetMethod = getExtTransactionMethod(proceedingJoinPoint);

		//2. 获取该方法上是否有@ExtTransaction注解
		ExtTransaction annotation = targetMethod.getDeclaredAnnotation(ExtTransaction.class);

		TransactionStatus transactionStatus = beginTx(annotation);

		//4. 调用目标代理对象方法
		proceedingJoinPoint.proceed();
		//5. 获取该方法上是否有@ExtTransaction注解
		commitTx(transactionStatus);
	}

	private void commitTx(TransactionStatus transactionStatus) {
		if (transactionStatus != null) {
			//6. 如果存在注解 则 提交事务 or 回滚事务
			transactionUtils.commit();
		}
	}

	private TransactionStatus beginTx(ExtTransaction annotation) {
		if (annotation != null) {
			//3. 开启事务
			return transactionUtils.begin();
		}
		return null;
	}

	/**
	 * 获取方法上是否存在注解
	 * @param proceedingJoinPoint
	 * @return
	 * @throws NoSuchMethodException
	 */
	private Method getExtTransactionMethod(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
		//1. 获取到代理对象的方法
		//获取方法名称
		String targetMethodName = proceedingJoinPoint.getSignature().getName();
		// 获取目标对象
		Class<?> targetClazz = proceedingJoinPoint.getTarget().getClass();
		//获取目标方法参数类型
		Class[] targetMethodParameterTypes = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterTypes();
		// 获取目标方法
		return targetClazz.getMethod(targetMethodName, targetMethodParameterTypes);
	}

	@AfterThrowing("execution(* cn.codeyang.aop.service.*.*.*(..))")
	public void afterThrowing() throws NoSuchMethodException {
		transactionUtils.rollback();
	}
}
