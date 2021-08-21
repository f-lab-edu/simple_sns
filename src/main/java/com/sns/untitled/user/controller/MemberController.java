package com.sns.untitled.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sns.untitled.user.model.User;
import com.sns.untitled.user.service.MemberService;

@RestController
public class MemberController {
	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService){
		this.memberService = memberService;
	}

	// 회원 가입 controller
	@PostMapping("/members")
	public String register(@Valid @RequestBody User user){
		memberService.register(user);
		return "회원가입이 완료 되었습니다.";
	}
}
