package com.yzu.zhang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.zhang.dao.IMemberDao;
import com.yzu.zhang.model.Member;

@Service
public class MemberService {
	
	@Autowired
	private IMemberDao memberDao;
	
	public void add(Member member) {
		memberDao.add(member);
	}

	public Member get(String id) {
		Member member = memberDao.get(id);
		return member;
	}

	public void delete(String id) {
		memberDao.delete(id);
	}

}
