package cn.codeyang.design.factory.factory;

public class Client {
	public static void main(String[] args) {
		CarFactory carFactory = new BydCarFactory();
		Car bydCar1 = carFactory.createCar("唐");
		bydCar1.run();
	}
}
