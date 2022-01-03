package com.icia.openclass.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.openclass.dto.ApplyDTO;
import com.icia.openclass.dto.MemberDTO;
import com.icia.openclass.dto.PageDTO;
import com.icia.openclass.dto.ProductDTO;
import com.icia.openclass.dto.ReplyDTO;
import com.icia.openclass.service.ApplyService;
import com.icia.openclass.service.MemberService;
import com.icia.openclass.service.OrderService;
import com.icia.openclass.service.ProductService;
import com.icia.openclass.service.ReplyService;

@Controller
@RequestMapping(value="/product/*")
	
public class ProductController {
	@Autowired
	private MemberService ms;
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private ApplyService as;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private OrderService os;
	
	@Autowired
	private ReplyService rs;
	
	// 클래스 index 페이지로 이동
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index(@RequestParam("m_number") long m_number, @RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		session.setAttribute("memberNum", m_number);
		PageDTO paging = ps.paging(page);
		model.addAttribute("page", paging.getPage());
		System.out.println("index에서 page:" + page);
		return "product/index";
	}
	
	// 클래스 등록화면 요청
	@RequestMapping(value="save", method=RequestMethod.GET)
	public String saveform(@RequestParam("m_number") long m_number, Model model) {
		MemberDTO member = ms.findById(m_number);
		System.out.println(member);
		model.addAttribute("m_id", member.getM_id());
		model.addAttribute("m_number", m_number);
		return "product/save";
	}
	
	// 클래스 등록처리
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(@ModelAttribute ProductDTO product, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		System.out.println("product");
		ps.save(product);
		return "redirect:/product/paging?page="+page; 
	}
	
	// 마이클래스 화면요청
	@RequestMapping(value="myclass", method=RequestMethod.GET)
	public String myclass() {
		return "product/myclass";
	}
	
