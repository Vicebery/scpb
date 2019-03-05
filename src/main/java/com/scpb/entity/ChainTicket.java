package com.scpb.entity;

public class ChainTicket {
    private String id;
    private String amount;
    private String drawTime;
    private String state;
    private String ownerType;
    private String ownerId;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
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
