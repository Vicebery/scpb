package com.scpb.entity;

public class CoreEnterprise {

    private String id;
    private String limit;

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

    @Override
    public String toString() {
        return "CoreEnterprise{" +
                "id='" + id + '\'' +
                ", limit='" + limit + '\'' +
                '}';
    }
}
