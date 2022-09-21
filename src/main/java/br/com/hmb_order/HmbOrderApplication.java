package br.com.hmb_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HmbOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmbOrderApplication.class, args);
    }

}
