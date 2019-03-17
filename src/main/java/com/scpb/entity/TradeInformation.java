package com.scpb.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TradeInformation {
    private String id;
    private String tradeTime;
    private String firstParty;
    private String secondParty;
    private String sum;
    private String tradeRemark;
    private String payCT;
    private String receiveCT;
    private String remainCT;
    private int verifyInf;

    public TradeInformation() {
    }

    public TradeInformation(String firstParty, String secondParty, String sum, String tradeRemark,String payCT) {
        Date date=new Date();
        DateFormat idFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        DateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.id = idFormat.format(date);
        this.tradeTime = timeFormat.format(date);
        this.firstParty = firstParty;
        this.secondParty = secondParty;
        this.sum = sum;
        this.tradeRemark = tradeRemark;
        this.payCT = payCT;
        this.verifyInf = 0;
    }

    public TradeInformation(String firstParty, String secondParty, String sum,
                            String tradeRemark, String payCT, String receiveCT, String remainCT) {
        Date date=new Date();
        DateFormat idFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        DateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.id = idFormat.format(date);
        this.tradeTime = timeFormat.format(date);
        this.firstParty = firstParty;
        this.secondParty = secondParty;
        this.sum = sum;
        this.tradeRemark = tradeRemark;
        this.payCT = payCT;
        this.receiveCT = receiveCT;
        this.remainCT = remainCT;
        this.verifyInf = 0;
    }

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

    public String getPayCT() {
        return payCT;
    }

    public void setPayCT(String payCT) {
        this.payCT = payCT;
    }

    public String getReceiveCT() {
        return receiveCT;
    }

    public void setReceiveCT(String receiveCT) {
        this.receiveCT = receiveCT;
    }

    public String getRemainCT() {
        return remainCT;
    }

    public void setRemainCT(String remainCT) {
        this.remainCT = remainCT;
    }

    public int getVerifyInf() {
        return verifyInf;
    }

    public void setVerifyInf(int verifyInf) {
        this.verifyInf = verifyInf;
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
                ", payCT='" + payCT + '\'' +
                ", receiveCT='" + receiveCT + '\'' +
                ", remainCT='" + remainCT + '\'' +
                ", verifyInf=" + verifyInf +
                '}';
    }
}
