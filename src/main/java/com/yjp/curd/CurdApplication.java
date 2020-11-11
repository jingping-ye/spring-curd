package com.yjp.curd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi  //swagger3.0
@MapperScan("com.yjp.curd.dao")
public class CurdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurdApplication.class, args);
    }

}
