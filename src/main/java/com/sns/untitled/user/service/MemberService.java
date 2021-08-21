package com.sns.untitled.user.service;

import com.sns.untitled.user.model.User;

public interface MemberService {
	void register(User user);
	boolean checkValid(User user);
}
