package com.match.cp.framework.model;

public enum FieldClassEnum {
	
	INT(Integer.TYPE){
		@Override
		public Object tran(String value) {
			return Integer.parseInt(value);
		}
	},
	STRING(String.class),
	LONG(Long.TYPE){
		@Override
		public Object tran(String value) {
			return Long.parseLong(value);
		}
	};

	private final Class<?> clazz;
	private FieldClassEnum(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Class<?> getClazz() {
		return clazz;
	}
	
	public Object tran(String value){
		return value;
	}
	
	public static FieldClassEnum switcher(Class<?> clazz){
		for (FieldClassEnum cenum:values()){
			if (cenum.getClazz()==clazz){
				return cenum;
			}
		}
		throw new IllegalArgumentException("No such class:"+clazz.getName()+",in mapping.");
	}
	
	
}
