package kh.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
	public String loginAf(Model model, MemberDto mem, HttpServletRequest req) throws Exception {
		logger.info("khMemberService regi" + new Date());				
		
		MemberDto login = null;
		
		login = khMemberService.login(mem);
		
		
		if(login != null && !login.getId().equals("")) {	// 성공시
			req.getSession().setAttribute("login", login);		// web페이지가 닫힐때까지 유지(시간정할수있다)			
			return "redirect:/bbslist.do";
		}else {	// 실패시
		//	return "login";	// view로 이동 컨트롤러로 이동해야한다 수정하자
		//	return "login.do";	//여기는 자바이다... 이렇게는 컨트럴로러 가는게 아니다.(sendRedirect,forward)
			return "redirect:/login.do";	// 컨트롤러에서 컨트롤러로 이동 보따리 안가지고가니 Spring에서는 redirect
		//	return "forward:/lofin.do";		// 보따리를 가지고 갈려면 forward이용
		}		
	}
	
	// logout
	@RequestMapping(value="logout.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(Model model, MemberDto mem, HttpServletRequest req) throws Exception{
		logger.info("khMemberService logout" + new Date());
		
		req.getSession().invalidate();
		
		return "login";
	}
	
}
