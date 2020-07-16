package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.MemberDAO;
import com.member.lib.dao.impl.MemberDAOImpl;
import com.member.lib.service.MemberService;

import test.Execute;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO = new MemberDAOImpl();

	@Override
	public Map<String, Object> insertMember(Map<String, Object> member) {
		int result = memberDAO.insertMember(member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤버 등록완료");

		if (result != 1) {
			rMap.put("msg", "Error");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateMember(Map<String, Object> member) {
		int result = memberDAO.updateMember(member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤버 수정완료");

		if (result != 1) {
			rMap.put("msg", "Error");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteMember(int mNum) {
		int result = memberDAO.deleteMember(mNum);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "삭제 완료");
		if (result != 1) {
			rMap.put("msg", "Error");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {

		return memberDAO.selectMemberList(member);
	}

	@Override
	public Map<String, Object> selectMember(int mNum) {
		return memberDAO.selectMember(mNum);
	}

	public static void main(String[] args) {
		MemberService ms = new MemberServiceImpl();
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("m_num", 1);
		rMap.put("m_name", "zq기모찌");
		rMap.put("m_id", "앙기qwe모찌");
		rMap.put("m_pwd", "ㅋㅋ기re모찌");
		System.out.println(ms.updateMember(rMap));
			// System.out.println(mem);
		}
		/* System.out.println(ms.insertMember(rMap)); */

	}

