package cn.codeyang.leetcode.thread;

public class FooBar {
	private int n;
	private boolean flag = true;

	public FooBar(int n) {
		this.n = n;
	}

	public synchronized void foo() throws InterruptedException {
		for (int i = 0; i < n; i++) {
			while (!flag) {
				this.wait();
			}
			System.out.print("Foo");
			flag = false;
			this.notify();
		}
	}


	public synchronized void bar() throws InterruptedException {

		for (int i = 0; i < n; i++) {
			while (flag) {
				this.wait();
			}
			System.out.println("Bar");
			flag = true;
			this.notify();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		FooBar fooBar = new FooBar(10);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					fooBar.foo();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Foo").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					fooBar.bar();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Bar").start();

	}

}
