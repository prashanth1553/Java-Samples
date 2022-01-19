package com.java8.interfaces;

public class DefaultImplementation implements DefaultMethodInterface, DefaultMethodInterfaceExtend {

	public static void main(String args[]) {

		DefaultImplementation obj = new DefaultImplementation();
		obj.defaultMethod();
		
		DefaultMethodInterface obj1 = obj;
		obj1.defaultMethod();
		
		DefaultMethodInterfaceExtend obj2 = obj;
		obj2.defaultMethod();
	}

	@Override
	public void defaultMethod() {
		// TODO Auto-generated method stub
		DefaultMethodInterface.super.defaultMethod();
	}

}
