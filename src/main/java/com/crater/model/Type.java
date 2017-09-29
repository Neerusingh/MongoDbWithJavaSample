package com.crater.model;

public class Type {
	
	private Integer id;
	
	@SuppressWarnings("unused")
	private Type(){
		this(null);
	}

	public Type(Integer id){
		this.id=id;
	}

	public Integer getId() {
		return id;
	}
	
	public static Type withId(Integer id){
		return new Type(id);
	}
	
	
}
