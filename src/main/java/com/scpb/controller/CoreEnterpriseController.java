package com.scpb.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.CoreEnterpriseService;
import com.scpb.service.TradeService;
import com.scpb.utils.StateMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Array;
import com.scpb.entity.ChainTicket;
import com.scpb.entity.Enterprise;
import com.scpb.service.EnterpriseService;
import com.scpb.service.MemberEnterpriseService;

@Controller
@RequestMapping("/coreEnterprise")
public class CoreEnterpriseController {
	@Resource(name = "chainTicketService")
	private ChainTicketService chainTicketService;

	@Resource(name = "tradeService")
	private TradeService tradeService;

	@Resource(name = "coreEnterpriseService")
	private CoreEnterpriseService coreEnterpriseService;
	
	@Resource(name = "memberEnterpriseService")
	private MemberEnterpriseService memberEnterpriseService;

	@Resource(name = "enterpriseService")
	private EnterpriseService enterpriseService;

	public void setChainTicketService(ChainTicketService chainTicketService) {
		this.chainTicketService = chainTicketService;
	}

	public void setTradeService(TradeService tradeService) {
		this.tradeService = tradeService;
	}

	@RequestMapping(value = "/goDrawCT", method = RequestMethod.GET)
	public String goCoreEnterpriseDrawCT() {
		return "coreEnterprise/drawCT";
	}

	@RequestMapping("/drawSuccess")
	public ModelAndView drawCT(String applicant, String amount, HttpSession session, String deadline,
			String tradeRemark) {

		String drawEnterprise = (String) session.getAttribute("id");
		ChainTicket chainTicket = new ChainTicket(2, amount, deadline, drawEnterprise, drawEnterprise);
		chainTicketService.addChainTicket(chainTicket);
		double limit = Double.valueOf(coreEnterpriseService.getLimitById(drawEnterprise));
		//判断开具金额是否大于当前所拥有额度
		if((limit - Double.valueOf(amount))>0){
			String newLimit = Double.toString(limit - Double.valueOf(amount));
			coreEnterpriseService.modifyLimitById(newLimit, drawEnterprise);

			ChainTicket receiveCT = chainTicket;
			ChainTicket remainCT = new ChainTicket(6, "0", chainTicket.getDeadline(), drawEnterprise, drawEnterprise);
			TradeInformation tradeInformation = new TradeInformation(drawEnterprise, applicant, amount, tradeRemark,
					chainTicket.getId(), receiveCT.getId(), remainCT.getId());
			tradeService.addTradeInformation(tradeInformation);
			tradeService.modifyTradeInfStateById(tradeInformation.getId(), 2);

			ModelAndView mav = new ModelAndView();
			mav.addObject(chainTicket);
			mav.setViewName("coreEnterprise/drawCTSuccess");
			return mav;
		}else{ //如果开具金额设置过大，则返回错误信息
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg","当前设置金额过大");
			mav.setViewName("coreEnterprise/drawCT");
			return mav;
		}
		
	}

	@RequestMapping("/goAllocateLimit")
	public String goAllocateLimit(){
		return "coreEnterprise/allocateLimit";
	}
	
	@RequestMapping("/allocateLimit")
	public ModelAndView allocate(String memberId, String limit, HttpSession session) {
		//核心企业额度减去limit
		String coreEnterpriseId = (String) session.getAttribute("id");

		String oldLimitForCE = coreEnterpriseService.getLimitById(coreEnterpriseId);		
		double oldLimitCE = Double.valueOf(oldLimitForCE);
		String currentLimitForCE = Double.toString(oldLimitCE - Double.valueOf(limit));
		coreEnterpriseService.modifyLimitById(currentLimitForCE, coreEnterpriseId);
		//成员企业额度加上limit
		String oldLimitForME = memberEnterpriseService.getLimitById(memberId);
		if(oldLimitForME==null||oldLimitForME.length()==0)//如果没有记录，则默认额度为0
			oldLimitForME="0";
		double oldLimitME = Double.valueOf(oldLimitForME);
		String currentLimitForME = Double.toString(oldLimitME+Double.valueOf(limit));
		memberEnterpriseService.modifyLimitById(currentLimitForME, memberId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("coreEnterprise/allocateLimitSuccess");		
		mav.addObject("memberId", memberId);
		mav.addObject("limit",currentLimitForME);
		return mav;
	}

	@RequestMapping("/queryLimit")
	@ResponseBody
	public Map<String, String> queryLimit(HttpSession session) {		
		String id = (String) session.getAttribute("id");
//		System.out.println("核心企业 "+id);
		String result = coreEnterpriseService.getLimitById(id);
		Map<String,String> resultMap = new HashMap<String, String>();  
		if(result==null){
			resultMap.put("limitResult", "暂无额度");
		}else{
			resultMap.put("limitResult", result);
		}		
		return resultMap;
	}

	// 链票开具初审
	@RequestMapping("/checkCTs")
	public ModelAndView checkCTs(HttpSession session) {
		String coreEnterpriseId = (String) session.getAttribute("id");
		// test code
//		System.out.println("当前企业:" + coreEnterpriseId);
		// 获取当前企业的成员企业开具的未审核的链票
		List<ChainTicket> chainTicketList = chainTicketService.getUncheckedCTsByCEId(coreEnterpriseId);
		// 测试是否获取查询结果集
//		System.out.println(Arrays.toString(chainTicketList.toArray()));
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicketList", chainTicketList);
		mav.setViewName("coreEnterprise/checkCTs");
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
		mav.setViewName("coreEnterprise/selectedCTDetails");
		return mav;
	}
	
	@RequestMapping("/passCheckCT")
	public ModelAndView passCheckCT(String id, String state) {
		String chainTicketId = id;
		int changedState = Integer.parseInt(state);
		ChainTicket currentCT = chainTicketService.getChainTicketById(id);
		// test code
//		System.out.println("当前企业:" + chainTicketId + "state:" + state);

		// 修改当前选中链票状态
		chainTicketService.setStateByChainTicketId(chainTicketId, changedState);
		// 修改交易信息状态
		tradeService.setVerifyInfByPayCTId(chainTicketId, changedState);
		// 测试是否获取查询结果集
//		System.out.println("修改状态成功");
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicket", currentCT);
		mav.addObject("chainTicketState", StateMap.getState(changedState));
		mav.setViewName("coreEnterprise/selectedCTDetails");
		return mav;
	}

}
