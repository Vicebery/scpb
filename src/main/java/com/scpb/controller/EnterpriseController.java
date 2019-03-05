package com.scpb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scpb.entity.Enterprise;
import com.scpb.service.EnterpriseService;

import javax.annotation.Resource;

@Controller
public class EnterpriseController {
	@Resource(name = "enterpriseService")
	private EnterpriseService enterpriseService;
	
	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value="id",required=true) String id) {
		Enterprise enterprise = enterpriseService.getEnterpriseById(id);
 
        ModelAndView mav = new ModelAndView();
        if (enterprise == null) {
        	//��ת��ʧ��ҳ
        	mav.setViewName("fail");
            return mav;
        } else {
        	//��ת���ɹ�ҳ
        	mav.addObject("id", enterprise.getId());
        	mav.addObject("account", enterprise.getAccount());
        	mav.addObject("pwd", enterprise.getPwd());
        	mav.addObject("bank", enterprise.getBank());
        	mav.addObject("name", enterprise.getName());
        	mav.addObject("UCC", enterprise.getUCC());
        	mav.addObject("LPC", enterprise.getLPC());
        	mav.addObject("type", enterprise.getType());
            mav.setViewName("main");
            return mav;
        }
    }
	
	@RequestMapping(value = "/registerFin", method = RequestMethod.GET)
    public ModelAndView register(String id,String account,String pwd,
								 String bank,String name,String UCC,String LPC,String type){
		Enterprise enterprise = new Enterprise(id,account,pwd,bank,name,UCC,LPC,type);
		enterpriseService.addEnterprise(enterprise);
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.addObject("account", account);
		mav.addObject("pwd", pwd);
		mav.addObject("bank", bank);
		mav.addObject("name", name);
		mav.addObject("UCC", UCC);
		mav.addObject("LPC", LPC);
		mav.addObject("type", type);
		mav.setViewName("registerFin");
		return mav;
	}
}
