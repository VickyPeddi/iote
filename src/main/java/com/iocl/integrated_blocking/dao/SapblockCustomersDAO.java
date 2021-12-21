package com.iocl.integrated_blocking.dao;

import com.iocl.integrated_blocking.entity.SapBlockCustomers;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Repository
@Transactional

public interface SapblockCustomersDAO extends CrudRepository<SapBlockCustomers, Integer> {


    @Query("select distinct s.salesoffCode,s.salesorgCode from SapBlockCustomers s order by s.salesoffCode")
    public ArrayList<String> getsalesoffcodeandsalesorgcode();

    public ArrayList<SapBlockCustomers> findSapBlockCustomersBySapBlockStatusAndBlockFlagAndSalesoffCode(String sapBlockStatus, String blockFlag, String salesoffCode);

    @Modifying
    @Query("update SapBlockCustomers s set s.sapBlockStatus=:sapBlockStatus ,s.blockDate=current_date where  s.salesoffCode=:salesoffCode and s.sapBlockStatus=:sapBlockstatusPending and s.blockFlag=:blockFlag")
    public int updateStatusForBlocking(@Param("sapBlockStatus") String sapBlockStatus, @Param("salesoffCode") String salesoffCode, @Param("sapBlockstatusPending") String sapBlockstatusPending, @Param("blockFlag") String blockFlag);
}

