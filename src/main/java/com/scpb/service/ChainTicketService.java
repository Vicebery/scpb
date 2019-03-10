package com.scpb.service;

import com.scpb.entity.ChainTicket;

public interface ChainTicketService {

    ChainTicket getChainTicketById(String payCT);

    void addChainTicket(ChainTicket chainTicket);

    void changeCTState(ChainTicket chainTicket);

    void modifyCTStateById(int state, String id);
}
