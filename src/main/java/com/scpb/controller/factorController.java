package com.scpb.controller;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.CoreEnterpriseService;
import com.scpb.service.TradeService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/factor")
public class factorController {
	@Resource(name = "chainTicketService")
	private ChainTicketService chainTicketService;
	@Resource(name = "tradeService")
	private TradeService tradeService;
	@Resource(name = "coreEnterpriseService")
	private CoreEnterpriseService coreEnterpriseService;

	@RequestMapping(value = "/financingExamine", method = RequestMethod.GET)
	public ModelAndView receiveCT(HttpSession session) {
		String id = (String) session.getAttribute("id");
		System.out.println("session中的id" + id);
		List<String> ctids = tradeService.getReceiveCTidBySecondParty(id);
		// System.out.println(Arrays.toString(ctids.toArray()));
		List<ChainTicket> chainTicketList = new ArrayList<>();
		for (String ctid : ctids) {
			chainTicketList.add(chainTicketService.getChainTicketById(ctid));
		}
		// List<ChainTicket> chainTicketList =
		// chainTicketService.getChainTicketsByEnterpriseId(id);
		// 测试是否获取查询结果集
		// System.out.println(Arrays.toString(chainTicketList.toArray()));
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicketList", chainTicketList);
		
		mav.setViewName("factor/financingExamine");
		return mav;
	}

	@RequestMapping("/acceptFinancing")
	public String acceptFinancing(HttpSession session, HttpServletRequest request) {

		String factorId = (String) session.getAttribute("id");
		String receiveCT = request.getParameter("chainTicketId");
		System.out.println("receiveCT" + receiveCT);
		TradeInformation tradeInformation = tradeService.getTradeInfByReceiveCT(receiveCT);
		chainTicketService.modifyCTOwnerIdById(factorId, receiveCT);
		chainTicketService.modifyCTStateById(3, receiveCT);
		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 3);
		return "factor/success";
	}

	@RequestMapping("/rejectFinancing")
	public String rejectFinancing(HttpServletRequest request) {

		String receiveCT = request.getParameter("chainTicketId");
		System.out.println("receiveCT" + receiveCT);
		TradeInformation tradeInformation = tradeService.getTradeInfByReceiveCT(receiveCT);
		chainTicketService.modifyCTStateById(3, receiveCT);
		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 1);
		return "factor/fail";
	}
	
	@RequestMapping("/goSetLimit")
	public String goSetLimit() {
		return "factor/setLimit";
	}
	
	@RequestMapping("/setLimit")
	public ModelAndView setLimit(String id, String limit) {
		//返回影响行数
		int result = coreEnterpriseService.modifyLimitById(limit, id);
		ModelAndView mav = new ModelAndView();
		if(result==1){
			mav.addObject("id", id);
			mav.addObject("limit", limit);
			mav.setViewName("factor/setLimitSuccess");
			return mav;
		}else{
			mav.setViewName("factor/setLimitFail");
			return mav; 
		}
	}
}
