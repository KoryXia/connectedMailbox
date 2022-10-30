package com.noralsy.connected_mailbox;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.noralsy.connected_mailbox.Mapper")
public class ConnectedMailboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConnectedMailboxApplication.class, args);
    }

}
