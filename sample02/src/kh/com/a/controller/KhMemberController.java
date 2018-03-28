package kh.com.a.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.a.model.MemberDto;
import kh.com.a.service.KhMemberService;

@Controller
public class KhMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(KhMemberController.class);

	@Autowired
	KhMemberService khMemberService;
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("khMemberService login" + new Date());		
		return "login";	//login.jsp로 이동
	}
	
	@RequestMapping(value="regi.do", method=RequestMethod.GET)
	public String regi(Model model) {
		
		logger.info("khMemberService regi" + new Date());		
		return "regi";	//regi.jsp로 이동
	}
	
	@RequestMapping(value="regiAf.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String regiAf(Model model, MemberDto dto) throws Exception {
		
		logger.info("khMemberService regi" + new Date());
		
		System.out.println(dto.toString());	
		boolean isS = khMemberService.addmember(dto);
		if(isS) {
			return "login";
		}else {
			return "regi";
		}		
	}
	
	@RequestMapping(value="loginAf.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String loginAf(Model model, String id) throws Exception {
		logger.info("khMemberService regi" + new Date());
		
		System.out.println("id="+id);
		
		boolean isS =  khMemberService.idcheck(id);
		if(isS) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
		
		return "login";
	}
	
}
