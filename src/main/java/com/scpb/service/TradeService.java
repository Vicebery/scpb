package com.scpb.service;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;

import java.util.List;

public interface TradeService {

    void addTradeInformation(TradeInformation tradeInformation);

    void addPartTradeInformation(TradeInformation tradeInformation);

    TradeInformation getTradeInfById(String tradeInfId);

    void modifyTradeInfById(String tradeInfId, int verifyInf, String receiveCT, String remainCT);

    List<String> getCTidBySecondParty(String id);

    TradeInformation getTradeInfByPayCT(String payCT);
}
