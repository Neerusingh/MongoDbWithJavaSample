package com.crater.model;

public class Document {
	
	private final Integer id;
	private final String name;
	
	@SuppressWarnings("unused")
	private Document(){
		this(null,null);
		
	}
	
	public Document(Integer id,String name){
		this.id=id;
		this.name=name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	
	
	

}
