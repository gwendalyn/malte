package org.rontai.p.reflect;

import java.lang.reflect.Field;

public class ReflectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BClass b = new BClass();
		b.setId(123l);
		b.setName("bclass");
		Object o = (Object) b;
		Class clz = o.getClass();
		Field[] fs = clz.getFields();
		for(Field f : fs){
			System.out.println(f.getName());
		}
		
	}

}
