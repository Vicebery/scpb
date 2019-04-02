package com.scpb.controller;

import com.scpb.service.CoreEnterpriseService;
import com.scpb.service.FactorService;
import com.scpb.service.MemberEnterpriseService;
import com.scpb.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scpb.entity.ChainTicket;
import com.scpb.entity.Enterprise;
import com.scpb.service.ChainTicketService;
import com.scpb.service.EnterpriseService;
import com.scpb.utils.StateMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class EnterpriseController {
	@Resource(name = "enterpriseService")
	private EnterpriseService enterpriseService;

	@Resource(name = "coreEnterpriseService")
	private CoreEnterpriseService coreEnterpriseService;

	@Resource(name = "memberEnterpriseService")
	private MemberEnterpriseService memberEnterpriseService;

	@Resource(name = "supplierService")
	private SupplierService supplierService;

	@Resource(name = "factorService")
	private FactorService factorService;

	@Resource(name = "chainTicketService")
	private ChainTicketService chainTicketService;

	public void setChainTicketService(ChainTicketService chainTicketService) {
		this.chainTicketService = chainTicketService;
	}

	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goLogin() {
		return "login";
	}
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String goRegister() {
		return "register";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String login(String account, String pwd, Map<String, Object> map, HttpSession session) {
		Enterprise enterprise = enterpriseService.getEnterpriseByAccount(account);
		// System.out.println(id);
		if (enterprise == null) {
			map.put("msg1", "该用户不存在");
			return "login";
		} else {
			if (pwd!=null && pwd.equals(enterprise.getPwd())) {
				// 密码匹配成功
				session.setAttribute("id", enterprise.getId());
				session.setAttribute("name", enterprise.getName());
				// 判断企业类型
//				System.out.println("判断企业类型："+enterprise.getName());
				if (enterprise.getType() == 1)
					return "coreEnterprise/home";
				else if (enterprise.getType() == 2)
					return "memberEnterprise/home";
				else if (enterprise.getType() == 3)
					return "supplier/home";
				else if (enterprise.getType() == 4)
					return "factor/home";

			} else {
				map.put("msg2", "用户与密码不匹配");
				return "login";
			}
		}
		return "fail";
	}
	
	@RequestMapping(value = "/registerFin", method = RequestMethod.POST)
	public ModelAndView register(String account, String pwd, String bank, String name, String UCC,
			String LPC, int type,  HttpSession session) {
		Enterprise enterprise = enterpriseService.getEnterpriseByAccount(account);
		if(enterprise == null){
			String id = type + account;  //企业ID设置为==企业类型编号+企业账号
			Enterprise newEnterprise = new Enterprise(id, account, pwd, bank, name, UCC, LPC, type);
			session.setAttribute("id", id);
			enterpriseService.addEnterprise(newEnterprise);
			if(type==1) coreEnterpriseService.addCoreEnterprise(id,name);
			else if(type==2) memberEnterpriseService.addMemberEnterprise(id,name);
			else if(type==3) supplierService.addSupplier(id,name);
			else if(type==4) factorService.addFactor(id,name);
			ModelAndView mav = new ModelAndView();
			mav.addObject("account", account);
			mav.addObject("pwd", pwd);
			mav.addObject("bank", bank);
			mav.addObject("name", name);
			mav.addObject("UCC", UCC);
			mav.addObject("LPC", LPC);
			mav.addObject("type", StateMap.getType(type));
			mav.setViewName("registerFin");
			return mav;
		}else{
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg", "该账户已存在");
			mav.setViewName("register");
			return mav;
		}
		
	}

	@RequestMapping(value = "/chainTickets", method = RequestMethod.GET)
	public ModelAndView queryChainTicketsByEnterpriseId(HttpSession session) {
		String id = (String) session.getAttribute("id");
		// 测试是否输出
//		System.out.println("企业ID:" + id);

		List<ChainTicket> chainTicketList = chainTicketService.getChainTicketsByEnterpriseId(id);
		// 测试是否获取查询结果集
//		System.out.println(Arrays.toString(chainTicketList.toArray()));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("chainTicketList", chainTicketList);

		mav.setViewName("chainTickets");
		return mav;
	}

	@RequestMapping(value = "/managerInfo", method = RequestMethod.GET)
	public ModelAndView goManagerInfo(HttpSession session) {
		String id = (String) session.getAttribute("id");
		Enterprise enterprise = enterpriseService.getEnterpriseById(id);
		ModelAndView mav = new ModelAndView();
		if (enterprise != null)
			mav.addObject(enterprise);
		mav.setViewName("modifyInfo");
		return mav;
	}

	@RequestMapping(value = "/bankInfo", method = RequestMethod.GET)
	public ModelAndView gobankManageInfo(HttpSession session) {
		String id = (String) session.getAttribute("id");
		Enterprise enterprise = enterpriseService.getEnterpriseById(id);
		ModelAndView mav = new ModelAndView();
		if (enterprise != null)
			mav.addObject(enterprise);
		mav.setViewName("bankManageInfo");
		return mav;
	}
	
	@RequestMapping(value = "/execModifyInfo", method = RequestMethod.GET)
	public ModelAndView execmodifyInfo(String account, String pwd, String name, String UCC,
			String LPC,HttpSession session) {
		String id = (String)session.getAttribute("id");
		String bank = enterpriseService.getBankById(id);
		int type = enterpriseService.getEnterpriseTypeById(id);
		Enterprise enterprise = new Enterprise(id, account, pwd, bank, name, UCC, LPC, type);
		enterpriseService.updateEnterprise(enterprise);
		ModelAndView mav = new ModelAndView();
		mav.addObject(enterprise);
		mav.setViewName("modifyInfoSuccess");
		return mav;
	}

	@RequestMapping(value = "/modifyBank", method = RequestMethod.GET)
	public String modifyBank(String bank,HttpSession session){
		String id = (String)session.getAttribute("id");
		enterpriseService.modifyBankById(bank,id);
		return "modifyBankSuccess";
	}

	@RequestMapping(value = "/mySupplier")
	public ModelAndView mySupplier(HttpSession session){
		String id = (String)session.getAttribute("id");
//		System.out.println(id);
		List<Enterprise> suppliers = enterpriseService.getSuppliersById(id);
//		System.out.println(suppliers.toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("suppliers",suppliers);
		mav.setViewName("mySupplier");
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
		mav.setViewName("detailedSupplier");
		return mav;
	}

	@RequestMapping(value = "/goaddSupplier")
	public String goaddSupplier(){
		return "addMySupplier";
	}
	@RequestMapping(value = "/addMySupplier")
	public String addMySupplier(String name,String account,HttpSession session){
		String id = (String)session.getAttribute("id");
		String mySupplier = enterpriseService.getEnterpriseIdByAccount(account);
		enterpriseService.addSupplier(id,mySupplier);
		return "addSuccess";
	}

	@RequestMapping(value = "/deleteSupplier")
	public String deleteSupplier(HttpSession session){
		String mySupplier = (String)session.getAttribute("supplierId");
		String id = (String)session.getAttribute("id");
		enterpriseService.deleteSupplier(id,mySupplier);
		return "deleteSuccess";
	}

	@RequestMapping(value = "/findCTonChain")
	public ModelAndView findCTonChain(String id,String drawEnterprise,int state) {
		String queryInf = drawEnterprise + "," + id;
		File f1 = new File("/opt/gopath/src/github.com/hyperledger/fabric-samples/scpb-blockchain/organization/enterprise/application/query.txt");
		File f2 = new File("/opt/gopath/src/github.com/hyperledger/fabric-samples/scpb-blockchain/organization/enterprise/application/queryResult.txt");
		String queryResult = null;
		try {
			FileWriter fw = new FileWriter(f1);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(queryInf);
			bw.flush();
			bw.close();
			Runtime.getRuntime().exec("sh startQuery.sh").waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try{
			FileReader fr = new FileReader(f2);
			BufferedReader br = new BufferedReader(fr);
			queryResult=br.readLine();
			br.close();

			//清空queryResult.txt代码（有问题，也不需要）
//			ArrayList<String> list = new ArrayList<>();
//			while ((queryResult=br.readLine())!=null){
//				list.add(queryResult);
//			}
//			list.remove(0);
//			FileOutputStream fileOutputStream = new FileOutputStream(f2);
//			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
//			BufferedWriter bw = new BufferedWriter(outputStreamWriter);
//
//			if(list.size() != 0)
//				for (String string : list) {
//					bw.write(string);
//					bw.newLine();
//					System.out.println(string);
//				}
//			else if(list.size() == 0) {
//				bw.write("");
//			}
//			bw.flush();
//			bw.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		String CT[] = queryResult.split(",");
		ChainTicket chainTicket = new ChainTicket(CT[1],CT[6],CT[3],CT[1],state,CT[2],CT[4]);
		ModelAndView mav = new ModelAndView();
		mav.addObject(chainTicket);
		mav.setViewName("detailedCTonChain");
		return mav;
	}
}
