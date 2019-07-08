package cn.codeyang.design.factory.factory;


public class BydCarFactory extends CarFactory {

	@Override
	public Car createCar(String name) {
		if ("唐".equals(name)) {
			return new BydCar("唐");
		} else if ("宋".equals(name)) {
			return new BydCar("宋");
		} else {
			return new BydCar("其他型号");
		}
	}
}
