package com.scpb.entity;

public class MemberEnterprise {
	private String id;
	private String limit;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberEnterprise{" +
				"id='" + id + '\'' +
				", limit='" + limit + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
