package com.swei.dao;

import com.swei.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-28 19:41
 */
public interface OrderDao extends JpaRepository<Order, Long> {
}
