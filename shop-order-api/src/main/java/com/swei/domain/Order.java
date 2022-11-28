package com.swei.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-28 19:35
 */
@Entity(name = "t_shop_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //订单id
    private Long oid;
    //⽤户id
    private Long uid;
    //⽤户名
    private String username;
    //商品id
    private Long pid;
    //商品名称
    private String pname;
    //商品单价
    private Double pprice;
    //购买数量
    private Integer number;
}
