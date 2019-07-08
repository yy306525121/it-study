package cn.codeyang.design.factory.simplefactory;

public class CarFactory {
	static Car getCar(String name){
		if ("宝马".equals(name)) {
			return new BmwCar();
		} else if ("比亚迪".equals(name)) {
			return new BydCar();
		} else {
			return null;
		}
	}
}
