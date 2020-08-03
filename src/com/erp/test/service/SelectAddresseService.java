package com.erp.test.service;

import java.util.List;

public interface SelectAddresseService {
	List<String> selectSidoList(String sido);
	List<String> selectGugunList(String sido);
	List<String> selectDongList(String sido, String gugun);
}
