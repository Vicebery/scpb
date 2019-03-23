package com.scpb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scpb.dao.ChainTicketDao;
import com.scpb.entity.ChainTicket;
import com.scpb.service.ChainTicketService;
import org.springframework.transaction.annotation.Transactional;

@Service("chainTicketService")
public class ChainTicketServiceImpl implements ChainTicketService{
	@Resource(name = "chainTicketDao")
	private ChainTicketDao chainTicketDao;

	@Transactional
	public ChainTicket getChainTicketById(String payCT) {
		return chainTicketDao.selectChainTicketById(payCT);
	}

	@Transactional
	public void addChainTicket(ChainTicket chainTicket) {
		chainTicketDao.insertChainTicket(chainTicket);
		
	}

	@Transactional
	public void changeCTState(ChainTicket chainTicket) {
		chainTicketDao.updateCTState(chainTicket);
	}

	@Transactional
	public void modifyCTStateById(int state, String id) {
		chainTicketDao.updateCTStateById(state,id);
  }

	@Transactional
	public List<ChainTicket> getChainTicketsByEnterpriseId(String ownerId) {
		return chainTicketDao.selectChainTicketsByEnterpriseId(ownerId);
	}

	@Transactional
	public List<ChainTicket> getUncheckedCTsByCEId(String coreEnterpriseId) {
		return chainTicketDao.selectUncheckedCTsByCEId(coreEnterpriseId);
	}

	@Transactional
	public void setStateByChainTicketId(String chainTicketId, int state) {
		chainTicketDao.updateCTStateById(state,chainTicketId);
	}
}
