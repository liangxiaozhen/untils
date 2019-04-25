package com.ganjiangps.wangdaibus.common.enumUtil;

public enum PreForumForumEnum {
	FORUM("forum"),
	GROUP("group"),
	SUB("sub");
	
	private PreForumForumEnum(String name){
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
