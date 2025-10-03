package com.sreenivas.designpatterns;

import java.io.Serializable;

class SingleTonDemoTwo{
	private static SingleTonDemoTwo instance = null;

	private SingleTonDemoTwo() {
	}
//remove synchronized we will break the singleton
	public synchronized static  SingleTonDemoTwo  getInstance() {
		if (instance == null) {
			 try {
	                // Force delay so both threads enter here before instance is assigned
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
			instance = new SingleTonDemoTwo();
		}
		return instance;
	}
}
public class SingleTonThreads extends Thread{

	@Override
	public void run() {
		SingleTonDemoTwo singleTonDemoTwo = SingleTonDemoTwo.getInstance();
		System.out.println(singleTonDemoTwo.hashCode());
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
      Thread t1 =  new Thread(new SingleTonThreads());
      Thread t2 =  new Thread(new SingleTonThreads());
      t1.start();
      t2.start();
	}
}
