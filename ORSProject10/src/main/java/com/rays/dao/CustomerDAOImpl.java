package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl extends BaseDAOImpl<CustomerDTO> implements CustomerDAOInt {

	@Override
	public Class<CustomerDTO> getDTOClass() {
		return CustomerDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CustomerDTO dto, CriteriaBuilder builder, Root<CustomerDTO> qRoot) {
		
		List<Predicate> whereCondition=new ArrayList<Predicate>();
		
		if(!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName()+"%"));
		}
		if(!isEmptyString(dto.getEmail())) {
			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail()+"%"));
		}
		if(!isEmptyString(dto.getPhoneNumber())) {
			whereCondition.add(builder.like(qRoot.get("phoneNumber"), dto.getPhoneNumber()+"%"));
		}
		if(!isEmptyString(dto.getAddress())) {
			whereCondition.add(builder.like(qRoot.get("address"), dto.getAddress()+"%"));
		}
		return whereCondition;
	}

}
