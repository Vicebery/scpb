package com.scpb.dao;

import java.util.List;

import com.scpb.entity.ChainTicket;

public interface ChainTicketDao {

	void insertChainTicket(ChainTicket chainTicket);
	
	ChainTicket selectChainTicketById(String id);

    void updateCTState(ChainTicket chainTicket);
    //查找某企业的所有链票
    List<ChainTicket> selectChainTicketsByEnterpriseId(String ownerId);
}
