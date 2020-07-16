package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.LentDAO;
import com.member.lib.dao.impl.LentDAOImpl;
import com.member.lib.service.LentService;

public class LentServiceImpl implements LentService {
	private LentDAO lentDAO = new LentDAOImpl();

	@Override
	public Map<String, Object> insertLent(Map<String, Object> lent) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.insertLent(lent);
		rMap.put("msg", "빌린도서 입력완료");

		if (result != 1) {
			rMap.put("msg", "Error");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateLent(Map<String, Object> lent) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.insertLent(lent);
		rMap.put("msg", "연장 수정완료 ");
		if (result != 1) {
			rMap.put("msg", "error");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteLent(int lNum) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.deleteLent(lNum);
		rMap.put("msg", "연장 반납완료 ");
		if (result != 1) {
			rMap.put("msg", "error");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectLentList(Map<String, Object> lent) {

		return lentDAO.selectLentList(lent);
	}

	@Override
	public Map<String, Object> selectLent(int lNum) {

		return lentDAO.selectLent(lNum);
	}
public static void main(String[] args) {
	LentService ls = new LentServiceImpl();
	Map<String,Object> rMap = new HashMap<>();
	System.out.println(ls.selectLentList(rMap));
}
}
