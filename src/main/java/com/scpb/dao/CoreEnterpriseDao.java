package com.scpb.dao;

import com.scpb.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoreEnterpriseDao {
    String selectLimitById(String id);

    int updateLimitById(@Param("limit")String limit, @Param("id")String id);

    List<Enterprise> selectSupplierById(String id);

    void deleteSupplier(@Param("id")String id, @Param("mySupplier")String mySupplier);

    void insertSupplier(@Param("id")String id, @Param("mySupplier")String mySupplier);
}
