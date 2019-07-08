package cn.codeyang.design.singleton;

public class User04 {
	private User04() {
		System.out.println("....");
	}

	public static class Instance {
		public static final User04 user04 = new User04();
	}


	public static User04 getInstance() {
		return Instance.user04;
	}

	public static void main(String[] args) {
		User04 u1 = User04.getInstance();
		User04 u2 = User04.getInstance();

		System.out.println(u1 == u2);
	}
}
