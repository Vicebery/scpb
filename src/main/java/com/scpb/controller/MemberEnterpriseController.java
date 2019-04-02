package com.scpb.controller;

import java.util.ArrayList;
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
import com.scpb.entity.Supplier;
import com.scpb.service.EnterpriseService;
import com.scpb.service.MemberEnterpriseService;
import com.scpb.service.SupplierService;

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
	
	@Resource(name = "supplierService")
	private SupplierService supplierService;

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
    	String oldLimit = memberEnterpriseService.getLimitById(drawEnterprise);
		
		if(oldLimit==null||oldLimit.length()==0||"0".equals(oldLimit)||"0.0".equals(oldLimit)){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("memberEnterprise/drawCT");		
			mav.addObject("msg", "当前额度为0，无法开具");
			return mav;
		}
    	
        double limit = Double.valueOf(oldLimit);
      //判断   当前所拥有额度-开具金额
      	if((limit - Double.valueOf(amount))>=0){
      		//生成处于审核状态的链票，statue为0
            ChainTicket chainTicket = new ChainTicket(amount, deadline, drawEnterprise, drawEnterprise);
            chainTicketService.addChainTicket(chainTicket);
          //修改开具链票后生成的新的额度
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
      	}else{
      		ModelAndView mav = new ModelAndView();
			mav.addObject("msg","当前设置金额过大");
			mav.setViewName("memberEnterprise/drawCT");
			return mav;
      	}
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
	
	//加载供应商集合
	@RequestMapping("/getSupplierList")
	@ResponseBody
	public List<Supplier> getSupplierList(HttpSession session) {		
		String id = (String) session.getAttribute("id");
//		System.out.println("当前企业 "+id);
		List<Supplier> supplierList = new ArrayList<>();		
		supplierList = supplierService.getSupplierById(id);
		//test code
//		System.out.println("供应商企业集合： "+supplierList.toString());
		return supplierList;
	}
}
