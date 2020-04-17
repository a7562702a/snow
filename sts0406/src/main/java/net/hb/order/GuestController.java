package net.hb.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView; //수요일오후추가


@Controller
public class GuestController {	
	private static final Logger logger=LoggerFactory.getLogger(GuestController.class);
	
	//컨트롤문서에서 GuestDAO문서접근 개체연결
	@Autowired
	GuestDAO dao; 
	
	
	@RequestMapping(value="/guest2.do", method=RequestMethod.GET)
	public String g_write() {
	   return "guestWrite";
	}//end
	
	
	@RequestMapping("/guest.do")
	public String guest_write() {
	  return "guestWrite";  //guestWrite.jsp
	}//end
	
	
	@RequestMapping("/guestInsert.do")
	public String guest_insert(GuestDTO dto) {
	  dao.dbInsert(dto); 
	  return "redirect:/guestList.do";
	}//end
	
	
	@RequestMapping("/guestList2.do")
	public String guest_select2(Model model) {//복사본
		int Gtotal = dao.dbCount();
		List<GuestDTO> LG = dao.dbSelect();
		model.addAttribute("Gtotal", Gtotal);
		model.addAttribute("LG", LG);
	    return "guestList"; 
	}//end==========================================
	
	@RequestMapping("/guestList.do")
	public ModelAndView guest_select() {
		ModelAndView mav = new ModelAndView( );
		int Gtotal = dao.dbCount();
		List<GuestDTO> LG = dao.dbSelect();
		mav.addObject("LG", LG);
		mav.addObject("Gtotal", Gtotal);
		mav.setViewName("guestList");
	    return mav; 
	}//end==========================================
	
	
	@RequestMapping("/guestDetail.do")
	public String guest_detail(@RequestParam("idx") int data, Model model) {
	  GuestDTO dto=dao.dbDetail(data);
	  model.addAttribute("dto", dto);
	  return "guestDetail";
	}
	
	@RequestMapping("/guestDelete.do")
	public String guest_delete( ) {
		
 	 return "redirect:/guestList.do";
	}//end
	
}//Controller class END











