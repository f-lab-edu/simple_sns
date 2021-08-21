package com.sns.untitled.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sns.untitled.user.model.User;

@Mapper
@Repository
public interface MemberMapper {
	int checkDuplicated(String id);
	int register(User user);
}
