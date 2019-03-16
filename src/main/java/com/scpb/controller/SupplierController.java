package com.scpb.controller;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.TradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Resource(name = "chainTicketService")
    private ChainTicketService chainTicketService;

    @Resource(name = "tradeService")
    private TradeService tradeService;

    public void setChainTicketService(ChainTicketService chainTicketService) {
        this.chainTicketService = chainTicketService;
    }

    public void setTradeService(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @RequestMapping("/supplierReceiveCTSuccess")
    public ModelAndView trade(String drawEnterprise, String applicant, String drawCTId, String amount, String tradeRemark) {

        ChainTicket chainTicket = chainTicketService.getChainTicketById(drawCTId);
        chainTicketService.modifyCTStateById(1,drawCTId);
        ChainTicket receiveCT = new ChainTicket(amount, chainTicket.getDeadline(), applicant, chainTicket.getDrawEnterprise());
        ChainTicket remainCT = new ChainTicket("0", chainTicket.getDeadline(),
                drawEnterprise, chainTicket.getDrawEnterprise());
        chainTicketService.modifyCTStateById(1,remainCT.getId());
        chainTicketService.addChainTicket(receiveCT);
        chainTicketService.addChainTicket(remainCT);

        TradeInformation tradeInformation = new TradeInformation(drawEnterprise,applicant,amount,
                tradeRemark,drawCTId,receiveCT.getId(),remainCT.getId());
        tradeService.addTradeInformation(tradeInformation);

        ModelAndView mav = new ModelAndView();
        mav.addObject(receiveCT);
        mav.setViewName("supplierReceiveCTSuccess");
        return mav;
    }
}
