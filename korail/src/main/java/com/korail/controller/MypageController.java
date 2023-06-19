package com.korail.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.MypageService;
import com.korail.vo.MemberVo;
import com.korail.vo.SessionVo;

@Controller
public class MypageController {

	@Autowired
	private MypageService mypageService;

	@RequestMapping(value="/mypage_receipt.do", method=RequestMethod.GET)
	public String mypage_receipt() {
		return "/my_page/my_page_receipt";
	}

	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public ModelAndView my_page(HttpSession session) {
		ModelAndView model = new ModelAndView();

		SessionVo svo = (SessionVo) session.getAttribute("svo");

		List<MemberVo> getUserinfo = mypageService.getInfo(svo.getId());

		String memberId = getUserinfo.get(0).getId();
		String memberPass = getUserinfo.get(0).getPass();
		String memberPnumber = getUserinfo.get(0).getPnumber();

		int countNum = mypageService.getCount(memberId);

		session.setAttribute("countNum", countNum);
		session.setAttribute("memberId", memberId);
		session.setAttribute("memberPass", memberPass);
		session.setAttribute("memberPnumber", memberPnumber);

		model.addObject("countNum", countNum);
		model.addObject("memberId", memberId);
		model.addObject("memberPass", memberPass);
		model.addObject("memberPnumber", memberPnumber);
		model.setViewName("/my_page/my_page");

		return model;
	}

	@RequestMapping(value = "/mypage_modal.do", method = RequestMethod.GET)
	public String my_page_modal() {

		return "/my_page/mypage_modal";
	}

	@RequestMapping(value = "/mypage_Phoneproc.do", method = RequestMethod.POST)
	public ModelAndView mypage_Phoneproc(HttpSession session, String usrPw4, String usrPw5) {
		ModelAndView model = new ModelAndView();

		SessionVo svo = (SessionVo) session.getAttribute("svo");
		HashMap<String, String> param = new HashMap<String, String>();

		List<MemberVo> getUserinfo = mypageService.getInfo(svo.getId());
		String memberId = getUserinfo.get(0).getId();
		String pass = getUserinfo.get(0).getPass();

		if (usrPw4.equals(pass)) {
			param.put("memberId", memberId);
			param.put("pnumber", usrPw5);

			int result = mypageService.getPnumberUpdate(param);
			if (result == 1) {
				model.addObject("c_pnum", "ok");
				model.addObject("pnumber", usrPw5);
				model.setViewName("/my_page/my_page");
			} else {
				model.addObject("passc_receipt", "fail");
				throw new RuntimeException("업데이트에 실패하였습니다.");
			}
		} else {
		}

		return model;
	}

	@RequestMapping(value = "/mypage_wtihProc.do", method = RequestMethod.POST)
	public String mypage_wtihProc(HttpSession session, String usrPw) {
		SessionVo svo = (SessionVo) session.getAttribute("svo");

		String memberId = mypageService.getInfo(svo.getId()).get(0).getId();

		int result = mypageService.getWithresult(memberId);
		if(result == 1) {
			session.invalidate();
		}
		return "main_train";
	}

	@RequestMapping(value = "/mypage_cpassProc.do", method = RequestMethod.POST)
	public ModelAndView my_page_cpass(HttpSession session, String usrPw1, String usrPw2) {
		ModelAndView model = new ModelAndView();
		SessionVo svo = (SessionVo) session.getAttribute("svo");
		HashMap<String, String> param = new HashMap<String, String>();

		List<MemberVo> getUserinfo = mypageService.getInfo(svo.getId());
		String memberId = getUserinfo.get(0).getId();

		param.put("memberId", memberId);
		param.put("nPass", usrPw1);
		param.put("cPass", usrPw2);
		int result = mypageService.getPassupdate(param);
		if (result == 1) {
			model.addObject("c_pass", "ok");
			model.setViewName("/my_page/my_page");
		} else {
			throw new RuntimeException("업데이트에 실패하였습니다.");
		}

		return model;
	}
}
