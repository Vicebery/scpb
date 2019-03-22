package com.scpb.controller;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.TradeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class factorController {
    @Resource(name = "chainticket")
    private ChainTicketService chainTicketService;
    @Resource(name = "tradeService")
    private TradeService tradeService;
    @RequestMapping("/acceptFinancing")
    public void acceptFinancing(HttpServletRequest request,String tradeInfId) {

        TradeInformation tradeInformation = tradeService.getTradeInfById(tradeInfId);
        ChainTicket chainTicket = chainTicketService.getChainTicketById(tradeInformation.getPayCT());

        if(request.getParameter("bntyes")!=null){
            String payCT = tradeInformation.getPayCT();
            String sum = tradeInformation.getSum();
            String firstParty = tradeInformation.getFirstParty();
            String secondParty = tradeInformation.getSecondParty();
            chainTicketService.modifyCTStateById(1,payCT);
            ChainTicket receiveCT = new ChainTicket(sum, chainTicket.getDeadline(), secondParty, chainTicket.getDrawEnterprise());
            String remainCTAmount = Double.toString((Double.valueOf(chainTicket.getAmount())-Double.valueOf(sum)));
            ChainTicket remainCT = new ChainTicket(remainCTAmount, chainTicket.getDeadline(),
                    firstParty, chainTicket.getDrawEnterprise());
            chainTicketService.addChainTicket(receiveCT);
            chainTicketService.addChainTicket(remainCT);
            tradeService.modifyTradeInfById(tradeInfId,2,receiveCT.getId(),remainCT.getId());
        }

    }
}
