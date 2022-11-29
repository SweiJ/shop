package com.swei.feign.fallback;

import com.swei.domain.Product;
import com.swei.feign.ProductFeignApi;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-29 14:10
 */
@Component
public class ProductFeignFallback implements ProductFeignApi {
    @Override
    public Product findByPid(Long pid) {
        System.out.println("返回的兜底数据!");
        return new Product();
    }
}
