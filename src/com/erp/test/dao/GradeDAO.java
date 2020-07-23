package com.erp.test.dao;

import java.util.List;
import java.util.Map;

public interface GradeDAO {
	int insertGrade(Map<String, Object> grade);
	int updateGrade(Map<String, Object> grade);
	int deleteGrade(int gNum);
	Map<String, Object> selectGrade(int gNum);
	List<Map<String, Object>> selectGradeList(Map<String, Object> grade);
}
