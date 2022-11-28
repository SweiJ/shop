package com.swei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-28 19:39
 */
@SpringBootApplication
// 下面注解会扫描当前包及其子包下有@FeignClient注解接口
@EnableFeignClients
public class OrderServer {
    public static void main(String[] args) {
        SpringApplication.run(OrderServer.class,args);
    }

//    @Bean
//    // 表示集成ribbon进行负载均衡
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}