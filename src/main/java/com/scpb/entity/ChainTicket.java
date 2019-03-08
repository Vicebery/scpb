package com.scpb.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChainTicket {
    private String id;
    private String amount;
	private String drawTime;
	private String drawEnterprise;
	private int state;
    private int ownerType;
    private String ownerId;
    private String deadline;


    public ChainTicket(){
    	
    }
    
	public ChainTicket(String id, String amount, String drawTime, String drawEnterprise, int state, int ownerType,
			String ownerId, String deadline) {
		super();
		this.id = id;
		this.amount = amount;
		this.drawTime = drawTime;
		this.drawEnterprise = drawEnterprise;
		this.state = 0;
		this.ownerType = ownerType;
		this.ownerId = ownerId;
		this.deadline = deadline;
	}

	public ChainTicket(String amount, String deadline, String ownerId, int ownerType, String drawEnterprise) {
		super();
		Date date=new Date();
		DateFormat idFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		DateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.id = idFormat.format(date);
		this.drawTime = timeFormat.format(date);
		this.state = 0;
		this.amount = amount;
		this.ownerType = ownerType;
		this.deadline = deadline;
		this.ownerId = ownerId;
		this.drawEnterprise = drawEnterprise;
	}
	
    public String getDrawEnterprise() {
		return drawEnterprise;
	}

	public void setDrawEnterprise(String drawEnterprise) {
		this.drawEnterprise = drawEnterprise;
	}
    
    public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(String drawTime) {
        this.drawTime = drawTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(int ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "ChainTicket{" +
                "id='" + id + '\'' +
                ", amount='" + amount + '\'' +
                ", drawTime='" + drawTime + '\'' +
                ", state='" + state + '\'' +
                ", ownerType='" + ownerType + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