	// 클래스목록
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		List<ProductDTO> product = ps.findAll();
		PageDTO paging = ps.paging(page);
		model.addAttribute("productList", product);
		model.addAttribute("page", paging.getPage());
		System.out.println("productController.productList:" + product);
		return "product/findAll";
	}
	
	// 클래스 상세조회
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detailform(@RequestParam(value="page", required=false, defaultValue="1")int page, @RequestParam("p_number") long p_number, Model model) {
		// 조회수
		ps.updateHits(p_number);
		ProductDTO product = ps.findById(p_number);
		PageDTO paging = ps.paging(page);
		model.addAttribute("product", product);
		model.addAttribute("page", paging.getPage());
		System.out.println("paging.getPage():" + paging.getPage());
		System.out.println("paging :" + paging);
		
		// 수강신청 회원목록 조회 후 detail.jsp로 보내기
		List<ApplyDTO> applyList = as.findAll(p_number);
		model.addAttribute("applyList", applyList);
		
		// 댓글 목록도 화면으로 보내기
		List<ReplyDTO> replyList = rs.findAll(p_number);
		model.addAttribute("replyList", replyList);
		
		
		return "product/detail";
	}
	
	
	// 추천수
	@RequestMapping(value="recommend", method=RequestMethod.POST)
	public @ResponseBody ProductDTO recommend(@RequestParam("p_number") long p_number) {
		ps.recommend(p_number);
		ProductDTO product = ps.findById(p_number);
		System.out.println(product);
		return product;
		
}
	
	// 페이징처리 전체목록조회
	@RequestMapping(value="paging", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		List<ProductDTO> productList = ps.pagingList(page);
		// 여기에 전체목록 불러오는 리스트를 또 추가해야 하나요..? 
		PageDTO paging = ps.paging(page);
		model.addAttribute("paging", paging);
		model.addAttribute("productList", productList);
		System.out.println("ProductController.paging : " + productList);
		return "product/findAll";
	}
	
	
	
	//수강신청 페이지
	@RequestMapping(value="applyform", method=RequestMethod.GET)
	public String applyform(@RequestParam("p_number") long p_number, @RequestParam("m_number") long m_number, Model model) {
		ProductDTO product = ps.findById(p_number);
		MemberDTO member = ms.findById(m_number);
		// ApplyDTO에 수강신청회원 정보 저장
//		Map<String, Long> apply = new HashMap<String, Long>();
//		apply.put("classNum", product.getM_number());
//		apply.put("memberNum", member.getM_number());
//		System.out.println(apply);
//		
//		
//		model.addAttribute("apply", apply);
	    model.addAttribute("product", product);
		model.addAttribute("member", member);
		return "order/order";
	}
	

	// 수강신청인원 저장 결과 detail.jsp로 넘기기 
	@RequestMapping(value="applyNum", method=RequestMethod.POST)
	@ResponseBody public int apply(@RequestParam("p_number") long p_number) {
		ps.apply(p_number); // db에 수강신청인원 저장
		ProductDTO product = ps.findById(p_number);
		return product.getP_applyNum();
	}
	
	
	// 만족도 평가
	@RequestMapping(value="rating", method=RequestMethod.GET)
	@ResponseBody
	public int rating(@ModelAttribute ProductDTO product){//, @RequestParam("p_satisfy")int p_satisfy, @RequestParam("p_number") long p_number) {
		ps.rating(product); // db에 만족도 저장// 이건 성공
		int ratingResult = ps.ratingResult(product.getP_number()); // p_number의 평점들 가져옴
		System.out.println("productController.ratingResult : " + ratingResult);// 이거 성공
		int applyNum = ps.applyNum(product.getP_number());// 수강생 인원수 
		System.out.println(applyNum);
		if(applyNum==0) {
			applyNum=1;
		}
		int satisfy = ratingResult / applyNum;
		System.out.println("satisfy: " + satisfy);
		return satisfy;
	}
	
	
	// 글 삭제
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam("p_number") long p_number, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		// 참조관계 때문에 orderDTO에서 먼저 삭제한 뒤 게시글 삭제 가능
		os.delete(p_number);
		ps.delete(p_number);
		return "redirect:/product/paging?page=" + page;
	}
	
	// 글 수정 화면요청
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updateform(Model model, @RequestParam("p_number") long p_number) {
		ProductDTO product = ps.findById(p_number);
		model.addAttribute("product", product);
		return "product/update";
}
	// 클래스 수정처리
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute ProductDTO product) {
		ps.update(product);
		
		return "redirect:/product/paging?p_number=" + product.getP_number();
	}
	
	// 클래스 신청한 회원목록
//	@RequestMapping(value="applymember", method=RequestMethod.GET)
//	public String applyMember(@RequestParam("p_number") long p_number, Model model) {
//		// 신청회원 리스트
//		List<ProductDTO> applyList = ps.applymember(p_number);
//		// 해당번호 게시글
//		
//		//			List<ProductDTO> applyList = ps.applymember(p_number);
////	System.out.println("applymember : " + applyList);
////	model.addAttribute("applyList", applyList);
//		
//		return "product/applymember?p_number=" + p_number;
//	}

	
	// 조회수 리스트별로 조회(ajax) + 페이징처리(추후에..)
	@RequestMapping(value="selectList", method=RequestMethod.GET)
	public @ResponseBody List<ProductDTO> SelectList(@RequestParam("select") String select, @RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		System.out.println("productController.selectList");
		List<ProductDTO> pList = ps.selectList(select);
		return pList;
	}
	
	// 검색기능
	@RequestMapping(value="search", method=RequestMethod.GET)
	public String Search(@RequestParam(value="page", required=false, defaultValue="1")int page,
			@RequestParam("searchType") String searchType, @RequestParam("keyword") String keyword, Model model) {
		// 페이징처리
		PageDTO searchpaging = ps.searchPaging(page, keyword, searchType);
		List<ProductDTO> searchList = ps.search(searchType, keyword, page);
		
		model.addAttribute("searchpaging", searchpaging);
		model.addAttribute("productList", searchList);
		System.out.println("ProductController.search : " + searchpaging);
		
		/* session.setAttribute("a", searchList); */
		model.addAttribute("a", "1");
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		System.out.println("productController.search");
		return "product/findAll";
	}
	

	
}