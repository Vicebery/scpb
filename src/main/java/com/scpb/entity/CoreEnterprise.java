package com.scpb.entity;

public class CoreEnterprise {

    private String id;
    private String name;
	private String limit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String toString() {
        return "CoreEnterprise{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", limit='" + limit + '\'' +
                '}';
    }
}
