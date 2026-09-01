package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BranchDTO;

@Repository
public class BranchDAOImpl extends BaseDAOImpl<BranchDTO> implements BranchDAOInt {

	@Override
	public Class<BranchDTO> getDTOClass() {
		return BranchDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(BranchDTO dto, CriteriaBuilder builder, Root<BranchDTO> qRoot) {
		
		List<Predicate> whereCondition=new ArrayList<Predicate>();
		
		if(!isEmptyString(dto.getBranchName())) {
			whereCondition.add(builder.like(qRoot.get("branchName"), dto.getBranchName()+"%"));
		}
		
		if(!isEmptyString(dto.getCity())) {
			whereCondition.add(builder.like(qRoot.get("city"), dto.getCity()+"%"));
		}
		
		if(!isEmptyString(dto.getManagerName())) {
			whereCondition.add(builder.like(qRoot.get("managerName"), dto.getManagerName()+"%"));
		}
		
		if(!isEmptyString(dto.getContactNo())) {
			whereCondition.add(builder.like(qRoot.get("contactNo"), dto.getContactNo()+"%"));
		}
		return whereCondition;
	}

}
