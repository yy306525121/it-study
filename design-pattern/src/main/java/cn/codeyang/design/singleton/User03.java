package cn.codeyang.design.singleton;

public class User03 {
	private User03() {
	}

	public static User03 getInstance() {
		return User03Enum.INSTANCE.getInstance();
	}

	static enum User03Enum{
		INSTANCE;

		private User03 user03;

		private User03Enum(){
			user03 = new User03();
		}

		public User03 getInstance(){
			return user03;
		}
	}

	public static void main(String[] args) {
		User03 instance01 = User03.getInstance();
		User03 instance02 = User03.getInstance();
		System.out.println(instance01 == instance02);
	}

}
