package com.iocl.integrated_blocking.service;


import com.iocl.integrated_blocking.dao.SapblockCustomersDAO;
import com.iocl.integrated_blocking.entity.SapBlockCustomers;
import com.iocl.integrated_blocking.payload.BulkBlockRequestPayLoad;
import com.iocl.integrated_blocking.payload.ItCustomerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class BlockService {
    @Autowired
    private SapblockCustomersDAO sapblockCustomersDAO;

    public ResultSet resultSet;


    public void CallSAPPI() {

        try {
            long startTime = 0L;
            long endTime = 0L;
            long timeTaken = 0L;

            ArrayList<String> getsalesoffcodeandsalesorgcode = sapblockCustomersDAO.getsalesoffcodeandsalesorgcode();
            Map<String, String> salesoffcodeandsalesorgcode = new HashMap<>();
            String salesoffcode = null;
            String salesorgcode = null;
            for (String allvalues : getsalesoffcodeandsalesorgcode) {
                String[] split = allvalues.split(",");

                for (int i = 0; i <= split.length; i++) {
                    salesoffcodeandsalesorgcode.put(split[0], split[1]);
                }
            }
            startTime = System.currentTimeMillis();
            for (Map.Entry<String, String> entry : salesoffcodeandsalesorgcode.entrySet()) {
                salesoffcode = entry.getKey();
                salesorgcode = entry.getValue();
                System.out.println("salesoffcode " + salesoffcode + " salesorgcode " + salesorgcode);
                int a = blockROSalesOff(salesorgcode, salesoffcode);
                System.out.println("Blocked Salesoff" + a);
                endTime = System.currentTimeMillis();
                timeTaken = endTime - startTime;
                System.out.println("Time taken in the process of  BLOCKING, SALESOFFICE " + salesoffcode + "  is:: "
                        + timeTaken + " ms  at " + new Date());
                startTime = endTime;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public int blockROSalesOff(String salesorgcode, String salesoffcode) {
        long startTime = 0L;
        long endTime = 0L;
        long timeTaken = 0L;
        BlockService blockService = new BlockService();
        String[] message = null;
        String[][] arr = (String[][]) null;
        String RO_Code = "";
        String blockID = "";
        String division = "";
        String query = "";
        String query1 = "";
        int rowsMerged = 0;
        int updatedRows = 0;
        String mergeblockingDetails = "";
        int blockAttemptNo = 0;
        int index = 0;
//        try {

        ArrayList<SapBlockCustomers> sapBlockCustomersBySapBlockStatusAndBlockFlagAndSalesoffCode = sapblockCustomersDAO
                .findSapBlockCustomersBySapBlockStatusAndBlockFlagAndSalesoffCode("P", "P", salesoffcode);

        int rows = sapBlockCustomersBySapBlockStatusAndBlockFlagAndSalesoffCode.size();

        System.out.println("rpws" + rows);
        if (rows == 0) {
            return 0;
        }
        arr = new String[4][rows];
        message = new String[rows];

        for (SapBlockCustomers sale : sapBlockCustomersBySapBlockStatusAndBlockFlagAndSalesoffCode) {
            RO_Code = String.valueOf(sale.getCustcode());
            blockAttemptNo = sale.getBlockAttemptNo();
            division = sale.getDivision();
            arr[0][index] = RO_Code;
            arr[1][index] = blockID;
            arr[2][index] = ("" + blockAttemptNo);
            arr[3][index] = division;
            index++;
        }
        int statusForBlocking = sapblockCustomersDAO.updateStatusForBlocking("I", salesoffcode, "P", "P");
        System.out.println("status for blocking" + statusForBlocking);
        startTime = System.currentTimeMillis();
        message = blockService.blockCheck(arr[0], arr[3], salesorgcode);
        timeTaken = endTime - startTime;
        System.out.println("2." + "Time taken in SAP Blocking ROCODE  salesoff " + salesoffcode + " is:: " + timeTaken + " ms at" + new Date());
//
//
//
//
//            startTime = System.currentTimeMillis();
//            message = blockService.blockCheck(arr[0], arr[3], salesorgcode);
//            endTime = System.currentTimeMillis();
//            timeTaken = endTime - startTime;
//            System.out.println("2." + "Time taken in SAP Blocking ROCODE  salesoff " + salesoffcode + " is:: " + timeTaken
//                    + " ms at" + new Date());
//
//            if (statusForBlocking == message.length) {
//                startTime = System.currentTimeMillis();
//                for (int j = 0; j < message.length; j++) {
//                    try {
//                        if (message[j] != null) {
//                            if ((message[j].trim().equalsIgnoreCase("Order blocked!!Delivery blocked!!Bill blocked!!"))
//                                    || (message[j].trim()
//                                    .equalsIgnoreCase("Custmer is already blocked in sales area!!"))) {
//                                System.out.println(arr[0][j] + " ,Msg: " + message[j]);
//
//                                query1 = "update cmsro.SAP_BLOCK_CUSTOMERS set SAP_BLOCK_MSG = '" + message[j]
//                                        + "' ,  DATE_UPDATED = sysdate,"
//                                        + " SAP_BLOCK_STATUS = 'S', BLOCK_CONF_DATETIME = sysdate, BLOCK_FLAG='B' where block_id = "
//                                        + arr[1][j] + " and SAP_BLOCK_STATUS = 'I' and block_attempt_no=" + arr[2][j];
//                            } else {
//                                System.out.println(arr[0][j] + " ,Msg: " + message[j]);
//
//                                query1 = "update cmsro.SAP_BLOCK_CUSTOMERS set SAP_BLOCK_MSG = '" + message[j]
//                                        + "' , DATE_UPDATED = sysdate,"
//                                        + " SAP_BLOCK_STATUS = 'R' ,SMS_STATUS='R' where block_id = " + arr[1][j]
//                                        + " and SAP_BLOCK_STATUS = 'I' and block_attempt_no=" + arr[2][j];
//                            }
//                        }
//
//                        mergeblockingDetails = null;
//                    } catch (Exception EE) {
//                        System.out.println(EE);
//                    }
//
//                    rowsMerged = 0;
//                    updatedRows = 0;
//                }
//                endTime = System.currentTimeMillis();
//                timeTaken = endTime - startTime;
//                System.out.println("Time taken in Database Activity to update records by salesOff " + salesoffcode
//                        + " is:: " + timeTaken + " ms at" + new Date());
//
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }

//        if (statusForBlocking == message.length) {
//            for (int j = 0; j < message.length; j++) {
//                try {
//                    if (message[j] != null) {
//                        if ((message[j].trim().equalsIgnoreCase("Order blocked!!Delivery blocked!!Bill blocked!!")) || (message[j].trim().equalsIgnoreCase("Custmer is already blocked in sales area!!"))) {
//                    }
//            }
        return 0;
    }

    public String[] blockCheck(String[] roCodeArr, String[] roDivision, String soCode) {
        String[] msg = null;

        return msg;
    }
//
//    public String[] get_message(String[] roCodeArr, String[] roDivision, String soCode) {
//        String[] msg = null;
//        BulkBlockRequestPayLoad requestPaylod = new BulkBlockRequestPayLoad();
//        ItCustomerItem itCustomerItem = new ItCustomerItem();
//        ArrayList<ItCustomerItem> customerList = new ArrayList<>();
//        tobeBlockedList.forEach(customer -> {
//            try {
////
//                ItCustomerItem item = new ItCustomerItem();
//                item.setKunnr("0000" + customer.getCustcode());
//                item.setpOrdBlk(11);
//                item.setpDelBlk(10);
//                item.setpBillBlk(10);
//                item.setSpart(customer.getDivision());
//                item.setVtweg("RE");
//                item.setVkorg(customer.getSalesorg());
//                customerList.add(item);
//                customer.setUnblockStatus("I");
//                customer.setDateUpdated(LocalDateTime.now());
//                sapUnblockCustomersDAO.save(customer);
//
//                custcodeBlockIdMap.put(customer.getCustcode(), customer.getBlockId() + "##" + customer.getUnblockAttemptNo());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        return msg;
//    }

//test
//	public ArrayList<SapBlockCustomers> findSapBlockCustomersBySapBlockStatusAndBlockFlagAndSalesoffCode(String sapBlockStatus, String blockFlag, String salesoffCode){
//		resultSet.e
//	}

}