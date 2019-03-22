package com.scpb.controller;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;
import com.scpb.service.ChainTicketService;
import com.scpb.service.TradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.geom.AreaOp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("/financing")
    public String financing(String ctid,String amount,String factor,String ownerId,String tradeRemark){
        TradeInformation tradeInformation = new TradeInformation(ownerId,factor,amount,
                tradeRemark,ctid);
        tradeService.addPartTradeInformation(tradeInformation);
        return "financingApplySuccess";
    }


    @RequestMapping(value = "/receiveCT", method = RequestMethod.GET)
    public ModelAndView receiveCT(HttpSession session, HttpServletRequest request) {
        String id = (String) session.getAttribute("id");
//        System.out.println(id);
        List<String> ctids = tradeService.getCTidBySecondParty(id);
//        System.out.println(Arrays.toString(ctids.toArray()));
        List<ChainTicket> chainTicketList = new ArrayList<>();
        for (String ctid:ctids) {
            chainTicketList.add(chainTicketService.getChainTicketById(ctid));
        }
//        List<ChainTicket> chainTicketList = chainTicketService.getChainTicketsByEnterpriseId(id);
        //测试是否获取查询结果集
//        System.out.println(Arrays.toString(chainTicketList.toArray()));
        ModelAndView mav = new ModelAndView();
        mav.addObject("chainTicketList", chainTicketList);

        mav.setViewName("receiveCT");
        return mav;
    }
    @RequestMapping(value = "/receiveCTSuccess")
    public String handleReceive(HttpServletRequest request,HttpSession session){
        String payCT =request.getParameter("chainTicketId");
        System.out.println(payCT);
        ChainTicket chainTicket = chainTicketService.getChainTicketById(payCT);
        TradeInformation tradeInformation = tradeService.getTradeInfByPayCT(payCT);
//        String sum = (String) session.getAttribute("amount");
        String sum = tradeInformation.getSum();

        System.out.println(sum);
//        String tradeInfId = (String) session.getAttribute("tradeInfId");
//        System.out.println(tradeInfId);
//        TradeInformation tradeInformation = tradeService.getTradeInfById(tradeInfId);
        String firstParty = tradeInformation.getFirstParty();
        String secondParty = tradeInformation.getSecondParty();
        chainTicketService.modifyCTStateById(2,payCT);
        ChainTicket receiveCT = new ChainTicket(sum, chainTicket.getDeadline(), secondParty, chainTicket.getDrawEnterprise());
        String remainCTAmount = Double.toString((Double.valueOf(chainTicket.getAmount())-Double.valueOf(sum)));
        ChainTicket remainCT = new ChainTicket(remainCTAmount, chainTicket.getDeadline(),
                firstParty, chainTicket.getDrawEnterprise());
        chainTicketService.addChainTicket(receiveCT);
        chainTicketService.addChainTicket(remainCT);

        tradeService.modifyTradeInfById(tradeInformation.getId(),2,receiveCT.getId(),remainCT.getId());
        return "receiveCTSuccess";
//        return "receiveCTFail";
    }
    @RequestMapping(value = "/receiveCTFail", method = RequestMethod.POST)
    public String handleUnreceive(){
        return "receiveCTFail";
    }
}
