package com.ll.springcloud.dao;

import com.ll.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    /**
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
