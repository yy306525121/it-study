package cn.codeyang.design.singleton;

/**
 * 懒汉式，
 * 类初始化时不会创建该对象， 真正需要的时候才会创建该对象， 真正需要的时候才会加载
 * 天生线程不安全， 需要解决线程安全问题， 所以效率比较低
 */
public class User02 {
	private static volatile User02 user02 = null;

	private User02(){}

	public static User02 getInstance(){
		if (user02 == null) {
			synchronized (Object.class) {
				if (user02 == null) {
					user02 = new User02();
				}
			}
		}

		return user02;
	}

	public static void main(String[] args) {
		User02 instance01 = User02.getInstance();
		User02 instance02 = User02.getInstance();

		System.out.println(instance01 == instance02);
	}

}
