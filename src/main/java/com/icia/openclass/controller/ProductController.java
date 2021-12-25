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

import com.icia.openclass.dto.MemberDTO;
import com.icia.openclass.dto.PageDTO;
import com.icia.openclass.dto.ProductDTO;
import com.icia.openclass.service.MemberService;
import com.icia.openclass.service.ProductService;

@Controller
@RequestMapping(value="/product/*")
	
public class ProductController {
	@Autowired
	private MemberService ms;
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private HttpSession session;
	
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
	public String save(@ModelAttribute ProductDTO product) {
		System.out.println("product");
		ps.save(product);
	
		return "product/index";
	}
	
	// 마이클래스 화면요청
	@RequestMapping(value="myclass", method=RequestMethod.GET)
	public String myclass() {
		return "product/myclass";
	}
	
	// 클래스목록
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		List<ProductDTO> productList = ps.findAll();
		PageDTO paging = ps.paging(page);
		System.out.println("productController.productList:" + productList);
		model.addAttribute("productList", productList);
		model.addAttribute("page", paging.getPage());
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
	
	// 페이징처리
	@RequestMapping(value="paging", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		PageDTO paging = ps.paging(page);
		List<ProductDTO> productList = ps.pagingList(page);
		model.addAttribute("paging", paging);
		model.addAttribute("productList", productList);
		return "product/findAll";
	}
	
	
	
	//수강신청 페이지
	@RequestMapping(value="applyform", method=RequestMethod.GET)
	public String applyform(@RequestParam("p_number") long p_number,Model model) {
		ProductDTO product = ps.findById(p_number);
		model.addAttribute("product", product);
		
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
	public String delete(@RequestParam("p_number") long p_number) {
		ps.delete(p_number);
		return "redirect:/product/paging";
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
	
	
	
}