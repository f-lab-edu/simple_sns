package com.sns.untitled.user.service;

import static org.mockito.BDDMockito.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sns.untitled.user.mapper.MemberMapper;
import com.sns.untitled.user.model.User;
import com.sns.untitled.user.service.impl.MemberServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

	@InjectMocks
	private MemberServiceImpl memberService;

	@Mock
	private MemberMapper memberMapper;

	private User user = new User();

	@BeforeEach
	public void setUp(){
		user.setPassword("1111111111");
		user.setBirth(new Date());
		user.setEmail("hello@naver.com");
		user.setName("user");
		user.setId("superUser1");
	}
	@Test
	public void 회원가입_성공_테스트(){
		// given
		given(memberMapper.checkDuplicated(user.getId())).willReturn(0);

		// when
		memberService.register(user);

		//then
		then(memberMapper).should(times(1)).register(any());
	}

}
