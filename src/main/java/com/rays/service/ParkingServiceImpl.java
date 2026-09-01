package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ParkingDAOInt;
import com.rays.dto.ParkingDTO;

@Service
@Transactional
public class ParkingServiceImpl extends BaseServiceImpl<ParkingDTO,ParkingDAOInt> implements ParkingServiceInt{

}
