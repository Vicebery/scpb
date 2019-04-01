package com.scpb.controller;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.CoreEnterpriseService;
import com.scpb.service.TradeService;

import com.scpb.utils.StateMap;
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
		List<String> ctids = tradeService.getUncheckedReceiveCTidBySecondParty(id);
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

	@RequestMapping("/checkCTDetails")
	public ModelAndView checkCTDetails(String id) {
		// test code
//		System.out.println("当前企业:" + coreEnterpriseId);
		// 获取当前企业的成员企业开具的未审核的链票
		ChainTicket selectedCT = chainTicketService.getChainTicketById(id);
		// 测试是否获取查询结果集
//		System.out.println(Arrays.toString(chainTicketList.toArray()));
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicket", selectedCT);
		mav.addObject("chainTicketState", StateMap.getState(selectedCT.getState()));
		mav.setViewName("factor/selectedCTDetails");
		return mav;
	}

	@RequestMapping("/passCheckCT")
	public ModelAndView passCheckCT(String id, String state,HttpSession session) {
		String chainTicketId = id;
		String factorId = (String)session.getAttribute("id");
		int changedState = Integer.parseInt(state);
		TradeInformation tradeInformation = tradeService.getTradeInfByReceiveCT(chainTicketId);
		ChainTicket currentCT = chainTicketService.getChainTicketById(id);
		// test code
//		System.out.println("当前企业:" + chainTicketId + "state:" + state);

		// 修改当前选中链票状态
        chainTicketService.modifyCTStateById(3,chainTicketId);
        if(changedState == 3){
            chainTicketService.modifyCTOwnerIdById(factorId,chainTicketId);
        }
//		chainTicketService.setStateByChainTicketId(chainTicketId, changedState);
		// 修改交易信息状态
        tradeService.modifyTradeInfStateById(tradeInformation.getId(),changedState);
//		tradeService.modifyTradeInfStateById(tradeInformation.getId(),3);
		// 测试是否获取查询结果集
//		System.out.println("修改状态成功");
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicket", currentCT);
		mav.addObject("chainTicketState", StateMap.getState(changedState));
		mav.setViewName("factor/selectedCTDetails");
		return mav;
	}

//	@RequestMapping("/acceptFinancing")
//	public String acceptFinancing(HttpSession session, HttpServletRequest request) {
//
//		String factorId = (String) session.getAttribute("id");
//		String receiveCT = request.getParameter("chainTicketId");
//		System.out.println("receiveCT" + receiveCT);
//		TradeInformation tradeInformation = tradeService.getTradeInfByReceiveCT(receiveCT);
//		chainTicketService.modifyCTOwnerIdById(factorId, receiveCT);
//		chainTicketService.modifyCTStateById(3, receiveCT);
//		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 3);
//		return "factor/success";
//	}
//
//	@RequestMapping("/rejectFinancing")
//	public String rejectFinancing(HttpServletRequest request) {
//
//		String receiveCT = request.getParameter("chainTicketId");
//		System.out.println("receiveCT" + receiveCT);
//		TradeInformation tradeInformation = tradeService.getTradeInfByReceiveCT(receiveCT);
//		chainTicketService.modifyCTStateById(3, receiveCT);
//		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 1);
//		return "factor/fail";
//	}
	
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
