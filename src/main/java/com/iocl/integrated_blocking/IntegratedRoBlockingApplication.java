package com.iocl.integrated_blocking;

import com.iocl.integrated_blocking.dao.SapblockCustomersDAO;
import com.iocl.integrated_blocking.entity.SapBlockCustomers;
import com.iocl.integrated_blocking.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.security.PublicKey;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class IntegratedRoBlockingApplication implements CommandLineRunner {
    @Autowired
    SapblockCustomersDAO sapblockCustomersDAO;
    @Autowired
    private BlockService blockService;

    public static void main(String[] args) {
        SpringApplication.run(IntegratedRoBlockingApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

blockService.CallSAPPI();
    }

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }

}
