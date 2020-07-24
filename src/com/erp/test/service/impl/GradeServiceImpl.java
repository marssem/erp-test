package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.GradeDAO;
import com.erp.test.dao.impl.GradeDAOImpl;
import com.erp.test.service.GradeService;

public class GradeServiceImpl implements GradeService {
	private GradeDAO gDAO = new GradeDAOImpl();
	@Override
	public Map<String, Object> insertGrade(Map<String, Object> grade) {
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", gDAO.insertGrade(grade)==1?"입력성공":"입력실패");
		return rMap;
	}

	@Override
	public Map<String, Object> updateGrade(Map<String, Object> grade) {
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", gDAO.updateGrade(grade)==1?"수정성공":"수정실패");
		return rMap;
	}

	@Override
	public Map<String, Object> deleteGrade(Map<String, Object> grade) {
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", gDAO.deleteGrade(grade)==1?"삭제성공":"삭제실패");
		return rMap;
	}

	@Override
	public Map<String, Object> selectGrade(Map<String, Object> grade) {
		return gDAO.selectGrade(grade);
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		return gDAO.selectGradeList(grade);
	}

}
