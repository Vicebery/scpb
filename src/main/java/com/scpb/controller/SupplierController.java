package com.scpb.controller;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.CoreEnterpriseService;
import com.scpb.service.EnterpriseService;
import com.scpb.service.TradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	@Resource(name = "chainTicketService")
	private ChainTicketService chainTicketService;

	@Resource(name = "enterpriseService")
	private EnterpriseService enterpriseService;

	@Resource(name = "coreEnterpriseService")
	private CoreEnterpriseService coreEnterpriseService;

	@Resource(name = "tradeService")
	private TradeService tradeService;

	public void setChainTicketService(ChainTicketService chainTicketService) {
		this.chainTicketService = chainTicketService;
	}

	public void setTradeService(TradeService tradeService) {

		this.tradeService = tradeService;
	}

	@RequestMapping("/financing")
	public String financing(String ctid, String amount, String factor, String tradeRemark, HttpSession session) {

		String ownerId = (String) session.getAttribute("id");
		String firstParty = (String) session.getAttribute("id");
		ChainTicket chainTicket = chainTicketService.getChainTicketById(ctid);
		ChainTicket receiveCT = new ChainTicket(0, amount, chainTicket.getDeadline(), firstParty,
				chainTicket.getDrawEnterprise());
		String remainCTAmount = Double.toString((Double.valueOf(chainTicket.getAmount()) - Double.valueOf(amount)));
		ChainTicket remainCT = new ChainTicket(3, remainCTAmount, chainTicket.getDeadline(), firstParty,
				chainTicket.getDrawEnterprise());
		chainTicketService.addChainTicket(receiveCT);
		chainTicketService.addChainTicket(remainCT);
		TradeInformation tradeInformation = new TradeInformation(ownerId, factor, amount, tradeRemark, ctid,
				receiveCT.getId(), remainCT.getId());
		tradeService.addTradeInformation(tradeInformation);
		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 2);
		return "supplier/financingApplySuccess";
	}

	@RequestMapping(value = "/queryCT", method = RequestMethod.GET)
	public ModelAndView queryCT(HttpSession session) {
		String id = (String) session.getAttribute("id");
		List<ChainTicket> chainTicketList = chainTicketService.getChainTicketsByEnterpriseId(id);
		// 测试是否获取查询结果集
		// System.out.println(Arrays.toString(chainTicketList.toArray()));
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicketList", chainTicketList);

		mav.setViewName("supplier/queryCT");
		return mav;
	}

	@RequestMapping("/transferCTSuccess")
	public String transferCT(String ctid, String amount, String secondParty, String tradeRemark, HttpSession session) {

		String ownerId = (String) session.getAttribute("id");
		String firstParty = (String) session.getAttribute("id");
		ChainTicket chainTicket = chainTicketService.getChainTicketById(ctid);
		chainTicketService.modifyCTStateById(2, ctid);
		ChainTicket receiveCT = new ChainTicket(1, amount, chainTicket.getDeadline(), firstParty,
				chainTicket.getDrawEnterprise());
		String remainCTAmount = Double.toString((Double.valueOf(chainTicket.getAmount()) - Double.valueOf(amount)));
		ChainTicket remainCT = new ChainTicket(3, remainCTAmount, chainTicket.getDeadline(), firstParty,
				chainTicket.getDrawEnterprise());
		chainTicketService.addChainTicket(receiveCT);
		chainTicketService.addChainTicket(remainCT);
		TradeInformation tradeInformation = new TradeInformation(ownerId, secondParty, amount, tradeRemark, ctid,
				receiveCT.getId(), remainCT.getId());
		tradeService.addTradeInformation(tradeInformation);
		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 2);
		return "supplier/success";
	}

	@RequestMapping(value = "/receiveCT", method = RequestMethod.GET)
	public ModelAndView receiveCT(HttpSession session) {
		String id = (String) session.getAttribute("id");
		// System.out.println(id);
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

		mav.setViewName("supplier/receiveCT");
		return mav;
	}

	@RequestMapping(value = "/receiveCTSuccess")
	public String handleReceive(HttpServletRequest request) {
		String receiveCT = request.getParameter("chainTicketId");
		System.out.println(receiveCT);
		TradeInformation tradeInformation = tradeService.getTradeInfByReceiveCT(receiveCT);
		chainTicketService.modifyCTOwnerIdById(tradeInformation.getSecondParty(), tradeInformation.getReceiveCT());

		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 3);
		return "supplier/receiveCTSuccess";
	}

	@RequestMapping(value = "/receiveCTFail")
	public String handleUnreceive(HttpServletRequest request) {
		String receiveCT = request.getParameter("chainTicketId");
		System.out.println("receiveCT" + receiveCT);
		TradeInformation tradeInformation = tradeService.getTradeInfByReceiveCT(receiveCT);
		// chainTicketService.modifyCTStateById(3,receiveCT);
		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 4);
		ChainTicket chainTicket = chainTicketService.getChainTicketById(receiveCT);
		String enterpriseId = tradeInformation.getFirstParty();
		int enterpriseType = enterpriseService.getEnterpriseById(enterpriseId).getType();
		if (enterpriseType == 1 || enterpriseType == 2) {
			chainTicketService.modifyCTStateById(6, receiveCT);
			String limit = coreEnterpriseService.getLimitById(enterpriseId);
			String newLimit = Double.toString(Double.valueOf(limit) + Double.valueOf(chainTicket.getAmount()));
			coreEnterpriseService.modifyLimitById(newLimit, enterpriseId);
		}
		return "supplier/receiveCTFail";
	}
}
