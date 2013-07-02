package com.match.cp.framework.model;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class AbstractModel {

	/* 
	 * 1、查找方法的范围，父类和自己的都要
	 * 2、getXxx/isXxx
	 * 3、有返回值不能是void
	 * 4、无参
	 * 5、查找方法的修饰符为public 和 non-static的
	 * 
	 */
//	@Override
	public String toString1() {
		
		StringBuffer buffer =new StringBuffer();
		
		//1、查找方法的范围，父类和自己的都要
		for(Method method:this.getClass().getMethods()){
			String name=method.getName();
			
			//2、getXxx/isXxx
			if((!name.startsWith("get"))&&(!name.startsWith("is"))){
				continue;
			}
			 //3、有返回值不能是void
			Class<?> retType=method.getReturnType();
			if(retType==Void.class){
				continue;
			}
			//4、无参
			Class<?>[] pramaClasses=method.getParameterTypes();
			if(pramaClasses!=null && pramaClasses.length>0){
				continue;
			}
			//5、查找方法的修饰符为public 和 non-static的
			int mod=method.getModifiers();
			if((!Modifier.isPublic(mod)) || (Modifier.isStatic(mod))){
				continue;
			}
			
			//6、拼字符串
			try {
				String fieldName=this.trans2FieldName(name);
				Object value=method.invoke(this);
				buffer.append(","+fieldName+":"+value);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		return buffer.toString().substring(1);
	}
	
	//getName------------>> name
	private String trans2FieldName(String getName){
		String temp=getName;
		
		temp=temp.substring(3);
		temp=temp.substring(0,1).toLowerCase()+temp.substring(1);
		
		return temp;
	}
}
