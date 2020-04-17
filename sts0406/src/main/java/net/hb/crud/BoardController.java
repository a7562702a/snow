package net.hb.crud;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//controller문서 dao 개체연결
	@Inject
	@Autowired
	//BoardDAO dao;
	BoardDAOImp dao;
	
	
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public String board_write( ) {
		return "boardWrite";
	}//end
	
	
	@RequestMapping("/boardInsert.do")
	public String board_insert(BoardDTO dto) {
			String path=application.getRealPath("/resources/upload");
			System.out.println(path);
			String img=dto.getUpload_f().getOriginalFilename();
			File file = new File(path,img);//경로파일화
		try {
			dto.getUpload_f().transferTo(file);
//			FileCopyUtils.copy(dto.getUpload_f().getBytes(),file);
//			File target=new File(path,img);
//			FileCopyUtils.copy(dto.getUpload_f().getBytes(),target);
//			dto.getUpload_f().transferTo(target);
		}catch(Exception ex) {System.out.println("파일에러:"+ex);}
			dto.setImg_file_name(img);
			System.out.println("컨트롤 물리적파일="+dto.getImg_file_name());
			System.out.println();
			dao.dbInsert(dto);//디오자바문서의 메소드호출
			return "redirect:/boardList.do";
		
	}//end
	
	@RequestMapping("/boardList.do")
	public String board_select(HttpServletRequest request,Model model) {
		 String pnum;
		 int pageNUM, pagecount;
		 int start , end ; 
		 int startpage , endpage ;  
		 int temp;
		 
		 String skey="", sval="";
		 String returnpage=""; 
		 //역순으로 행번호 출력
		 int Rnumber ;
		 
		 pnum=request.getParameter("pageNum");
		 if(pnum==null||pnum=="") {
			 pnum="1";
		 }
		 pageNUM=Integer.parseInt(pnum);// choose 27page
		 
		 skey=request.getParameter("keyfield");
		 sval=request.getParameter("keyword");
		 if(skey == null ||  skey == "" || sval==null || sval==""){
			skey="title";
			sval="";
		 }
			returnpage="&keyfield="+skey+"&keyword="+sval;
			 	 
		 int GGtotal=dao.dbCount();//342건
		 int Gtotal=dao.dbCount(skey,sval);
		 start=(pageNUM-1)*10+1;
		 end=pageNUM*10;
		 
		 if(Gtotal%10==0){ pagecount=Gtotal/10; }
		 else{ pagecount=(Gtotal/10)+1; }
			
	     temp=(pageNUM-1)%10;  //6
		 startpage=pageNUM-temp; //21
		 endpage=startpage+9;  //30
		 if(endpage > pagecount){ endpage=pagecount; } 
		 //List<BoardDTO> LG=dao.dbSelect();
		 List<BoardDTO> LG=dao.dbSelect(start,end,skey,sval);
		 model.addAttribute("startpage",startpage);
		 model.addAttribute("endpage",endpage);
		 model.addAttribute("pagecount",pagecount);
		 model.addAttribute("pageNUM",pageNUM);
		 model.addAttribute("returnpage",returnpage);
		 model.addAttribute("skey",skey);
		 model.addAttribute("sval",sval);
		 model.addAttribute("Gtotal", Gtotal);
		 model.addAttribute("GGtotal", GGtotal);
		 
		 model.addAttribute("LG",LG);
		 return "boardList";
	}//end
	
	@RequestMapping("/boardList2.do")
	public ModelAndView board_select2() {
		ModelAndView mav=new ModelAndView();
		int Gtotal=dao.dbCount();
		List<BoardDTO> LG=dao.dbSelect();
		mav.addObject("LG",LG);
		mav.addObject("Gtotal",Gtotal);
		mav.setViewName("guestList");
		return mav;
	}//end
	
	@RequestMapping("/boardDelete.do")
	public String board_delete(HttpServletRequest request) {
		int data=Integer.parseInt(request.getParameter("idx"));
		dao.dbdelete(data);
		return "redirect:/boardList.do";
	}//end
	
	@RequestMapping("/boardDetail.do")
	public String board_detail(@RequestParam("idx")int data,Model model) {
		model.addAttribute("dto",dao.dbDetail(data));
		return "boardDetail";
	}
	
	@RequestMapping("/boardPreEdit.do")
	public String board_preEdit(@RequestParam("idx") int data ,Model model) {
		model.addAttribute("dto",dao.dbDetail(data));
		return "boardEdit";
	}
	
	@RequestMapping("/boardEdit.do")
	public String board_edit(BoardDTO dto ) {
		   String path=application.getRealPath("/resources/upload");
		   System.out.println(path) ;
		   
		   String img=dto.getUpload_f().getOriginalFilename();
		   File file = new File(path, img); 
		   try{
			   dto.getUpload_f().transferTo(file); 
			   }catch (Exception e){
				   System.out.println("Error:"+e);
			}
		   dto.setImg_file_name(img);
		   dao.dbEdit(dto);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/download.do")
	public String board_download(HttpServletRequest request, HttpServletResponse response) {
      String data="";		
	 try {	
	  String filename=URLEncoder.encode(request.getParameter("idx"), "UTF-8");
	  //String filename=request.getParameter("fidx");
	  //에러이유 The valid characters are defined in RFC 7230 and RFC 3986
	  data=request.getParameter("Gidx");
	  System.out.println("\n다운로드 filename="+filename+" Gidx="+data);
	  
	  String path=application.getRealPath("/resources/upload");
	  System.out.println(path);
	 
	  filename=URLEncoder.encode(filename,"UTF-8");
      response.setHeader("Content-Disposition", "attachment;filename="+filename);
	  File file=new File(path,filename);
	 
		 InputStream is=new FileInputStream(file);
		 OutputStream os=response.getOutputStream();
		 byte[ ] b=new byte[(int)file.length()];
		
		 is.read(b,0,b.length);
		 os.write(b);
		 is.close(); os.close(); 
	  }catch(Exception ex) { }
	  return "redirect:/detail.do?Gidx="+data;
   }//end
}// BoardController class end
