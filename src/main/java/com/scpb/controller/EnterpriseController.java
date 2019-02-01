package com.scpb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scpb.entity.Enterprise;
import com.scpb.service.EnterpriseService;


@Controller
public class EnterpriseController {
	@Autowired
	private EnterpriseService enterpriseService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value="id",required=true) String id) {
		Enterprise enterprise = enterpriseService.getEnterpriseById(id);
 
        ModelAndView mav = new ModelAndView();
        if (enterprise == null) {
        	//跳转至失败页
        	mav.setViewName("fail");
            return mav;
        } else {
        	//跳转至成功页
        	mav.addObject("id", enterprise.getId());
        	mav.addObject("account", enterprise.getAccount());
        	mav.addObject("pwd", enterprise.getPwd());
        	mav.addObject("bank", enterprise.getBank());
        	mav.addObject("name", enterprise.getName());
        	mav.addObject("UCC", enterprise.getUCC());
        	mav.addObject("LPC", enterprise.getLPC());
        	mav.addObject("type", enterprise.getType());
            mav.setViewName("success");
            return mav;
        }
    }
}
