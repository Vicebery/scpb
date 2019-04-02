package com.scpb.dao;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradeDao {
	void insertTradeInformation(TradeInformation tradeInformation);

	void insertPartTradeInformation(TradeInformation tradeInformation);

	TradeInformation selectTradeInfById(String id);

	void updateTradeInfById(@Param("id") String id, @Param("verifyInf") int verifyInf,
			@Param("receiveCT") String receiveCT, @Param("remainCT") String remainCT);

	List<String> selectPayCTidBySecondParty(String id);

	TradeInformation selectTradeInfByPayCT(String payCT);

	void updateVerifyInfByPayCTId(@Param("payCT") String chainTicketId, @Param("verifyInf") int verifyInf);

	List<String> selectReceiveCTidBySecondParty(String id);

	TradeInformation selectTradeInfByReceiveCT(String receiveCT);

	void updateTradeInfStateById(@Param("id") String id, @Param("verifyInf") int verifyInf);

    List<String> selectUnchekedReceiveCTidBySecondParty(String id);

    String selectTradeRemarkByReceiveCT(String id);
}
