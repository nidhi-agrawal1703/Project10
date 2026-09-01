package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BatchDAOInt;
import com.rays.dto.BatchDTO;

@Service
@Transactional
public class BatchServiceImpl extends BaseServiceImpl<BatchDTO,BatchDAOInt> implements BatchServiceInt {

}
