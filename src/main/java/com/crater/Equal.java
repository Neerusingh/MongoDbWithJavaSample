package com.crater;

public class Equal {

	private final Integer id;
	
	@SuppressWarnings("unused")
	private Equal(){
		this(null);
	}
	
	public static Equal withId(Integer id){
		return new Equal();
	}
	
	public Equal(Integer id){
		this.id=id;
	}

	public Integer getId() {
		return id;
	}
	
	
	
}
