package com.scpb.service;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;

public interface TradeService {

    void addTradeInformation(TradeInformation tradeInformation);

    void addPartTradeInformation(TradeInformation tradeInformation);

    TradeInformation getTradeInfById(String tradeInfId);

    void modifyTradeInfById(String tradeInfId, int verifyInf, String receiveCT, String remainCT);
}
