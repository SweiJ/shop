package com.swei.service;

import com.swei.domain.Order;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-28 19:42
 */
public interface OrderService {

    Order createOrder(Long productId, Long userId);
}
