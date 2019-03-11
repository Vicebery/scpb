package com.scpb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scpb.dao.ChainTicketDao;
import com.scpb.entity.ChainTicket;
import com.scpb.service.ChainTicketService;

@Service("chainTicketService")
public class ChainTicketServiceImpl implements ChainTicketService{
	@Resource(name = "chainTicketDao")
	private ChainTicketDao chainTicketDao;

	@Override
	public ChainTicket getChainTicketById(String payCT) {
		return chainTicketDao.selectChainTicketById(payCT);
	}

	public void addChainTicket(ChainTicket chainTicket) {
		chainTicketDao.insertChainTicket(chainTicket);
		
	}

	public void changeCTState(ChainTicket chainTicket) {
		chainTicketDao.updateCTState(chainTicket);
	}


	public void modifyCTStateById(int state, String id) {
		chainTicketDao.updateCTStateById(state,id);
  }
  
	public List<ChainTicket> getChainTicketsByEnterpriseId(String ownerId) {
		return chainTicketDao.selectChainTicketsByEnterpriseId(ownerId);
	}
}
