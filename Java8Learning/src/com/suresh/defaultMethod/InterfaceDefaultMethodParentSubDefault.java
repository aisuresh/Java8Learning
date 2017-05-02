package com.suresh.defaultMethod;

public class InterfaceDefaultMethodParentSubDefault implements ParentInterface, ChildInterface {
		
		public static void main (String[] args) {
			
			InterfaceDefaultMethodParentSubDefault interfaceDefaultMethodParentSubDefault = new InterfaceDefaultMethodParentSubDefault();
			
			// child > parent
			interfaceDefaultMethodParentSubDefault.defaultMethod();
		}
}

interface ParentInterface {
    
    default void defaultMethod(){
        System.out.println("ParentInterface defaultMethod");
    }
}

interface ChildInterface extends ParentInterface {
    
    default void defaultMethod(){
        System.out.println("ChildInterface defaultMethod");
    }
}
