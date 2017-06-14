package com.benz.framework.jpa;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by paulliu on 2016/12/13.
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    protected final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
    }

    @Override
    public Long nextIdentity() {
        Query query = this.entityManager.createNativeQuery("Select IdGenerator.nextval from dual");
        Long newId = ((BigDecimal) query.getSingleResult()).longValue();
        return newId;
//        return UUID.randomUUID().toString().toLowerCase();
    }
}


