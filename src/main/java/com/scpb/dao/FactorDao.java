package com.scpb.dao;

import java.util.List;

import com.scpb.entity.Factor;
import org.apache.ibatis.annotations.Param;

public interface FactorDao {

    void insertFactor(@Param("id") String id, @Param("name") String name);

	List<Factor> selectFactor();
}
