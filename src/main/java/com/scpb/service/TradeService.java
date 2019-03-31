package com.scpb.service;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;

import java.util.List;

public interface TradeService {

    void addTradeInformation(TradeInformation tradeInformation);

    void addPartTradeInformation(TradeInformation tradeInformation);

    TradeInformation getTradeInfById(String tradeInfId);

    void modifyTradeInfById(String tradeInfId, int verifyInf, String receiveCT, String remainCT);

    List<String> getPayCTidBySecondParty(String id);

    List<String> getReceiveCTidBySecondParty(String id);

    TradeInformation getTradeInfByPayCT(String payCT);

    TradeInformation getTradeInfByReceiveCT(String receiveCT);

    void modifyTradeInfStateById(String id, int verifyInf);

	void setVerifyInfByPayCTId(String chainTicketId, int verifyInf);

    List<String> getUncheckedReceiveCTidBySecondParty(String id);
}
