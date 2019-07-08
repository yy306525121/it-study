package cn.codeyang.design.factory.simplefactory;

public class Client {
	public static void main(String[] args) {
		Car car = CarFactory.getCar("宝马");
		car.run();

		Car bydCar = CarFactory.getCar("比亚迪");
		bydCar.run();
	}
}
