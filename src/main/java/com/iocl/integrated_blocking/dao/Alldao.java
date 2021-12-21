package com.iocl.integrated_blocking.dao;

import com.iocl.integrated_blocking.entity.SapBlockCustomers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface Alldao extends JpaRepository<SapBlockCustomers, Integer> {

    public ArrayList<SapBlockCustomers> findSapBlockCustomersBySapBlockStatusAndBlockFlagAndSalesoffCode(String sapBlockStatus, String blockFlag, String salesoffCode);

    //    @Modifying
//    @Query(name = "UPDATE SAP_BLOCK_CUSTOMERS SET SAP_BLOCK_STATUS = :sapBlockStatus,BLOCK_DATE = sysdate WHERE SALESOFF_CODE =:salesoff  and SAP_BLOCK_STATUS = :sapBlockStatusPending AND BLOCK_FLAG=:blockFlag", nativeQuery = true)
//    public int updateStatusForBlocking(@Param("sapBlockStatus") String sapBlockStatus,
//                                       @Param("salesoff") String salesoff, @Param("sapBlockStatusPending") String sapBlockStatusPending, @Param("blockFlag") String blockFlag);


    @Modifying
    @Query("update SapBlockCustomers s set s.sapBlockStatus=:sapBlockStatus ,s.blockDate=current_date where  s.salesoffCode=:salesoffCode and s.sapBlockStatus=:sapBlockstatusPending and s.blockFlag=:blockFlag")
    public int updateStatusForBlocking(@Param("sapBlockStatus") String sapBlockStatus, @Param("salesoffCode") String salesoffCode, @Param("sapBlockstatusPending") String sapBlockstatusPending, @Param("blockFlag") String blockFlag);


    @Query("select distinct s.salesoffCode,s.salesorgCode from SapBlockCustomers s order by s.salesoffCode")
    public List<SapBlockCustomers> getsfsdf(String salesoffcode);
public ArrayList<SapBlockCustomers> getSapBlockCustomersBySapBlockStatusAndBlockFlagAndSalesoffCode(String sapBlockstatus,String Blockflag,String salesoffCode);

}
