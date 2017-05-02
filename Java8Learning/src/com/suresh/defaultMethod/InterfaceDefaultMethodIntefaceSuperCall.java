package com.suresh.defaultMethod;

public class InterfaceDefaultMethodIntefaceSuperCall implements Interface3, Interface4 {
		
		public static void main (String[] args) {
			
			InterfaceDefaultMethodIntefaceSuperCall interfaceDefaultMethod = new InterfaceDefaultMethodIntefaceSuperCall();
			interfaceDefaultMethod.defaultMethod();
		}
		
		// specific interface default method call using super
	    @Override
	    public void defaultMethod(){
		    System.out.println("defaultMethod call of interface using super");
		    Interface3.super.defaultMethod();
		    Interface4.super.defaultMethod();
		}
		
}

interface Interface3 {
    
    default void defaultMethod(){
        System.out.println("Interface3 defaultMethod");
    }
}

interface Interface4 {
    
    default void defaultMethod(){
        System.out.println("Interface4 defaultMethod");
    }
}
