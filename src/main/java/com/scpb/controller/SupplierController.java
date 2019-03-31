package com.scpb.controller;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.Enterprise;
import com.scpb.entity.Supplier;
import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.CoreEnterpriseService;
import com.scpb.service.EnterpriseService;
import com.scpb.service.SupplierService;
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
import java.util.Map;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	@Resource(name = "chainTicketService")
	private ChainTicketService chainTicketService;

	@Resource(name = "enterpriseService")
	private EnterpriseService enterpriseService;

	@Resource(name = "supplierService")
	private SupplierService supplierService;

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

	@RequestMapping("/gofinancing")
	public String gofinancing(String id,HttpSession session){
		session.setAttribute("ctid",id);
		return "supplier/financing";
	}

	@RequestMapping("/gotransferCT")
	public String gotransferCT(String id,HttpSession session){
		session.setAttribute("ctid",id);
		return "supplier/transfer";
	}

	@RequestMapping(value = "/chooseFinancCT", method = RequestMethod.GET)
	public ModelAndView financing(HttpSession session) {
		String id = (String) session.getAttribute("id");
		List<ChainTicket> chainTicketList = chainTicketService.getAliveChainTicketsByEnterpriseId(id);
		// 测试是否获取查询结果集
		// System.out.println(Arrays.toString(chainTicketList.toArray()));
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicketList", chainTicketList);

		mav.setViewName("supplier/chooseFinancCT");
		return mav;
	}
	@RequestMapping(value = "/chooseTransferCT", method = RequestMethod.GET)
	public ModelAndView chooseTransferCT(HttpSession session) {
		String id = (String) session.getAttribute("id");
		List<ChainTicket> chainTicketList = chainTicketService.getAliveChainTicketsByEnterpriseId(id);
		// 测试是否获取查询结果集
		// System.out.println(Arrays.toString(chainTicketList.toArray()));
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicketList", chainTicketList);

		mav.setViewName("supplier/chooseTransferCT");
		return mav;
	}

	@RequestMapping("/financing")
	public String financing( String amount, String factor, String tradeRemark,Map<String, Object> map, HttpSession session) {

		String ctid = (String) session.getAttribute("ctid");
		String ownerId = (String) session.getAttribute("id");
		String firstParty = (String) session.getAttribute("id");
		ChainTicket chainTicket = chainTicketService.getChainTicketById(ctid);
        if(Double.valueOf(amount)>Double.valueOf(chainTicket.getAmount())){
            map.put("msg","融资金额超出链票原有金额，请重新选择");
            return "supplier/financing";
        }
		ChainTicket receiveCT = new ChainTicket(0, amount, chainTicket.getDeadline(), firstParty,
				chainTicket.getDrawEnterprise());
		String remainCTAmount = Double.toString((Double.valueOf(chainTicket.getAmount()) - Double.valueOf(amount)));
		ChainTicket remainCT = new ChainTicket(3, remainCTAmount, chainTicket.getDeadline(), firstParty,
				chainTicket.getDrawEnterprise());
		chainTicketService.modifyCTStateById(6,ctid);
		chainTicketService.addChainTicket(receiveCT);
		chainTicketService.addChainTicket(remainCT);
		TradeInformation tradeInformation = new TradeInformation(ownerId, factor, amount, tradeRemark, ctid,
				receiveCT.getId(), remainCT.getId());
		tradeService.addTradeInformation(tradeInformation);
		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 2);
		return "supplier/financingApplySuccess";
	}

	@RequestMapping("/transferCTSuccess")
	public String transferCT(String amount, String secondParty, String tradeRemark, Map<String, Object> map, HttpSession session) {

		String ctid = (String) session.getAttribute("ctid");
		String ownerId = (String) session.getAttribute("id");
		String firstParty = (String) session.getAttribute("id");
		ChainTicket chainTicket = chainTicketService.getChainTicketById(ctid);
		if(Double.valueOf(amount)>Double.valueOf(chainTicket.getAmount())){
		    map.put("msg","转让金额超出链票原有金额，请重新选择");
		    return "supplier/transfer";
        }
		chainTicketService.modifyCTStateById(2, ctid);
		ChainTicket receiveCT = new ChainTicket(1, amount, chainTicket.getDeadline(), firstParty,
				chainTicket.getDrawEnterprise());
		String remainCTAmount = Double.toString((Double.valueOf(chainTicket.getAmount()) - Double.valueOf(amount)));
		ChainTicket remainCT = new ChainTicket(3, remainCTAmount, chainTicket.getDeadline(), firstParty,
				chainTicket.getDrawEnterprise());
		chainTicketService.modifyCTStateById(6,ctid);
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
	public ModelAndView handleReceive(String id) {
		String receiveCT = id;
//		System.out.println(receiveCT);
		ChainTicket chainTicket = chainTicketService.getChainTicketById(receiveCT);
		TradeInformation tradeInformation = tradeService.getTradeInfByReceiveCT(receiveCT);
		chainTicketService.modifyCTOwnerIdById(tradeInformation.getSecondParty(), tradeInformation.getReceiveCT());
		chainTicketService.modifyCTStateById(3,receiveCT);
		tradeService.modifyTradeInfStateById(tradeInformation.getId(), 3);
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicket",chainTicket);
		mav.setViewName("supplier/receiveCTSuccess");
		return mav;
	}

	@RequestMapping(value = "/receiveCTFail")
	public String handleUnreceive(String id) {
		String receiveCT = id;
//		System.out.println("receiveCT" + receiveCT);
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

	@RequestMapping(value = "/mySupplier")
	public ModelAndView mySupplier(HttpSession session){
		String id = (String)session.getAttribute("id");
//		System.out.println(id);
		List<Enterprise> suppliers = supplierService.getSuppliersById(id);
//		System.out.println(suppliers.toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("suppliers",suppliers);
		mav.setViewName("supplier/mySupplier");
		return mav;
	}

	@RequestMapping(value = "/detailedSupplier")
	public ModelAndView detailedSupplier(String account,HttpSession session){
		String id = enterpriseService.getEnterpriseIdByAccount(account);
		session.setAttribute("supplierId",id);
//		System.out.println(account);
		Enterprise supplier = enterpriseService.getEnterpriseById(id);
//		System.out.println(supplier);
		ModelAndView mav = new ModelAndView();
		mav.addObject("supplier",supplier);
		mav.setViewName("supplier/detailedSupplier");
		return mav;
	}

	@RequestMapping(value = "/goaddSupplier")
	public String goaddSupplier(){
		return "supplier/addMySupplier";
	}
	@RequestMapping(value = "/addMySupplier")
	public String addMySupplier(String name,String account,HttpSession session){
		String id = (String)session.getAttribute("id");
		String mySupplier = enterpriseService.getEnterpriseIdByAccount(account);
		supplierService.addSupplier(id,mySupplier);
		return "supplier/addSuccess";
	}
	@RequestMapping(value = "/deleteSupplier")
	public String deleteSupplier(HttpSession session){
		String mySupplier = (String)session.getAttribute("supplierId");
		String id = (String)session.getAttribute("id");
		supplierService.deleteSupplier(id,mySupplier);
		return "supplier/deleteSuccess";
	}
}
