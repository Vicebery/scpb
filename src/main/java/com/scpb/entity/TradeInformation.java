package com.scpb.entity;

public class TradeInformation {
    private String id;
    private String tradeTime;
    private String firstParty;
    private String secondParty;
    private String sum;
    private String tradeRemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty;
    }

    public String getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getTradeRemark() {
        return tradeRemark;
    }

    public void setTradeRemark(String tradeRemark) {
        this.tradeRemark = tradeRemark;
    }

    @Override
    public String toString() {
        return "TradeInformation{" +
                "id='" + id + '\'' +
                ", tradeTime='" + tradeTime + '\'' +
                ", firstParty='" + firstParty + '\'' +
                ", secondParty='" + secondParty + '\'' +
                ", sum='" + sum + '\'' +
                ", tradeRemark='" + tradeRemark + '\'' +
                '}';
    }
}
