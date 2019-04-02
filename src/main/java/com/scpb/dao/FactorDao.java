package com.scpb.dao;

import java.util.List;

import com.scpb.entity.Factor;

public interface FactorDao {

    void insertFactor(String id);

	List<Factor> selectFactor();
}
