package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends AbstractDao<AddressEntity, Long> implements AddressDao
{

}
