package com.swei.feign;

import com.swei.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description: 通过代理类注入到容器, 代理类获取接口和注解信息拼接url并且通过ribbon负载均衡
 *
 * @author: SweiPC
 * @data: 2022-11-28 21:23
 */
@FeignClient(name = "product-service")
public interface ProductFeignApi {
    @RequestMapping("/product/{pid}")
    Product findByPid(@PathVariable("pid") Long pid);
}
