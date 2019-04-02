package com.scpb.dao;

import com.scpb.entity.Supplier;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierDao {

    void insertSupplier(@Param("id")String id,@Param("name")String name);

	List<Supplier> selectSupplierById(String id);
}
