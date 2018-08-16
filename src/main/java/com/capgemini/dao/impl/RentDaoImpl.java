package com.capgemini.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.RentDAO;
import com.capgemini.domain.RentEntity;

@Repository
@Transactional
public class RentDaoImpl extends AbstractDao<RentEntity, Long> implements RentDAO{

}
