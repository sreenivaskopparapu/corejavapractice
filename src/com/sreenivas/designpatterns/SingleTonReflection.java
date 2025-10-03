package com.sreenivas.designpatterns;

import java.lang.reflect.Constructor;

class SingleTonThree{
	private static SingleTonThree instance=null;
	
	private SingleTonThree() throws Exception{
		if(instance!=null) {
			throw new Exception();
			// here we are throwing exception to stop creating object again
		}
	}
	public static SingleTonThree getInstance() throws Exception {
		if(instance==null) {
			instance = new SingleTonThree();
		}
		return instance;
	}
}
public class SingleTonReflection {

	public static void main(String[] args) throws Exception {
		SingleTonThree s1 = SingleTonThree.getInstance();
		System.out.println(s1.hashCode());
		SingleTonThree s2 = SingleTonThree.getInstance();
		System.out.println(s2.hashCode());
//even though private constructor is there we can create object using the reflection as below
		Constructor<SingleTonThree> s3 = SingleTonThree.class.getDeclaredConstructor();
		s3.setAccessible(true);
		SingleTonThree s4 = s3.newInstance();
		System.out.println(s4.hashCode());
		
	}

}
