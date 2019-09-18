package cn.codeyang.leetcode.thread;

public class Foo {

	private Object lock = new Object();
	private boolean firstFinish = false;
	private boolean secondFinish = false;

	public Foo() {

	}

	public void first(Runnable printFirst) throws InterruptedException {
		synchronized (lock) {
			printFirst.run();
			firstFinish = true;
			lock.notifyAll();
		}

	}

	public void second(Runnable printSecond) throws InterruptedException {
		synchronized (lock) {
			while (!firstFinish){
				lock.wait();
			}
			printSecond.run();
			secondFinish = true;
			lock.notifyAll();
		}

	}

	public void third(Runnable printThird) throws InterruptedException {
		synchronized (lock) {
			while (!secondFinish){
				lock.wait();
			}
			printThird.run();
		}

	}


}
