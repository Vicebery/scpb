package com.scpb.entity;

public class Enterprise {
	private String id;
	private String account;
	private String pwd;
	private String bank;
	private String name;
	private String UCC;
	private String LPC;
	private int type;
	
	public Enterprise() {
	}

	public Enterprise(String id, String account, String pwd,
					  String bank, String name, String UCC, String LPC, int type) {
		this.id = id;
		this.account = account;
		this.pwd = pwd;
		this.bank = bank;
		this.name = name;
		this.UCC = UCC;
		this.LPC = LPC;
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUCC() {
		return UCC;
	}
	public void setUCC(String uCC) {
		UCC = uCC;
	}
	public String getLPC() {
		return LPC;
	}
	public void setLPC(String lPC) {
		LPC = lPC;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Enterprise{" +
				"id='" + id + '\'' +
				", account='" + account + '\'' +
				", pwd='" + pwd + '\'' +
				", bank='" + bank + '\'' +
				", name='" + name + '\'' +
				", UCC='" + UCC + '\'' +
				", LPC='" + LPC + '\'' +
				", type='" + type + '\'' +
				'}';
	}
	
}
