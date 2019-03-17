package com.scpb.controller;

import javax.annotation.Resource;

import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.CoreEnterpriseService;
import com.scpb.service.TradeService;
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
    @Resource(name = "chainTicketService")
    private ChainTicketService chainTicketService;

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @Resource(name = "coreEnterpriseService")
    private CoreEnterpriseService coreEnterpriseService;

    public void setChainTicketService(ChainTicketService chainTicketService) {
        this.chainTicketService = chainTicketService;
    }

    public void setTradeService(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @RequestMapping("/coreEnterpriseDrawSuccess")
    public ModelAndView drawCT(String drawEnterprise, String applicant, String amount, String deadline,String tradeRemark) {

        ChainTicket chainTicket = new ChainTicket(amount, deadline, drawEnterprise, drawEnterprise);
        chainTicketService.addChainTicket(chainTicket);
        double limit = Double.valueOf(coreEnterpriseService.getLimitById(drawEnterprise));
        String newLimit = Double.toString(limit-Double.valueOf(amount));
        coreEnterpriseService.modifyLimitById(newLimit,drawEnterprise);

        TradeInformation tradeInformation = new TradeInformation(drawEnterprise,applicant,amount,
                chainTicket.getId(),tradeRemark);
        tradeService.addPartTradeInformation(tradeInformation);

        ModelAndView mav = new ModelAndView();
        mav.addObject(chainTicket);
        mav.setViewName("coreEnterpriseDrawCTSuccess");
        return mav;
    }
}
