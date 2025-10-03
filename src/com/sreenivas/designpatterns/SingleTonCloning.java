package com.sreenivas.designpatterns;

class SingleTonFour implements Cloneable{
	private static SingleTonFour instance = null;

	private SingleTonFour() {
	}

	public static SingleTonFour getInstance() {
		if (instance == null) {
			instance = new SingleTonFour();
		}
		return instance;
	}
	protected Object clone() throws CloneNotSupportedException{
		
		//return super.clone();when you uncomment this we will get the new object
		return instance;// or we use return throw new Exception();
	}
}

public class SingleTonCloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		SingleTonFour s1 = SingleTonFour.getInstance();
		System.out.println(s1.hashCode());
		SingleTonFour s2 = SingleTonFour.getInstance();
		System.out.println(s2.hashCode());
		SingleTonFour s3 = (SingleTonFour)s2.clone();
		System.out.println(s3.hashCode());
		
	}
}
