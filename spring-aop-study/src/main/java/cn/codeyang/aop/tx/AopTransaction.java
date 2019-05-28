//package cn.codeyang.aop.tx;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.interceptor.TransactionAspectSupport;
//
///**
// * 切面类
// *
// * aop的通知分为
// * 	1：前置通知
// * 	2：后置通知
// * 	3：运行通知
// * 	4：异常通知
// * 	5：环绕通知
// * @author akafra
// */
//@Component
//@Aspect
//public class AopTransaction {
//	@Autowired
//	private TransactionUtils transactionUtils;
//
//	@AfterThrowing("execution(* cn.codeyang.aop.service.UserService.add(..))")
//	public void afterThrowing(){
//		// 获取当前事务,  直接回滚
//		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//	}
//
//	@Around("execution(* cn.codeyang.aop.service.UserService.add(..))")
//	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		System.out.println("开启事务");
//		TransactionStatus transactionStatus = transactionUtils.begin();
//		proceedingJoinPoint.proceed();
//		transactionUtils.commit(transactionStatus);
//
//	}
//}
