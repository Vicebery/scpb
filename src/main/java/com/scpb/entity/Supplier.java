package com.scpb.entity;

public class Supplier {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Supplier{" +
				"id='" + id + '\'' +
				'}';
	}
}
