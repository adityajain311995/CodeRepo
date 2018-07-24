package com.code.randomprograms;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Class_Array_ComponentType {

	public static void main(String[] args){

		checkArrayComponentType();
		//method();
	}

	private static void checkArrayComponentType() {
		String[] arr = new String[] { "admin" };

		// returns the Class representing the component type
		Class arrClass = arr.getClass();
		Class componentType = arrClass.getComponentType();
		if (componentType != null) {
			System.out.println("ClassType = " + arrClass.getName());
			System.out.println("ComponentType = "
					+ componentType.getCanonicalName());
		} else {
			System.out.println("ComponentType is null");
		}
	}
	
/*	private static void method(){
		try {
			List<String> list = new ArrayList<String>();
			Field field = list.getClass().getField("DEFAULTCAPACITY_EMPTY_ELEMENTDATA");
			field.setAccessible(true);
			System.out.println(field.get(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}
