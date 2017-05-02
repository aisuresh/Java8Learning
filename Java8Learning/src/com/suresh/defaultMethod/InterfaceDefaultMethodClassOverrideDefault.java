package com.suresh.defaultMethod;

public class InterfaceDefaultMethodClassOverrideDefault implements Interface1, Interface2 {
		
		public static void main (String[] args) {
			
			InterfaceDefaultMethodClassOverrideDefault interfaceDefaultMethod = new InterfaceDefaultMethodClassOverrideDefault();
			interfaceDefaultMethod.defaultMethod();
		}
		
		// class > interface
	    @Override
	    public void defaultMethod(){
		    System.out.println("defaultMethod Overrided - Class method");
		}
		
}

interface Interface1 {
    
    default void defaultMethod(){
        System.out.println("Interface1 defaultMethod");
    }
}

interface Interface2 {
    
    default void defaultMethod(){
        System.out.println("Interface2 defaultMethod");
    }
}
