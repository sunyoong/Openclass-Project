package com.icia.openclass.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
public class MainController {
	
	
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	
	

	
//	public MainController() {
//		// REST API 키와 REST API secret 를 아래처럼 순서대로 입력한다.
//		this.api= new IamportClient("8132380719295211","57acf0817d0cd921d7d1183b5e01d13bf9ee48d3cdc9d70f36d88230c0e098d0f009597b9b34c3d7");
//	}
//	
//	@ResponseBody
//	@RequestMapping(value="/verifyIamport/{imp_uid}")
//	public IamportResponse<Payment> paymentByImpUid(Model model, Locale locale, HttpSession session, @PathVariable(value="imp_uid") String imp_uid) throws IamportResponseException, IOException{
//		return api.paymentByImpUid(imp_uid);
//	}
//	
	
	
}
