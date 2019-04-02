package com.scpb.entity;

public class Factor {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Factor{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
