package com.sns.untitled.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.untitled.exception.DuplicatedException;
import com.sns.untitled.user.mapper.MemberMapper;
import com.sns.untitled.user.model.User;
import com.sns.untitled.user.service.MemberService;
import com.sns.untitled.utils.SHA256;

@Service
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;

	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper){
		this.memberMapper = memberMapper;
	}

	@Override
	public void register(User user) {
		if(!checkValid(user)){
			throw new DuplicatedException("중복된 아이디가 있습니다.");
		}
		user.setPassword(new SHA256().encrypt(user.getPassword()));
		memberMapper.register(user);
	}

	@Override
	public boolean checkValid(User user) {
		int duplicated = memberMapper.checkDuplicated(user.getId());
		return duplicated == 0;
	}
}
