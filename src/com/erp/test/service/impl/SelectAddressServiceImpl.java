package com.erp.test.service.impl;

import java.util.List;

import com.erp.test.dao.SelectAddressDAO;
import com.erp.test.dao.impl.SelectAddresssDAOImpl;
import com.erp.test.service.SelectAddresseService;

public class SelectAddressServiceImpl implements SelectAddresseService {

	SelectAddressDAO saDao = new SelectAddresssDAOImpl();
	@Override
	public List<String> selectSidoList(String sido) {
		return saDao.selectSidoList(sido);
		
	}

	@Override
	public List<String> selectGugunList(String sido) {
		return saDao.selectGugunList(sido);
	}

	@Override
	public List<String> selectDongList(String sido, String gugun) {
		return saDao.selectDongList(sido, gugun);
	}

}
