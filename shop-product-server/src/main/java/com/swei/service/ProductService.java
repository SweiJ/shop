package com.swei.service;

import com.swei.domain.Product;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-28 17:15
 */
public interface ProductService {

    Product findByPid(Long pid);
}
