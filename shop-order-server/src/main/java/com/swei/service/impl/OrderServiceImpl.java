package com.swei.service.impl;

import com.alibaba.fastjson.JSON;
import com.swei.dao.OrderDao;
import com.swei.domain.Order;
import com.swei.domain.Product;
import com.swei.feign.ProductFeignApi;
import com.swei.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-28 19:42
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductFeignApi productFeignApi;

    @Override
    public Order createOrder(Long productId, Long userId) {
        log.info("接收到{}号商品的下单请求,接下来调⽤商品微服务查询此商品信息", productId);
        //远程调⽤商品微服务,查询商品信息
//        ServiceInstance instance = discoveryClient.getInstances("product-service").get(0);
//        String host = instance.getHost();
//        int port = instance.getPort();
//        String url = "http://" + host + ":" + port + "/product/" + productId;
//        String url = "http://product-service/product/" + productId;
//        log.info("服务的地址是:{}", url);
//        Product product = restTemplate.getForObject(url, Product.class);
        Product product = productFeignApi.findByPid(productId);
        log.info("查询到{}号商品的信息,内容是:{}", productId, JSON.toJSONString(product));
        //创建订单并保存
        Order order = new Order();
        order.setUid(userId);
        order.setUsername("xiaoJiang");
        order.setPid(productId);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderDao.save(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        return order;
    }
}
