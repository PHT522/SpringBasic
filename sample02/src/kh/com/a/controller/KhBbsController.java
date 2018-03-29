package kh.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.a.model.BbsDto;
import kh.com.a.service.KhBbsService;

@Controller
public class KhBbsController {

	private static final Logger logger = LoggerFactory.getLogger(KhBbsController.class);
	
	@Autowired
	KhBbsService khBbsService;
	
	
	@RequestMapping(value="bbslist.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String bbslist(Model model) throws Exception{
		
		logger.info("KhBbsController bbslist" + new Date());
		
		List<BbsDto> bbslist = khBbsService.getBbsList();
		
		model.addAttribute("bbslist", bbslist);
		
		return "bbslist";		
	}
	
	@RequestMapping(value="bbswrite.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String bbswrite(Model model) throws Exception{
		
		logger.info("KhBbsController bbswrite" + new Date());
		
		return "bbswrite";
	}
	
	@RequestMapping(value="bbswriteAf.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String bbswriteAf(Model model, BbsDto bbs) throws Exception{
		
		logger.info("KhBbsController bbswriteAf" + new Date());
		
		System.out.println(bbs.toString());
		
		boolean isS = khBbsService.bbswriteAf(bbs);
		if(isS) {
			return "redirect:/bbslist.do";
		}else {
			return "redirect:/bbswrite.do";
		}		
	}
	
	@RequestMapping(value="bbsdetail.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(Model model, BbsDto bbs, HttpServletRequest req) throws Exception{
		
		logger.info("KhBbsController bbsdetail" + new Date());
				
		
		String Sseq = req.getParameter("seq");
		int seq = Integer.parseInt(Sseq);
		System.out.println("seq is " + seq);
		bbs = khBbsService.getBbsDetail(seq);
		System.out.println(bbs.toString());
		model.addAttribute("detail", bbs);
		
		return "bbsdetail";		// bbsdetail.jsp view move		
	}
	
	@RequestMapping(value="bbsupdate.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdate(Model model, HttpServletRequest req) throws Exception{
		logger.info("KhBbsController bbsupdate" + new Date());		
		return "bbsupdate";
		
	}
	
	@RequestMapping(value="bbsupdateAf.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdateAf(Model model, BbsDto bbs, HttpServletRequest req) throws Exception{
		logger.info("KhBbsController bbsupdateAf" + new Date());
				
		khBbsService.bbsupdate(bbs);		
		return "forward:/bbslist.do";
	}
	
	@RequestMapping(value="deletebbs.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String bbsdelets(Model model, HttpServletRequest req) throws Exception{
		logger.info("KhBbsController bbsdelets" + new Date());
		int seq = Integer.parseInt(req.getParameter("seq"));		
		khBbsService.deletebbs(seq);
		return "redirect:/bbslist.do";
	}
	
}
