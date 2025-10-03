package com.sreenivas.designpatterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SingleTonDemoOne implements Serializable{
	// we can break singleton using serialization
	private static SingleTonDemoOne instance = null;

	private SingleTonDemoOne() {
	}

	public static SingleTonDemoOne getInstance() {
		if (instance == null) {
			instance = new SingleTonDemoOne();
		}
		return instance;
	}
	
	protected Object readResolve() {
		return instance;
	}
}

public class SingleTonSerialization {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SingleTonDemoOne s1 = SingleTonDemoOne.getInstance();
		SingleTonDemoOne s2 = SingleTonDemoOne.getInstance();
		SingleTonDemoOne s3 = SingleTonDemoOne.getInstance();
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		FileOutputStream fos = new FileOutputStream("D:\\MULTI THREAD\\serialize.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		
		FileInputStream fis = new FileInputStream("D:\\MULTI THREAD\\serialize.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SingleTonDemoOne s = (SingleTonDemoOne)ois.readObject();//it calls readResolve() it creates new object 
		//to over come this readResolve() 
		System.out.println(s.hashCode());
	}
}
