package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BatchDTO;

@Repository
public class BatchDAOImpl extends BaseDAOImpl<BatchDTO> implements BatchDAOInt{

	@Override
	public Class<BatchDTO> getDTOClass() {
		return BatchDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(BatchDTO dto, CriteriaBuilder builder, Root<BatchDTO> qRoot) {
		
		List<Predicate> whereCondition=new ArrayList<Predicate>();
		
		if(!isEmptyString(dto.getBatchName())) {
			whereCondition.add(builder.like(qRoot.get("batchName"), dto.getBatchName()+"%"));
		}
		if(!isEmptyString(dto.getBatchCode())) {
			whereCondition.add(builder.like(qRoot.get("batchCode"), dto.getBatchCode()+"%"));
		}
		if(!isEmptyString(dto.getTrainerName())) {
			whereCondition.add(builder.like(qRoot.get("trainerName"), dto.getTrainerName()+"%"));
		}
		if(!isEmptyString(dto.getBatchTiming())) {
			whereCondition.add(builder.like(qRoot.get("batchTiming"), dto.getBatchTiming()+"%"));
		}
		
		return whereCondition;
	}

}
