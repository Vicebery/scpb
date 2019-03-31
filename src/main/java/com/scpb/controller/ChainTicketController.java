package com.scpb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scpb.entity.ChainTicket;
import com.scpb.service.ChainTicketService;
import com.scpb.service.EnterpriseService;
import com.scpb.utils.StateMap;

@Controller
@RequestMapping("/chainTicket")
public class ChainTicketController {
    @Resource(name = "chainTicketService")
    private ChainTicketService chainTicketService;

    @Resource(name = "enterpriseService")
    private EnterpriseService enterpriseService;

    public void setEnterpriseService(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    public void setChainTicketService(ChainTicketService chainTicketService) {
        this.chainTicketService = chainTicketService;
    }

    @RequestMapping("/drawSuccess")
    public ModelAndView drawChainTicket(String amount, String drawEnterprise, String ownerId, String deadline) {
        ChainTicket chainTicket = new ChainTicket(amount, deadline, ownerId, drawEnterprise);
        chainTicketService.addChainTicket(chainTicket);
        ModelAndView mav = new ModelAndView();
        mav.addObject("id", chainTicket.getId());
        mav.addObject("drawTime", chainTicket.getDrawTime());
        mav.addObject("amount", amount);
        mav.addObject("state", StateMap.getState(chainTicket.getState()));
        mav.addObject("drawEnterprise", drawEnterprise);
        mav.addObject("ownerEnterprise", ownerId);
        mav.addObject("deadline", deadline);
        mav.setViewName("drawSuccess");
        return mav;
    }
}
