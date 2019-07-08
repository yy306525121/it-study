package cn.codeyang.design.factory.factory;

public class BydCar implements Car {
	private String name;

	public BydCar(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("比亚迪"+name+"Run...");
	}
}
