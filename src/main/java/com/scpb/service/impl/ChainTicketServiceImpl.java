package com.scpb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scpb.dao.ChainTicketDao;
import com.scpb.entity.ChainTicket;
import com.scpb.service.ChainTicketService;

@Service("chainTicketService")
public class ChainTicketServiceImpl implements ChainTicketService{
	@Resource(name = "chainTicketDao")
	private ChainTicketDao chainTicketDao;
	
	public void addChainTicket(ChainTicket chainTicket) {
		chainTicketDao.insertChainTicket(chainTicket);
		
	}

}
