package com.match.cp.framework.model;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class ModelUtil{
	private ModelUtil modelUtil = new ModelUtil();
	
	private ModelUtil(){
		
	}
	public ModelUtil getInstance(){
		if(modelUtil == null)
			return new ModelUtil();
		return modelUtil;
	}
	
	private static String getFieldnameBySetter(String setter){
		String field = setter.substring(3);
		field = field.substring(0,1).toLowerCase()+field.substring(1);
		return field;
	}
	
	/**
	 * 我知道对应的类
	 * 我找所有的set方法
	 * set**** 且 没有返回值
	 * 对应的名字去request里面取值
	 * 放到一个新建的对应的类对象里
	 */
	public static <M> M createFromRequest(HttpServletRequest req,Class<M> clazz){
		try {
			M model = clazz.newInstance();
			
			for (Method method:clazz.getMethods()){
				final String name = method.getName();
				if (!name.startsWith("set"))
					continue;
				final Class<?> retType = method.getReturnType();
				if (retType.equals(Void.class))
					continue;
				//name setParentUuid
				//request parentUuid
				final String fieldName = getFieldnameBySetter(name);
				//request.getParameter("parentUuid")
				final String value = req.getParameter(fieldName);
				if (value==null)
					continue;
				//区分是int还是String，得到不同的Object
				//public void setParentUuid(String parentUuid);
				final Class<?> fieldClass = method.getParameterTypes()[0];
				final Object obj = FieldClassEnum.switcher(fieldClass).tran(value);
				method.invoke(model, obj);
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
