package com.yzu.zhang.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;

public class BaseModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		String className = this.getClass().getSimpleName();
		buffer.append(className + "{");
		Field[] fs = this.getClass().getDeclaredFields();
		//
		try {
			Class<?> ftype = null ;
			Object fvalue = null ;
			for(Field f : fs){
				ftype = f.getType();
				//是基本类型/简单类型
				if((ftype.isPrimitive()
						|| ftype == String.class
						|| ftype == Integer.class
						|| ftype == Long.class
						|| ftype == Date.class)
						&& !Modifier.isStatic(f.getModifiers())){
					f.setAccessible(true);
					fvalue = f.get(this);
					buffer.append(f.getName()+":" + fvalue +",");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		buffer.append("}");
		return buffer.toString();
	}
}
