package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.BookDAO;
import com.member.lib.dao.impl.BookDAOImpl;
import com.member.lib.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDAO bookDAO = new BookDAOImpl();

	@Override
	public Map<String, Object> insertBook(Map<String, Object> book) {
		int result = bookDAO.insertBook(book);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "도서 등록완료");

		if (result != 1) {
			rMap.put("msg", "Error");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateBook(Map<String, Object> book) {
		int result = bookDAO.updateBook(book);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "도서 목록 수정완료다 이거야");
		if (result != 1) {
			rMap.put("msg", "Error");

		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteBook(int bNum) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.deleteBook(bNum);
		rMap.put("msg", "도서 목록 삭제 완료");
		// rMap.put("msg",(result!=1)?"도서목록 삭제완료:삭제실패");
		if (result != 1) {

			rMap.put("msg", "삭제 실패했습니다");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectBookList(Map<String, Object> book) {
		return bookDAO.selectBookList(book);
	}

	@Override
	public Map<String, Object> selectBook(int bNum) {
		return bookDAO.selectBook(bNum);
	}
public static void main(String[] args) {
	BookService bs = new BookServiceImpl();
	Map<String,Object> map = new HashMap<>();
	map.put("b_num", 1);
	map.put("b_title", "컴활1급");
	map.put("b_author", "박경훈");
	map.put("b_desc", "앙기모찌");
	System.out.println(bs.deleteBook(1));
	
}
}
