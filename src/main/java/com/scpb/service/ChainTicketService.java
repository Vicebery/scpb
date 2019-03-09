package com.scpb.service;

import java.util.List;

import com.scpb.entity.ChainTicket;

public interface ChainTicketService {

    ChainTicket getChainTicketById(String payCT);

    void addChainTicket(ChainTicket chainTicket);

    void changeCTState(ChainTicket chainTicket);
    
    List<ChainTicket> getChainTicketsByEnterpriseId(String ownerId);
}
