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
    private String ownerId;
    private String deadline;


    public ChainTicket(){
    	
    }
    
	public ChainTicket(String id, String amount, String drawTime, String drawEnterprise, int state,
			String ownerId, String deadline) {
		super();
		this.id = id;
		this.amount = amount;
		this.drawTime = drawTime;
		this.drawEnterprise = drawEnterprise;
		this.state = state;
		this.ownerId = ownerId;
		this.deadline = deadline;
	}

	public ChainTicket(int state,String amount, String deadline, String ownerId, String drawEnterprise) {
		Date date=new Date();
		DateFormat idFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		DateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
		int rad = (int)(1+Math.random()*100);
		this.id = idFormat.format(date)+String.valueOf(rad);
		this.drawTime = timeFormat.format(date);
		this.state = state;
		this.amount = amount;
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
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
