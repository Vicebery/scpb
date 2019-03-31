package com.scpb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.TradeService;
import com.scpb.utils.StateMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.Enterprise;
import com.scpb.service.EnterpriseService;
import com.scpb.service.MemberEnterpriseService;

import java.util.List;

@Controller
@RequestMapping("/memberEnterprise")
public class MemberEnterpriseController {
    @Resource(name = "chainTicketService")
    private ChainTicketService chainTicketService;

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @Resource(name = "enterpriseService")
    private EnterpriseService enterpriseService;

    @Resource(name = "memberEnterpriseService")
    private MemberEnterpriseService memberEnterpriseService;

    public void setChainTicketService(ChainTicketService chainTicketService) {
        this.chainTicketService = chainTicketService;
    }

    public void setTradeService(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @RequestMapping(value = "/goDrawCT", method = RequestMethod.GET)
    public String goMemberEnterpriseDrawCT(){
        return "memberEnterprise/drawCT";
    }
    @RequestMapping("/drawCT")
    public ModelAndView drawCT(String applicant, String amount,
                               String deadline, String tradeRemark, HttpSession session) {
    	String drawEnterprise = (String) session.getAttribute("id");
    	//生成处于审核状态的链票，statue为0
        ChainTicket chainTicket = new ChainTicket(amount, deadline, drawEnterprise, drawEnterprise);
        chainTicketService.addChainTicket(chainTicket);
        //修改开具链票后生成的新的额度
        double limit = Double.valueOf(memberEnterpriseService.getLimitById(drawEnterprise));
        String newLimit = Double.toString(limit-Double.valueOf(amount));
        memberEnterpriseService.modifyLimitById(newLimit,drawEnterprise);
        ChainTicket receiveCT = chainTicket;
		ChainTicket remainCT = new ChainTicket(6, "0", chainTicket.getDeadline(), drawEnterprise, drawEnterprise);
        //生成新的交易记录，状态为0--审核中
		TradeInformation tradeInformation = new TradeInformation(drawEnterprise, applicant, amount, tradeRemark,
				chainTicket.getId(), receiveCT.getId(), remainCT.getId());
		tradeService.addTradeInformation(tradeInformation);
        
        ModelAndView mav = new ModelAndView();
        mav.addObject(chainTicket);
        mav.addObject("chainTicketState", StateMap.getState(chainTicket.getState()));
        mav.setViewName("memberEnterprise/drawCTSuccess");
        return mav;
    }

    @RequestMapping(value = "/mySupplier")
    public ModelAndView mySupplier(HttpSession session){
        String id = (String)session.getAttribute("id");
//		System.out.println(id);
        List<Enterprise> suppliers = memberEnterpriseService.getSuppliersById(id);
//		System.out.println(suppliers.toString());
        ModelAndView mav = new ModelAndView();
        mav.addObject("suppliers",suppliers);
        mav.setViewName("memberEnterprise/mySupplier");
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
        mav.setViewName("memberEnterprise/detailedSupplier");
        return mav;
    }

    @RequestMapping(value = "/goaddSupplier")
    public String goaddSupplier(){
        return "memberEnterprise/addMySupplier";
    }
    
    @RequestMapping(value = "/addMySupplier")
    public String addMySupplier(String name,String account,HttpSession session){
        String id = (String)session.getAttribute("id");
        String mySupplier = enterpriseService.getEnterpriseIdByAccount(account);
        memberEnterpriseService.addSupplier(id,mySupplier);
        return "memberEnterprise/addSuccess";
    }
    
    @RequestMapping(value = "/deleteSupplier")
    public String deleteSupplier(HttpSession session){
        String mySupplier = (String)session.getAttribute("supplierId");
        String id = (String)session.getAttribute("id");
        memberEnterpriseService.deleteSupplier(id,mySupplier);
        return "memberEnterprise/deleteSuccess";
    }
    
	@RequestMapping("/queryLimit")
	@ResponseBody
	public Map<String, String> queryLimit(HttpSession session) {		
		String id = (String) session.getAttribute("id");
		
		String result = memberEnterpriseService.getLimitById(id);
		Map<String,String> resultMap = new HashMap<String, String>();  
		if(result==null){
			resultMap.put("limitResult", "暂无额度");
		}else{
			resultMap.put("limitResult", result);
		}		
		return resultMap;
	}
}
