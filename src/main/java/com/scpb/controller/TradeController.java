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
@RequestMapping("/transaction")
public class TradeController {
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

    @RequestMapping("/tradeSuccess")
    public ModelAndView trade(String firstParty, String secondParty, String sum, String payCT,String tradeRemark) {

        ChainTicket chainTicket = chainTicketService.getChainTicketById(payCT);
        chainTicketService.modifyCTStateById(1,payCT);
//        chainTicket.setState(1);
//        chainTicketService.changeCTState(chainTicket);
        ChainTicket receiveCT = new ChainTicket(sum, chainTicket.getDeadline(), secondParty, chainTicket.getDrawEnterprise());
        String remainCTAmount = Double.toString((Double.valueOf(chainTicket.getAmount())-Double.valueOf(sum)));
        ChainTicket remainCT = new ChainTicket(remainCTAmount, chainTicket.getDeadline(),
                firstParty, chainTicket.getDrawEnterprise());
        chainTicketService.addChainTicket(receiveCT);
        chainTicketService.addChainTicket(remainCT);

        TradeInformation tradeInformation = new TradeInformation(firstParty,secondParty,sum,
                tradeRemark,payCT,receiveCT.getId(),remainCT.getId());
        tradeService.addTradeInformation(tradeInformation);

        ModelAndView mav = new ModelAndView();
        mav.addObject(tradeInformation);
        mav.setViewName("tradeSuccess");
        return mav;
    }
}
