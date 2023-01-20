package com.sau.badmintonhallinformationmanagementsystem.service;

import com.sau.badmintonhallinformationmanagementsystem.bean.Payment;
import com.sau.badmintonhallinformationmanagementsystem.mapper.PaymentMapper;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SRDZ
 * @date 2023/1/14 15:21
 */

@Service
public class PaymentService {

  @Autowired
  private PaymentMapper paymentMapper;

  public int insert(Payment payment){
    payment.setPayTime(new Date(System.currentTimeMillis()));
    return paymentMapper.insert(payment);
  }


}
