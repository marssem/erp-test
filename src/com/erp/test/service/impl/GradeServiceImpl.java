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
		int g = gDAO.insertGrade(grade);
		 Map<String, Object> rMap = new HashMap<>();
		 rMap.put("msg", "입력 완료됨");
		 if(g != 1) {
			 rMap.put("msg", "입력 안됨");
		 }
		return rMap;
	}

	@Override
	public Map<String, Object> updateGrade(Map<String, Object> grade) {
		int g = gDAO.updateGrade(grade);
		 Map<String, Object> rMap = new HashMap<>();
		 rMap.put("msg", "갱신 완료됨");
		 if(g != 1) {
			 rMap.put("msg", "갱신 안됨");
		 }
		return rMap;
	}

	@Override
	public Map<String, Object> deleteGrade(int gNum) {
		 Map<String, Object> rMap = new HashMap<>();
		 rMap.put("msg", "삭제 완료됨");
		 if(gNum != 1) {
			 rMap.put("msg", "삭제 안됨");
		 }
		return rMap;
	}

	@Override
	public Map<String, Object> selectGrade(int gNum) {
		 
		return gDAO.selectGrade(gNum);
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		return gDAO.selectGradeList(grade);
	}

}
