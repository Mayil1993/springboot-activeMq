package com.mayil1993.messaging.standaloneactivemqexample.resource;

import java.io.Serializable;

public class User implements Serializable{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	
	
}
