package com.scpb.dao;

import com.scpb.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnterpriseDao {
	int deleteByPrimaryKey(String id);
	 
    void insertEnterprise(Enterprise enterprise);
 
    Enterprise selectByPrimaryKey(String id);
    
    Enterprise selectEnterpriseById(String id);
    
	Enterprise selectEnterpriseByAccount(String account);

	int selectEnterpriseTypeById(String owerId);

	void updateEnterprise(Enterprise enterprise);

    String selectEnterpriseIdByAccount(String account);

    List<Enterprise> selectMySupplierById(String id);

    void insertMySupplier(@Param("id")String id, @Param("mySupplier")String mySupplier);

    void deleteMySupplier(@Param("id")String id, @Param("mySupplier")String mySupplier);

    String selectBankById(String id);

    void updateBankById(@Param("bank")String bank,@Param("id")String id);

}
