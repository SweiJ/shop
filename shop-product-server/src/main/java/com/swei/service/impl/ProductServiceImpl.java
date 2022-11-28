package com.swei.service.impl;

import com.swei.dao.ProductDao;
import com.swei.domain.Product;
import com.swei.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-28 17:16
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Long pid) {
        return productDao.findById(pid).get();
    }
}