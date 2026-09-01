package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.InquiryDTO;

@Repository
public class InquiryDAOImpl extends BaseDAOImpl<InquiryDTO> implements InquiryDAOInt {

	@Override
	public Class<InquiryDTO> getDTOClass() {
		return InquiryDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(InquiryDTO dto, CriteriaBuilder builder, Root<InquiryDTO> qRoot) {
		
		List<Predicate> whereCondition=new ArrayList<Predicate>();
		
		if(!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName()+"%"));
		}
		if(!isEmptyString(dto.getEmail())) {
			whereCondition.add(builder.like(qRoot.get("email"),dto.getEmail()+"%"));
		}
		if(!isEmptyString(dto.getSubject())) {
			whereCondition.add(builder.like(qRoot.get("subject"), dto.getSubject()+"%"));
		}
		if(!isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus()+"%"));
		}
		return whereCondition;
	}

}
