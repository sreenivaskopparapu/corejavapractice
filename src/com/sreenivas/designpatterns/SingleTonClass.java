package com.sreenivas.designpatterns;

class SingleTonDemo{
	private static SingleTonDemo instance=null;
	//	private static  SingleTonDemo instance=new SingleTonDemo(); Eagar loading during compile time the object is created
    //class loaders three types bootstrap, system,extension cl 
	//after .class the work is  load , link,intialize, cl is load the class later linked to defalut values, once it intialize overloaded to original values 
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
	// we can break singleton behaviour by using serialization, multithrread,reflection,clone
}
}
