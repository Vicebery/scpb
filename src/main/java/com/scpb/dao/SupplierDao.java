package com.scpb.dao;

import com.scpb.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierDao {

    List<Enterprise> selectSupplierById(String id);

    void insertSupplier(@Param("id")String id, @Param("mySupplier")String mySupplier);

    void deleteSupplier(@Param("id")String id, @Param("mySupplier")String mySupplier);
}
