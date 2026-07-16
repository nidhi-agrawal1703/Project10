package com.rays.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.MarksheetDAOInt;
import com.rays.dto.MarksheetDTO;

@Service
@Transactional
public class MarksheetServiceImpl extends BaseServiceImpl<MarksheetDTO,MarksheetDAOInt> implements MarksheetServiceInt{

	
	public MarksheetDTO findByName(String name, UserContext userContext) {
		
	return baseDao.findByUniqueKey("name", name, userContext);
	
	}

	
	public MarksheetDTO findByRollNo(String rollNo, UserContext userContext) {
		
		return baseDao.findByUniqueKey("rollNo", rollNo, userContext);
		
	}

	
	public List<MarksheetDTO> getMeritList(UserContext userContext) {
		
		return baseDao.getMeritList();
	}

}
