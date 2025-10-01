package com.sreenivas.designpatterns;

class SingleTonDemo{
	private static SingleTonDemo instance=null;
	
	private SingleTonDemo() {
	}
	public static SingleTonDemo getInstance() {
		if(instance==null) {
			instance = new SingleTonDemo();
		}
		return instance;
	}
}
public class SingleTonClass {
public static void main(String[] args) {
	SingleTonDemo instance1 = SingleTonDemo.getInstance();
	SingleTonDemo instance2 = SingleTonDemo.getInstance();
	SingleTonDemo instance3 = SingleTonDemo.getInstance();
	System.out.println(instance1.hashCode());
	System.out.println(instance2.hashCode());
	System.out.println(instance3.hashCode());
}
}
