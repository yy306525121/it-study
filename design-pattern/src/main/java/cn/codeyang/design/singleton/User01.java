package cn.codeyang.design.singleton;

/**
 * 懒汉式
 */
public class User01 {
	// 类初始化的时候， 就会创建对象，天生线程安全，调用效率高，如果在不适用对象的时候， 会比较浪费内存
	private static final User01 user01 = new User01();

	private User01(){}

	public static User01 getInstance(){
		return user01;
	}

	public static void main(String[] args) {
		User01 instance01 = User01.getInstance();
		User01 instance02 = User01.getInstance();
		System.out.println(instance01 == instance02);
	}
}
