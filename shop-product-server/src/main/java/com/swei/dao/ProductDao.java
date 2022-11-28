package com.swei.dao;

import com.swei.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-28 17:13
 */
public interface ProductDao extends JpaRepository<Product, Long> {
}
