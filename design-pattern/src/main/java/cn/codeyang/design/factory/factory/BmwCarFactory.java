package cn.codeyang.design.factory.factory;

public class BmwCarFactory extends CarFactory {
	@Override
	public Car createCar(String name) {
		if ("X1".equals(name)) {
			return new BmwCar("X1");
		} else if ("X3".equals(name)) {
			return new BmwCar("X3");
		} else {
			return new BmwCar("其他型号");
		}
	}
}
