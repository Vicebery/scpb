package com.scpb.entity;

public class MemberEnterprise {
	private String id;
	private String limit;
	private String coreEnterpriseId;

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

	public String getCoreEnterpriseId() {
		return coreEnterpriseId;
	}

	public void setCoreEnterpriseId(String coreEnterpriseId) {
		this.coreEnterpriseId = coreEnterpriseId;
	}

	@Override
	public String toString() {
		return "MemberEnterprise{" +
				"id='" + id + '\'' +
				", limit='" + limit + '\'' +
				", coreEnterpriseId='" + coreEnterpriseId + '\'' +
				'}';
	}
}
