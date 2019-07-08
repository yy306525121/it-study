package cn.codeyang.design.factory.factory;

public class BmwCar implements Car {
	private String name;

	public BmwCar(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println("宝马" + name + "Run...");
	}
}
