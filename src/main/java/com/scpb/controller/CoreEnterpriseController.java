package com.scpb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.Enterprise;
import com.scpb.service.EnterpriseService;

@Controller
@RequestMapping("/coreEnterprise")
public class CoreEnterpriseController {
//	@Resource(name = "chainTicketService")
//	private ChainTicketService chainTicketService;
//	
//	@Resource(name = "enterpriseService")
//	private EnterpriseService enterpriseService;
//
//	public void setEnterpriseService(EnterpriseService enterpriseService) {
//		this.enterpriseService = enterpriseService;
//	}
//
//	public void setChainTicketService(ChainTicketService chainTicketService) {
//		this.chainTicketService = chainTicketService;
//	}
//
//	@RequestMapping("/drawSuccess")
//	public ModelAndView drawChainTicket(String amount, String drawEnterprise, String owerId, String deadline) {
//		int owerType = enterpriseService.getEnterpriseTypeById(owerId);
//		ChainTicket chainTicket = new ChainTicket(amount,deadline,owerId,owerType,drawEnterprise);
//		chainTicketService.addChainTicket(chainTicket);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("id", chainTicket.getId());
//		mav.addObject("drawTime", chainTicket.getDrawTime());
//		mav.addObject("amount", amount);
//		mav.addObject("state", chainTicket.getState());
//		mav.addObject("drawEnterprise", drawEnterprise);
//		mav.addObject("owerEnterprise", owerId);
//		mav.addObject("deadline", deadline);
//		mav.setViewName("drawSuccess");
//		return mav;
//	}
}
