package com.scpb.dao;

import com.scpb.entity.ChainTicket;

public interface ChainTicketDao {

	void insertChainTicket(ChainTicket chainTicket);
	ChainTicket selectChainTicketById(String id);

    void updateCTState(ChainTicket chainTicket);
}
