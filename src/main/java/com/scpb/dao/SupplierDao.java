package com.scpb.dao;

import com.scpb.entity.Supplier;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierDao {

    void insertSupplier(String id);

	List<Supplier> selectSupplierById(String id);
}
